package pnt.co.edu.unisabana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
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
        ImageButton cancel = findViewById(R.id.redx);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(AddUserActivity.this,MainActivity.class);
                startActivity(open);
            }
        });

    }
    private void check(){
        if(carreraDependencia.isChecked()){
            carreraDependencia.setText("Bibliotecario");
        }else{
            carreraDependencia.setText("EstudianteClass");
        }
    }
}
