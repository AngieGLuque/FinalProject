package pnt.co.edu.unisabana;

import java.util.ArrayList;

public class EstudianteClass {
    private final String nombre;
    private final String apellido;
    private final String carrera;
    private final String id;
    private final String email;
    private final String contrasena;
    private static EstudianteClass estudiante;
    public static ArrayList<EstudianteClass> estudiantesArrayList = new ArrayList<>();

    private EstudianteClass(){
        this.nombre = "";
        this.apellido = "";
        this.carrera = "";
        this.id = "";
        this.email = "";
        this.contrasena = "";
    }

    EstudianteClass(String nombre, String apellido, String carrera,String id, String email, String contrasena){
        this.nombre = nombre;
        this.apellido = apellido;
        this.carrera = carrera;
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

    public String getCarrera() {
        return carrera;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }

    public String getContrasena() { return contrasena; }

    static EstudianteClass getInstanceOf(){
        if(estudiante == null){
            estudiante = new EstudianteClass();
        }
        return  estudiante;
    }

}
