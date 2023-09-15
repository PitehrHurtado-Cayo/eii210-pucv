package Ejercicio_1.version_1;

public class GestorAsignatura {
    private Asignatura [] asignaturas;
    private int plibre;
    public GestorAsignatura(int cantidad){
        this.asignaturas = new Asignatura[cantidad];
        this.plibre = 0;
    }

    public boolean agregarAsignatura(String sigla, String nombre, String nomProf, String nomEscuela, int creditos){
        for(int i = 0; i<plibre; i++){
            if(asignaturas[i].getSigla().equals(sigla))
                return false; // si llega aca es porque la asignatura si existe, no agregamos
        }
        // si llega aca es poque no existe la asignatura
        if(plibre<asignaturas.length){
            // si llega aca es porque si hay espacio en el arreglo
            asignaturas[plibre] = new Asignatura(sigla,nombre, nomEscuela, nomProf,creditos);
            plibre++;
            return true;
        }
        // si llega aca es porque no hay espacio
        return false;
    }
    public boolean eliminarAsignatura(String sigla){
        for(int i = 0; i < plibre; i++){
            if(sigla.equals(asignaturas[i].getSigla())){
                // si llega aca es porque si existe y hay que eliminar, supuesto: no importa el orden
                asignaturas[i] = asignaturas[plibre-1];
                plibre--;
                return true;
            }
        }
        // si llega aca es porque no esta la asignatura
        return false;
    }
    public int asignaturasProfesor(String nombreProfesor){
        int contador = 0;
        for(int i = 0; i < plibre; i++){
            if(asignaturas[i].getProfesor().equals(nombreProfesor)){
                // si llegamos aca es porque la asignatura si es dictada por el Profe
                contador++;
            }
        }
        return contador;
    }

    public String mejorEscuela(){
        /*
        Solución propuesta:
        generar dos arreglos coordinados compactos, uno con el nombre de la escuela
        en el otro con la cantidad de creditos totales
         */
        String [] escuelas = new String[asignaturas.length]; // tamaño es el peor caso, donde todas las asignaturas pueden ser de diferentes escuelas
        int [] creditos = new int[asignaturas.length];
        int plibre_aux = 0;

        for(int i = 0 ; i< plibre; i++){
            // por cada aignatura vamos a ver si tenemos "registrado" su escuela
            boolean registrado = false;
            for(int k = 0; k < plibre_aux; k++){
                if(escuelas[k].equals(asignaturas[i].getEscuela())){
                    // si llega aca es porque la asignatura ya esta y sumamos sus creditos
                    creditos[k] += asignaturas[i].getCreditos();
                    registrado = true;
                }
            }
            // si no estaba registrado
            if(!registrado){
                escuelas[plibre_aux] = asignaturas[i].getEscuela();
                creditos[plibre_aux] = asignaturas[i].getCreditos();
                plibre_aux++;
            }
        }

        // a esta altura ya tendremos los arreglos llenos con las escuelas unicas y los creditos por escuela
        // ahora buscamos la escuela
        int mayorCreditos = -1;
        String mayorEscuela = null;
        for(int k = 0 ; k< plibre_aux; k++){
            if(mayorCreditos < creditos[k]){
                mayorEscuela = escuelas[k];
                mayorCreditos = creditos[k];
            }
        }
        // ahora retornamos el mayor
        return mayorEscuela;


    }
}