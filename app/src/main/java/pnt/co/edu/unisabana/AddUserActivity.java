package pnt.co.edu.unisabana;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

public class AddUserActivity extends AppCompatActivity {
    Switch carreraDependencia;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);
        carreraDependencia = findViewById(R.id.bool);
        carreraDependencia.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                check();
            }
        });

    }
    private void check(){
        if(carreraDependencia.isChecked()){
            carreraDependencia.setText("Bibliotecario");
        }else{
            carreraDependencia.setText("Estudiante");
        }
    }
}
