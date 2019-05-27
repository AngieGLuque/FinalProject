package pnt.co.edu.unisabana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class AddUserBibliotecarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user_bibliotecario);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://afternoon-mesa-69524.herokuapp.com/").build();
        final HerokuService service = retrofit.create(HerokuService.class);

        ImageButton cancel = findViewById(R.id.redx2);
        ImageButton register = findViewById(R.id.check);
        final EditText nombre = findViewById(R.id.nombre2);
        final EditText apellido = findViewById(R.id.apellido2);
        final EditText id = findViewById(R.id.identificacion2);
        final EditText email = findViewById(R.id.correo2);
        final EditText direccion = findViewById(R.id.direccion);
        final EditText telefono = findViewById(R.id.telefono);
        final EditText contrasena = findViewById(R.id.password2);
        
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(AddUserBibliotecarioActivity.this, MainActivity.class);
                startActivity(cancel);
            }
        });
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ResponseBody> call =  service.registroBib(nombre.getText().toString(), apellido.getText().toString(), id.getText().toString(), email.getText().toString(), telefono.getText().toString(),direccion.getText().toString(),contrasena.getText().toString());
                if (!nombre.getText().toString().isEmpty() && !apellido.getText().toString().isEmpty() && !id.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !direccion.getText().toString().isEmpty()&& !telefono.getText().toString().isEmpty() && !contrasena.getText().toString().isEmpty()) {
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                Toast.makeText(AddUserBibliotecarioActivity.this, response.body().string(), Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }

                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(AddUserBibliotecarioActivity.this, "Ha ocurrido un error, intente de nuevo.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(AddUserBibliotecarioActivity.this, "Complete todos los campos para registrar el usuario.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
