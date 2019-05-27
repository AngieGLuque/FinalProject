package pnt.co.edu.unisabana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ShowDataActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_data);
        ImageButton cancel = findViewById(R.id.redx);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://afternoon-mesa-69524.herokuapp.com/").build();
        final HerokuService service = retrofit.create(HerokuService.class);

        final TextView user = findViewById(R.id.textType);
        final TextView nombre = findViewById(R.id.textNombre);
        final TextView apellidos = findViewById(R.id.textApellidos);
        final TextView id = findViewById(R.id.textId);
        final TextView correo = findViewById(R.id.textCorreo);
        final TextView textOne = findViewById(R.id.textOne);
        final TextView textTwo = findViewById(R.id.textTwo);


    }
}