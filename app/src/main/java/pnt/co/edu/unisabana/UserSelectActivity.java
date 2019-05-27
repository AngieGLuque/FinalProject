package pnt.co.edu.unisabana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class UserSelectActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_select);
        ImageButton user_Estudiante = (ImageButton) findViewById(R.id.addEstudiante);
        ImageButton user_Bibliotecario = (ImageButton) findViewById(R.id.addBibliotecario);
        user_Estudiante.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(UserSelectActivity.this,AddUserActivity.class);
                startActivity(open);
            }
        });
        user_Bibliotecario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(UserSelectActivity.this,AddUserBibliotecarioActivity.class);
                startActivity(open);
            }
        });
    }
}
