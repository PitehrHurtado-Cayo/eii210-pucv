# Enunciado
Considere la existencia de un tablero de dimensiones NxM (con N y M determinado por el usuario), en donde cada posición representa una **Carpeta virtual**. Cada **carpeta virtual** puede almacenar una cantidad ilimitada de **Archivos**.  
Los **archivos** se identifican por un código (String), poseen nombre (string) y peso en megabytes (double).

Implemente en Java un programa que permita gestionar una matriz de Carpetas Virtuales que individualmente almacenan objetos de la clase Archivo.

La solución debe proveer los siguientes métodos:
- **public boolean agregarArchivo(int i, int j, String cod, String nombre, double peso)**: El método agrega el Archivo a la Carpeta según sus coordenadas i,j, verificando previamente que este Archivo no exista en ninguna carpeta. Retorna true en caso de éxito, o false en caso contrario.
- **public String eliminarArchivo (String cod)**: Elimina el archivo correspondiente según el código ingresado por parámetro, retornando su nombre. En caso de que no exista, retorne “NE”
- **public void vaciarCarpeta(int i, int j)**: Vacía la carpeta asociada a las coordenadas ingresadas.
- **public int[] carpetaPesada()**: Retorna un arreglo de tamaño 2, asociado a cada coordenada (i,j), de la carpeta con mayor peso de todo el sistema. Si no existe ningún Archivo en el sistema, cada posición debe tener el valor de -1.

> existen metodos implicitos en las diferentes clases
