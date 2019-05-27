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
        ImageButton check = findViewById(R.id.check);

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://afternoon-mesa-69524.herokuapp.com/").build();
        final HerokuService service = retrofit.create(HerokuService.class);

        final TextView user = findViewById(R.id.textType);
        final TextView nombre = findViewById(R.id.textNombre);
        final TextView apellidos = findViewById(R.id.textApellidos);
        final TextView id = findViewById(R.id.textId);
        final TextView correo = findViewById(R.id.textCorreo);
        final TextView textOne = findViewById(R.id.textOne);
        final TextView textTwo = findViewById(R.id.textTwo);
        String data = getIntent().getCharSequenceExtra("data").toString();
        String[] dataArray = data.split(",",0);

        nombre.setText("Nombre: " + dataArray[0]);
        apellidos.setText("Apellidos: "+ dataArray[1]);
        id.setText("ID: "+dataArray[2]);
        correo.setText("Correo: "+dataArray[3]);
        if(dataArray[5].equals(" ")){
            user.setText("Estudiante");
            textOne.setText("Carrera: "+dataArray[4]);
        }else{
            user.setText("Bibliotecario");
            textOne.setText("Telefono: "+dataArray[4]);
            textTwo.setText("Direccion"+dataArray[5]);
        }
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cancel = new Intent(ShowDataActivity.this,LoginActivity.class);
                startActivity(cancel);
            }
        });
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(user.getText().equals("Bibliotecario")){
                    Intent cancel = new Intent(ShowDataActivity.this,LoginActivity.class);
                    startActivity(cancel);
                    Intent check = new Intent(ShowDataActivity.this, FuncionesBibliotecarioActivity.class);
                    startActivity(check);
                }else{
                    Intent cancel = new Intent(ShowDataActivity.this,LoginActivity.class);
                    startActivity(cancel);
                    Intent check = new Intent(ShowDataActivity.this, FuncionesEstudianteActivity.class);
                    startActivity(check);
                }

            }
        });
    }
}