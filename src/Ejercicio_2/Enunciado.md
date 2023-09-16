# Enunciado

Considerando el éxito de ventas de "X", el presidente del centro de estudiantes, "Y", le pide a usted generar  
un programa en Java capaz de almacenar una cantidad ilimitada de estudiantes para llevar el registro de  
las entradas vendidas para "X_2", puesto que es incapaz de estimar la cantidad de entradas que se venderán.

Dentro de la información que se le solicita al estudiante, se necesita su Rut (String), nombre (String), generación (String), si necesita bus o no (boolean), casilla de comprobante de pago (boolean), y un tipo de menú (String, “O”:Omnívoro, “V”:Vegetariano, “VN”:Vegano)

"Y" le solicita que el programa realice las siguientes funciones:
- **public boolean venderEntrada(String rut, String nombre, String generacion, boolean bus, String menu)**: El método agrega al estudiante a la lista, retornando false en caso de que el estudiante haya sido agregado previamente, true en caso de éxito.
- **public boolean reembolso(String rut)**: Elimina una venta del registro. Retorna true en caso de éxito, false en caso contrario.
- **public boolean registrarComprobante(String rut)**: Este método marca la casilla de comprobante de pago del estudiante, volviéndola true. Retorna true en caso de que la venta exista, false en caso contrario.
- **public boolean comenzarPaseo()**: Este método retorna true en caso de que todas las entradas vendidas hayan sido pagadas, es decir, que sus casillas de comprobante de pago tiene valor true. Retorna false en caso contrario.
- **public String mejorGeneracion()**: Retorna la generación con mayor número de entradas vendidas. (No es relevante si la entrada está pagada)
  
Para esto, implemente las clases GestorEntradas, NodoEntrada y Entrada. Se recomienda el uso de Nodo Fantasma. Respete el nombre especificado para los métodos y las clases.

Por último unos desafios:

- **public int ventasEsperadas()**: El método retorna los ingresos esperados por todas las ventas actuales. Se sabe que una entrada con bus vale $35.000 y una sin bus, $30.000.
- **public int[] menus()**: El método retorna un arreglo tipo int de largo 3. En la primera posición entrega la cantidad de menús omnívoros, en la segunda los vegetarianos y en la última los veganos. (No es relevante si la entrada está pagada)
- **public int ingresosFaltantes()**: El método retorna la diferencia entre los ingresos de las ventas esperadas con las actuales, es decir, cuánto dinero aún no le es pagado al centro de estudiantes..