package pnt.co.edu.unisabana;

import java.util.ArrayList;

public class BibliotecarioClass {
    private final String nombre;
    private final String apellido;
    private final String dependencia;
    private final int id;
    private final String email;
    private final String contrasena;

    private static BibliotecarioClass bibliotecario;
    public static ArrayList<BibliotecarioClass> bibliotecarios = new ArrayList<>();

    private BibliotecarioClass(){
        this.nombre = "";
        this.apellido = "";
        this.dependencia = "";
        this.id = 0;
        this.email = "";
        this.contrasena = "";
    }

    BibliotecarioClass(String nombre, String apellido, String dependencia,int id, String email, String contrasena){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dependencia = dependencia;
        this.id = id;
        this.email = email;
        this.contrasena = contrasena;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getDependencia() {
        return dependencia;
    }

    public int getId(){ return id;}

    public String getEmail() {
        return email;
    }

    public String getContrasena() {
        return contrasena;
    }

    static BibliotecarioClass getInstanceOf(){
        if(bibliotecario == null){
            bibliotecario = new BibliotecarioClass();
        }
        return  bibliotecario;
    }

}

