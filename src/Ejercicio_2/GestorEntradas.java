package Ejercicio_2;

public class GestorEntradas {
    private NodoEntrada head;

    public GestorEntradas(){
        this.head = new NodoEntrada(null, null); // haremos uso de NODO FANTASMA
    }
    public boolean venderEntrada(String rut, String nombre, String generacion, boolean bus, String menu){
        // verificar que no exista el estudiante
        NodoEntrada aux = head;
        while(aux.getNext()!= null){
            if (aux.getNext().getDato().getRut().equals (rut)){
                // si llega aca es porque el "rut" ya existe en mi lista, no podemos agregar
                return false;
            }
            aux = aux.getNext();
        }
        // si llegamos aca es porque no existe el "rut" y debemos agregar
        Entrada nuevo = new Entrada(rut, generacion, nombre, bus, menu);
        aux.setNext(new NodoEntrada (nuevo,null));
        return true;
    }
    public boolean reembolso(String rut){
        NodoEntrada aux = head;
        while (aux.getNext()!=null){
            if(aux.getNext().getDato().getRut().equals(rut)){
                // si llega aca entonces lo encontro y debemos eliminar
                aux.setNext(aux.getNext().getNext());
                return true;
            }
            aux = aux.getNext();
        }
        // si llega aca es porque buscó y no lo encontro en la lista
        return false;
    }
    public boolean registrarComprobante(String rut){
        NodoEntrada aux = head; // OPCIONAL: podriamos partir directamente en head.getNext(), dado que no es necesario estar un paso atras
        while (aux.getNext()!=null){
            if(aux.getNext().getDato().getRut().equals(rut)){
                // si llega aca es porque lo encontró y ahora hace un set al Pago a True
                aux.getNext().getDato().setPagoRealizado(true);
                return true;
            }
            aux = aux.getNext();
        }
        // si llega aca es porque buscó y no lo encontro en la lista
        return false;
    }
    public boolean comenzarPaseo(){
        NodoEntrada aux = head.getNext(); // OPCIONAL: podemos usar solo head
        while(aux!=null){
            if(aux.getDato().esPagoRealizado() == false)
                //si llega aca es porque la entrada actual no tiene el pago, por lo que no se puede comenzar el paseo.
                return false;
            aux = aux.getNext();
        }
        // si llega aca quiere decir que todos tiene el pago realizado
        return true;
    }

    public String mejorGeneracion(){
        /*
        Solución propuesta:
        - existen varias formas de hacerlo pero creo que la ida es hacer una busqueda exhaustiva, es decir todos con todos
        por cada Nodo recorreremos toda la lista contando todas las que tengan la misma generacion, y luego actualizaremos nuestro "mayor"
         */
        int mayorEntradas = -1; // parte con un numero muy ridiculo
        String mayorGeneracion = null;

        NodoEntrada aux = head.getNext(); // podemos partir de head.getNext o simplemente head, dado que no es requisito estar un paso atras
        while(aux!=null){
            // por cada valord e AUX vamos a recorrer toda la lista con AUX_2
            int cantidad = 0;
            String generacionActual = aux.getDato().getGeneracion();

            NodoEntrada aux_2 = head.getNext();
            while(aux_2 != null){
                if(aux_2.getDato().getGeneracion().equals(generacionActual))
                    cantidad++;
                aux_2 = aux_2.getNext();
            }
            // despues de contar vemos si es mayor a nuestro mayor ACTUAL
            if(cantidad > mayorEntradas){
                // si llega aca entonces encontramos una generacion que tiene mas entradas que la actual
                mayorEntradas = cantidad;
                mayorGeneracion = generacionActual;
            }
            aux = aux.getNext();
        }
        return mayorGeneracion;
    }

    public int ventasEsperadas(){
        // supuesto: como son ventas esperadas entonces no nos fijaremos si ya se pagó la entrada o no
        int cantEntradaConBus = 0;
        int cantEntradaSinBus = 0;

        NodoEntrada actual = head.getNext(); // aca nuevamente no es neceasrio estar un paso atras, podria ser iguald e correcto partir con head, solo cambiaria la condicion del while
        while(actual!=null){
            if(actual.getDato().necesitaBus()){
                cantEntradaConBus++;
            }else{
                cantEntradaSinBus++;
            }
            actual = actual.getNext();
        }
        return cantEntradaConBus * 35_000 + cantEntradaSinBus * 30_000;
    }

    public int[] menus(){
        int [] cantidadMenus = new int[3]; // 0-O, 1-Vegetarianos, 2-Veganos
        NodoEntrada actual = head.getNext(); // aca nuevamente no es neceasrio estar un paso atras, podria ser iguald e correcto partir con head
        while(actual!=null){
            String tipoMenuActual = actual.getDato().getMenu();
            switch (tipoMenuActual){ // podrias reemplazar este switch por estructura IF-ELSE
                case "O":
                    cantidadMenus[0]++;
                    break;
                case "V":
                    cantidadMenus[1]++;
                    break;
                case "VN":
                    cantidadMenus[2]++;
                    break;
            }
            actual = actual.getNext();
        }
        return cantidadMenus;
    }

    public int ingresosFaltantes(){
        /*
        Solucion propuesta:
        - haremos uso del metodo ventasEsperadas, dado que esta contabiliza todas las entradas vendidas, retorna total $
        - creamos un nuevo metodo, ventasActuales, que contabiliza el $ de las entradas ya pagadas, retorna total $ pagado
         */
        return ventasEsperadas() - ventasActuales(); // retornamos la diferencia de ambos.
    }

    // METODO AUXILIAR - idea similar a la de ventasEsperadas
    public int ventasActuales(){
        // supuesto: como son ventas ACTUALES entonces nos fijaremos si ya se pagó la entrada o no
        int cantEntradaConBus = 0;
        int cantEntradaSinBus = 0;

        NodoEntrada actual = head.getNext();
        while(actual!=null){
            if(actual.getDato().esPagoRealizado()) { // si ya esta pagado recien cuento si necesita o no bus
                if (actual.getDato().necesitaBus()) {
                    cantEntradaConBus++;
                } else {
                    cantEntradaSinBus++;
                }
            }
            actual = actual.getNext();
        }
        return cantEntradaConBus * 35_000 + cantEntradaSinBus * 30_000;
    }
}
