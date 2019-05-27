package pnt.co.edu.unisabana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FuncionesBibliotecarioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funciones_bibliotecario);
        Button registrar = findViewById(R.id.registrar);
        Button consultar = findViewById(R.id.consultar);
        Button actualizar = findViewById(R.id.actualizar);
        Button eliminar = findViewById(R.id.eliminar);
        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrar = new Intent(FuncionesBibliotecarioActivity.this, RegistrarLibroActivity.class);
                startActivity(registrar);
            }
        });
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consultar = new Intent(FuncionesBibliotecarioActivity.this, ConsultaBibliotecarioActivity.class);
                startActivity(consultar);
            }
        });
        actualizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actualizar = new Intent(FuncionesBibliotecarioActivity.this, ActualizarDatosLibroActivity.class);
                startActivity(actualizar);
            }
        });
        eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent eliminar = new Intent(FuncionesBibliotecarioActivity.this, EliminarLibroActivity.class);
                startActivity(eliminar);
            }
        });

    }
}
