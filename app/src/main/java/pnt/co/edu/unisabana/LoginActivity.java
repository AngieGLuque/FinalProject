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

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageButton cancel = findViewById(R.id.cancel);
        ImageButton login = findViewById(R.id.check);

        final EditText loginEmail = findViewById(R.id.correoLogin);
        final EditText loginPassword = findViewById(R.id.passwordLogin);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://afternoon-mesa-69524.herokuapp.com/").build();
        final HerokuService service = retrofit.create(HerokuService.class);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(cancel);
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Call<ResponseBody> call = service.login(loginEmail.getText().toString(),loginPassword.getText().toString());
                if(!loginEmail.getText().toString().isEmpty() && !loginPassword.getText().toString().isEmpty()){
                call.enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        String data = null;
                        try {
                            data = response.body().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        if(data != ""){
                            Intent login = new Intent(LoginActivity.this,ShowDataActivity.class);
                            login.putExtra("data",data);
                            startActivity(login);
                        }else{
                            Toast.makeText(LoginActivity.this, "Ha ocurrido un error, intente de nuevo", Toast.LENGTH_SHORT).show();

                        }
                    }
                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Toast.makeText(LoginActivity.this, "Ha ocurrido un error, intente de nuevo", Toast.LENGTH_SHORT).show();
                    }
                });
            }else{
                    Toast.makeText(LoginActivity.this, "Ingrese todos los datos para entrar.", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
