package Ejercicio_3;

public class GestorCarpeta {
    private CarpetaVirtual [][] carpetas;

    public GestorCarpeta(int n , int m){
        this.carpetas = new CarpetaVirtual[n][m];
        /*
        Por simplicidad es mejor instanciar todas las posiciones, es decir en cada i,j crear un objeto carpeta virtual
         */
        for(int i = 0; i < n; i++){
            for(int j = 0 ; j<m; j++){
                this.carpetas[i][j] = new CarpetaVirtual();
            }
        }
    }

    public boolean agregarArchivo(int i, int j, String cod, String nombre, double peso){
        // creamos el objeto Archivo
        Archivo nuevo = new Archivo(cod,nombre,peso);

        // verificamos que no exista en NINGUNA CARPETA
        for(int fila = 0; fila < carpetas.length; fila++){
            for(int columna = 0 ; columna < carpetas[fila].length; columna++){
                if(carpetas[fila][columna].existeArchivo(nuevo))
                    // si llega aca es porque la carpeta en la fila y columna contiene el archivo, no agregamos
                    return  false;
            }
        }
        // si llega aca es porque ninguna carpeta contiene el archivo, entonces agregamos en la posicion indicada
        return carpetas[i][j].agregarArchivo(nuevo);
    }

    public String eliminarArchivo (String cod){
        // debemos recorrer toda la matrix y "tratar" de eliminar en cada carpeta
        // si recorremos toda la matrix y aun asi tenemos null al aplicar metodo de carpeta eliminarArchivo
        // entonces el archivo no esta y retornamos 'NE'
        for(int i = 0; i < carpetas.length; i++){
            for(int j = 0 ; j < carpetas[i].length; j++){
                String eliminado = carpetas[i][j].eliminarArchivo(cod);
                if(eliminado != null){
                    // si llega aca es porque lo encontramos y lo eliminó
                    return eliminado;
                }
            }
        }
        // si llega aca es porque no lo encontro y no lo eliminó
        return "NE";
        /*
        Existen varias formas de hacerlo, por ejemplo haciendo uso de otro metodo que busque en todas las carpetas,
        si retorna false inmediatamente retornamos 'NE'
        O tbm pudieron usar el metodo existeArchivo de la clase carpeta
        varias formas de hacer este metodo
         */
    }

    public void vaciarCarpeta(int i, int j){
        // no lo pide, pero seria bueno validar los coordenadas
        if( i < carpetas.length && j < carpetas[i].length){
            carpetas[i][j].vaciarCarpeta();
        }
    }

    public int[] carpetaPesada(){
        // nos piden buscar las coordendas de la carpeta con mayor peso
        int coordenadas [] = {-1, -1}; // podemos instanciar un arreglo de esta forma literal u ocupar el new int[2] y luego dar valores -1
        double mayorPeso = -1;

        for(int i = 0; i < carpetas.length; i++){
            for(int j = 0 ; j < carpetas[i].length; j++){
                // por cada carpeta en la posicion i,j preguntaremos si su peso es mayor a mi peso actual
                double peso = carpetas[i][j].tamañoCarpeta();
                if(peso > mayorPeso){
                    // si llega aca es porque encontramos una carpeta que tiene mayor peso a mi peso actual
                    // guardamos coordenadas y actualizamos peso actual
                    mayorPeso = peso;
                    coordenadas[0] = i;
                    coordenadas[1] = j;
                }
            }
        }
        return coordenadas;
    }
}
