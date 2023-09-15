package Ejercicio_1.version_2;

public class Asignatura {
    private String sigla;
    private String nombre;
    private String escuela;
    private String profesor;
    private int creditos;

    public Asignatura(String sigla, String nombre, String escuela, String profesor, int creditos){
        this.sigla=sigla;
        this.nombre=nombre;
        this.escuela=escuela;
        this.profesor=profesor;
        this.creditos=creditos;
    }
    public String getSigla() {
        return sigla;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEscuela() {
        return escuela;
    }

    public String getProfesor() {
        return profesor;
    }

    public int getCreditos() {
        return creditos;
    }
}