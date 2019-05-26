package pnt.co.edu.unisabana;

import java.util.ArrayList;

public class LibroClass {
    private final String titulo;
    private final String autor;
    private final String issn;
    private final String keyWords;
    private final int unidades;
    private final String resumen;

    private static LibroClass libro;
    public static  ArrayList<LibroClass> libros = new ArrayList<>();

    private LibroClass(){
        this.titulo = "";
        this.autor = "";
        this.issn = "";
        this.keyWords = "";
        this.unidades = 0;
        this.resumen = "";
    }

    LibroClass(String titulo, String autor, String issn, String keyWords, int unidades, String resumen){
        this.titulo = titulo;
        this.autor = autor;
        this.issn = issn;
        this.keyWords = keyWords;
        this.unidades = unidades;
        this.resumen = resumen;
    }

    public String getTitulo(){ return titulo;}

    public String getAutor(){ return  autor;}

    public String getIssn(){ return issn;}

    public String getKeyWords(){ return  keyWords;}

    public int getUnidades(){ return unidades;}

    public String getResumen(){ return  resumen;}

    static LibroClass getInstanceOf(){
        if(libro == null){
            libro = new LibroClass();
        }
        return  libro;
    }
}
