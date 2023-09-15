## Enunciado
La universidad, debido a la actualización del aula virtual, lo invita a participar de la gestión de la información de las asignaturas del sistema.  
Las **asignaturas** se identifican por una sigla, poseen nombre, escuela, profesor a cargo (todos String) y créditos (int).

Asimismo, el sistema debe ser capaz de realizar las siguientes funciones:
- **public boolean agregarAsignatura(String sigla, String nombre, String nomProf, String nomEscuela, int creditos)**: Este método agrega una asignatura a la estructura, retornando true en caso de éxito, y false en caso de que la asignatura ya esté agregada.
- **public boolean eliminarAsignatura(String sigla)**: Elimina la asignatura correspondiente a la sigla recibida por parámetro. En caso de éxito retorna true, y false en caso contrario (no existe).
- **public int asignaturasProfesor(String nombreProfesor)**: El método retorna el número de asignaturas que tiene el profesor recibido por parámetro.
- **public String mejorEscuela()**: Este método retorna el nombre de la escuela que más créditos asociados tiene, es decir, que la suma de los créditos de las asignaturas que dicta, es mayor al del resto de escuelas. Retorna null en caso de que no existan asignaturas.

> Versión 1:
> Implemente esta solución en Java a través de un **arreglo compacto** almacenado en la clase GestorAsignaturas, agregando la condición en el método agregarAsignatura, de fracaso en caso de arreglo lleno. La capacidad del arreglo debe ser solicitada en el constructor de la clase GestorAsignaturas.

> Versión 2:
> Implemente esta solución en Java a través de una lista simplemente enlazada almacenada en la clase GestorAsignaturas. Para esto, cree además la clase NodoAsignatura.
