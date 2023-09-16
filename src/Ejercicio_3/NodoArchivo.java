package Ejercicio_3;

public class NodoArchivo {
    private Archivo dato;
    private NodoArchivo next;

    public NodoArchivo(Archivo a, NodoArchivo next) {
        this.dato = a;
        this.next = next;
    }

    public Archivo getDato() {
        return dato;
    }

    public void setDato(Archivo a) {
        this.dato = a;
    }

    public NodoArchivo getNext() {
        return next;
    }

    public void setNext(NodoArchivo next) {
        this.next = next;
    }

}