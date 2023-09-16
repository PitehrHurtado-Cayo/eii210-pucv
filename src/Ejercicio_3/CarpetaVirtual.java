package Ejercicio_3;

public class CarpetaVirtual {
    private NodoArchivo head;

    /*
    podriamos agregar otros atributos: peso total de Carpeta -> el cual nos ayudaria a acortar metodos solicitados
    tail -> para facilitar agregar
     */

    public CarpetaVirtual(){
        head = new NodoArchivo(null, null); // haremos uso de nodo fantasma
    }

    public boolean agregarArchivo(Archivo obj){
        if(existeArchivo(obj)){
            return false;
        }

        NodoArchivo aux = head;
        while(aux.getNext()!=null){
            aux=aux.getNext();
        }
        aux.setNext(new NodoArchivo(obj, null));
        return true;
    }

    public boolean existeArchivo(Archivo obj){
        NodoArchivo actual = head.getNext(); // es opcional si nos paramos en head o head.getNext
        while(actual!=null){
            if(actual.getDato().getCodigo().equals(obj.getCodigo()))
                return true; // existe el archivo

            actual=actual.getNext();
        }
        return false; // no existe
    }

    public String eliminarArchivo(String codigo){
        NodoArchivo actual = head; // aca si es necesario pararnos en head
        while(actual.getNext()!=null){
            if(actual.getNext().getDato().getCodigo().equals(codigo)){
                String nombreEliminado = actual.getNext().getDato().getNombre();
                actual.setNext(actual.getNext().getNext());
                return nombreEliminado;
            }
            actual=actual.getNext();
        }
        return null; // si no existe retorna null
    }

    public void vaciarCarpeta(){
        head = new NodoArchivo(null, null);
        // solucion es perder la referencia del head para que se pierda toda la lista
    }

    public double tamañoCarpeta(){
        double pesoTotal = 0.0;
        NodoArchivo actual = head.getNext(); // es opcional estar en head o head.getNext
        while(actual!=null){
            pesoTotal += actual.getDato().getPesoMega();
            actual = actual.getNext();
        }
        return pesoTotal;
    }
}
