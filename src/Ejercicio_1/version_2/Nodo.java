package Ejercicio_1.version_2;

public class Nodo {
    private Nodo next;
    private Asignatura dato;

    public Nodo(Asignatura dato, Nodo next){
        this.dato = dato;
        this.next = next;
    }
    public Nodo getNext(){
        return this.next;
    }
    public void setNext(Nodo next){
        this.next = next;
    }
    public Asignatura getDato(){
        return this.dato;
    }
}
