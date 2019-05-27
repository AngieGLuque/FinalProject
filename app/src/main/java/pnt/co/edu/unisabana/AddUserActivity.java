package pnt.co.edu.unisabana;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class AddUserActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://afternoon-mesa-69524.herokuapp.com/").build();
        final HerokuService service = retrofit.create(HerokuService.class);

        ImageButton cancel = findViewById(R.id.redx);
        ImageButton register = findViewById(R.id.check);
        final EditText nombre = findViewById(R.id.nombre);
        final EditText apellido = findViewById(R.id.apellido);
        final EditText id = findViewById(R.id.identificacion);
        final EditText email = findViewById(R.id.correo);
        final EditText carrera = findViewById(R.id.carrera);
        final EditText contrasena = findViewById(R.id.password);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(AddUserActivity.this, MainActivity.class);
                startActivity(cancel);
            }
        });
            register.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Call<ResponseBody> call = service.registroEst(nombre.getText().toString(), apellido.getText().toString(), id.getText().toString(), email.getText().toString(), carrera.getText().toString(), contrasena.getText().toString());
                    if (!nombre.getText().toString().isEmpty() && !apellido.getText().toString().isEmpty() && !id.getText().toString().isEmpty() && !email.getText().toString().isEmpty() && !carrera.getText().toString().isEmpty() && !contrasena.getText().toString().isEmpty()) {
                        call.enqueue(new Callback<ResponseBody>() {
                            @Override
                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                try {
                                    Toast.makeText(AddUserActivity.this, response.body().string(), Toast.LENGTH_LONG).show();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }

                            @Override
                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                Toast.makeText(AddUserActivity.this, "Ha ocurrido un error, intente de nuevo.", Toast.LENGTH_SHORT).show();
                            }
                        });
                    }else{
                        Toast.makeText(AddUserActivity.this, "Complete todos los campos para registrar el usuario.", Toast.LENGTH_SHORT).show();

                    }
                }
            });
        }
    }
