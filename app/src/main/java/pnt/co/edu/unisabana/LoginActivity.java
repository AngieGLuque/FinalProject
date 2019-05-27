package pnt.co.edu.unisabana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

public class LoginActivity extends AppCompatActivity {

    public static String sessionEmail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageButton cancel = findViewById(R.id.cancel);
        ImageButton login = findViewById(R.id.check);

        final EditText loginEmail = findViewById(R.id.correoLogin);
        EditText loginPassword = findViewById(R.id.passwordLogin);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent open = new Intent(LoginActivity.this,MainActivity.class);
                startActivity(open);
            }
        });
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent login = new Intent(LoginActivity.this,ShowDataActivity.class);
                LoginActivity.sessionEmail = loginEmail.getText().toString();
                startActivity(login);
            }
        });
    }
}
