package Ejercicio_1.version_2;

import Ejercicio_1.version_2.*;

public class GestorAsignatura {
    private Nodo head;
    // NO USAREMOS NODO FANTASMA
    // NO USAREMOS TAIL

    public GestorAsignatura(){
        head = null;
    }

    public boolean agregarAsignatura(String sigla, String nombre, String nomProf, String nomEscuela, int creditos){
        Asignatura nuevo = new Asignatura(sigla, nombre, nomEscuela, nomProf,creditos);
        // verificamos que no haya lista
        if(head == null){
            head = new Nodo(nuevo, null);
            return true;
        }
        // verificamos que no este repetido
        Nodo aux = head;

        // validamos que el head no tenga el dato.
        if(aux.getDato().getSigla().equals(sigla))
            return false;
        while(aux.getNext() != null){
            // para poder agregar es mejor pararnos una posicion atras, por eso validamos siempre .getNext
            if(aux.getNext().getDato().getSigla().equals(sigla)){
                return false; // si llega aca es porque ya estaba agregado
            }
            aux = aux.getNext();
        }
        // si llega aca es porque no estaba agregado y AUX esta parado en el ultimo NODO
        // por lo tanto agregamos el NODO
        aux.setNext(new Nodo(nuevo, null));
        return true;
    }

    public boolean eliminarAsignatura (String sigla) {
        if (head.getDato().getSigla().equals(sigla)) {
            // pregunto si el dato esta en el head
            head = head.getNext(); // lo elimino
            return true;
        }
        // si no esta en el head debo buscar en el resto
        Nodo aux = head;
        while (aux.getNext() != null){
            if (aux.getNext().getDato().getSigla().equals(sigla)) {
                // si llega aca es porque .getNext es el que busco y debo eliminarlo
                aux.setNext(aux.getNext().getNext());
                return true;
            }
            aux = aux.getNext();
        }
        return false;
    }

    public int asignaturasProfesor(String nombreProfesor){
        int cont = 0;
        Nodo aux=head;
        // aca reviso cada nodo donde estoy parado, dado que no quiero eliminar o agregar, por lo que no es necesario que este antes y revisar .getNext

        while(aux!=null){
            if(aux.getDato().getProfesor().equals(nombreProfesor)){
                // si llega aca es porque aux tiene una asignatura con el profesore que estoy buscando
                cont++;
            }
            aux=aux.getNext();
        }
        return cont;
    }

    public String mejorEscuela(){
        /*
        Solución Propuesta: podriamos hacer lo mismo que la solucion de la Version 1, pero la idea es dar mas opciones
        Otra opcion es ir de forma agresiva a contar todos con todos, es decir, por cada nodo recorrere toda la lista para sumar los creditos

        Desventaja: posiblemente tendre muchas iteraciones innecesarias y que se repita la escuela con la misma cantidad de creditos
         */
        int mayorCreditos = -1;
        String mayorEscuela = null;

        Nodo aux_1 = head;
        while(aux_1 != null){
            // por cada uno de ellos recorreremos toda la lista para sumar todos los creditos de la escuela de AUX_1
            String escuelaSeleccionada = aux_1.getDato().getEscuela();
            Nodo aux_2 = head;
            int creditosTotales = 0;
            while(aux_2!=null){
                if(aux_2.getDato().getEscuela().equals(escuelaSeleccionada)){
                    creditosTotales += aux_2.getDato().getCreditos();
                }
                aux_2 = aux_2.getNext();
            }
            // ahora pregunto si es mayor al que ya tengo
            if(mayorCreditos < creditosTotales){
                // si llega aca actualizo
                mayorEscuela = escuelaSeleccionada;
                mayorCreditos = creditosTotales;
            }
        }
        return mayorEscuela;
    }
}
