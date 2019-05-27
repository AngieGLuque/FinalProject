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

public class RegistrarLibroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_libro);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://afternoon-mesa-69524.herokuapp.com/").build();
        final HerokuService service = retrofit.create(HerokuService.class);


        ImageButton cancel = findViewById(R.id.redx3);
        ImageButton register = findViewById(R.id.check3);

        final EditText titulo = findViewById(R.id.titulo);
        final EditText autor = findViewById(R.id.autor);
        final EditText resumen = findViewById(R.id.resumen);
        final EditText unidades = findViewById(R.id.unidades);
        final EditText issn = findViewById(R.id.issn);
        final EditText palabras = findViewById(R.id.palabras);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(RegistrarLibroActivity.this, MainActivity.class);
                startActivity(cancel);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ResponseBody> call = service.registroBib(titulo.getText().toString(), autor.getText().toString(), resumen.getText().toString(), unidades.getText().toString(), issn.getText().toString(), palabras.getText().toString());
                if (!titulo.getText().toString().isEmpty() && !autor.getText().toString().isEmpty() && !resumen.getText().toString().isEmpty() && !unidades.getText().toString().isEmpty()  && !issn.getText().toString().isEmpty() && !palabras.getText().toString().isEmpty()) {
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                Toast.makeText(RegistrarLibroActivity.this, response.body().string(), Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(RegistrarLibroActivity.this, "Ha ocurrido un error, intente de nuevo.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(RegistrarLibroActivity.this, "Complete todos los campos para registrar el usuario.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    }
}
