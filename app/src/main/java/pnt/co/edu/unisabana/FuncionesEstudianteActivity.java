package pnt.co.edu.unisabana;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FuncionesEstudianteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_funciones_estudiante);
        Button registrarPrestamo = findViewById(R.id.registroEst);
        Button listar = findViewById(R.id.listar);
        Button consultar = findViewById(R.id.consultar);
        Button actualizarDatos = findViewById(R.id.actualizarDatos);
        Button renovar = findViewById(R.id.renovar);

        registrarPrestamo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registrarPrestamo = new Intent(FuncionesEstudianteActivity.this, RegistrarPrestamoActivity.class);
                startActivity(registrarPrestamo);
            }
        });
        listar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent listar = new Intent(FuncionesEstudianteActivity.this, ListarDatosActivity.class);
                startActivity(listar);
            }
        });
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent consultar = new Intent(FuncionesEstudianteActivity.this, ConsultarLibrosActivity.class);
                startActivity(consultar);
            }
        });
        actualizarDatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actualizarDatos = new Intent(FuncionesEstudianteActivity.this, ActualizarDatosEstudianteActivity.class);
                startActivity(actualizarDatos);
            }
        });
        renovar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent renovar = new Intent(FuncionesEstudianteActivity.this, RenovarPrestamoActivity.class);
                startActivity(renovar);
            }
        });

    }
}
