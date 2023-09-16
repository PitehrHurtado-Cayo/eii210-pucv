package Ejercicio_3;

public class Archivo {
    private String codigo;
    private String nombre;
    private double pesoMega;

    public Archivo(String codigo, String nombre, double pesoMega) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pesoMega = pesoMega;
    }


    public String getCodigo() {
        return codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPesoMega() {
        return pesoMega;
    }

}
