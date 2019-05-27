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

public class RegistrarPrestamoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_prestamo);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://afternoon-mesa-69524.herokuapp.com/").build();
        final HerokuService service = retrofit.create(HerokuService.class);

        ImageButton cancel = findViewById(R.id.cancel);
        ImageButton register = findViewById(R.id.register);

        final EditText issn = findViewById(R.id.issnPrestamo);
        final EditText fecha = findViewById(R.id.fechaPrestamo);
        final EditText id = findViewById(R.id.idPrestamo);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(RegistrarPrestamoActivity.this, FuncionesEstudianteActivity.class);
                startActivity(cancel);
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ResponseBody> call = service.registroPres(issn.getText().toString(), fecha.getText().toString(), Integer.parseInt(id.getText().toString()));
                if (!issn.getText().toString().isEmpty() && !fecha.getText().toString().isEmpty() && !id.getText().toString().isEmpty()) {
                    call.enqueue(new Callback<ResponseBody>() {
                        @Override
                        public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                            try {
                                Toast.makeText(RegistrarPrestamoActivity.this, response.body().string(), Toast.LENGTH_LONG).show();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        @Override
                        public void onFailure(Call<ResponseBody> call, Throwable t) {
                            Toast.makeText(RegistrarPrestamoActivity.this, "Ha ocurrido un error, intente de nuevo.", Toast.LENGTH_SHORT).show();
                        }
                    });
                }else{
                    Toast.makeText(RegistrarPrestamoActivity.this, "Complete todos los campos para registrar el usuario.", Toast.LENGTH_SHORT).show();

                }
            }
        });


    }
}
