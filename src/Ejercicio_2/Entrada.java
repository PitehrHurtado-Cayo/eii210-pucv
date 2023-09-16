package Ejercicio_2;

public class Entrada {
    private String rut;
    private String nombre;
    private String generacion;
    private boolean necesitaBus;
    private boolean pagoRealizado;
    private String menu;

    public Entrada(String rut, String nombre, String generacion, boolean bus, String menu) {
        this.rut = rut;
        this.generacion = generacion;
        this.necesitaBus = bus;
        this.nombre=nombre;
        this.pagoRealizado=false; // supuesto: cuando se genera la compra de entrada aun no se verifica el pago
        this.menu = menu;
    }

    public String getRut() {
        return rut;
    }

    public String getGeneracion() {
        return generacion;
    }

    public boolean necesitaBus() {
        return necesitaBus;
    }

    public boolean esPagoRealizado() {
        return this.pagoRealizado;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMenu() {
        return menu;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setGeneracion(String generacion) {
        this.generacion = generacion;
    }

    public void setNecesitaBus(boolean bus) {
        this.necesitaBus = bus;
    }

    public void setPagoRealizado(boolean pago) {
        this.pagoRealizado = pago;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

}