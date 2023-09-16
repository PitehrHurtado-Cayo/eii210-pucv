package Ejercicio_2;

public class NodoEntrada {
    private Entrada dato;
    private NodoEntrada next;

    public NodoEntrada(Entrada e, NodoEntrada next) {
        this.dato = e;
        this.next = next;
    }

    public void setDato(Entrada e) {
        this.dato = e;
    }

    public void setNext(NodoEntrada next) {
        this.next = next;
    }

    public Entrada getDato() {
        return this.dato;
    }

    public NodoEntrada getNext() {
        return next;
    }

}

