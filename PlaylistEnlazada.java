
    import java.util.Scanner;

    public class PlaylistEnlazada { // Clase principal; coincide con el nombre del archivo.

        // ===== CLASE NODO =====

        static class Nodo { // inicia y define una clase estática nodo	

            String cancion; //  es el valor de la variable del nodo	

            Nodo siguiente; // es el enlace siguiente del nodo	

            Nodo(String cancion) { // es la definición del método para asignar un valor a un nuevo nodo

                this.cancion = cancion; // es la asignación de la variable canción al nodo	

                this.siguiente = null; // Inicialmente el nodo no apunta a otro.
            } // Finaliza el constructor.

        } // Finaliza la clase Nodo.

        // ===== CABEZA DE LA LISTA =====

        static Nodo cabeza = null; // La lista empieza vacía, sin primer nodo.

        // ===== MÉTODO AGREGAR =====

        static void agregar(String cancion) { // Agrega una canción al final de la lista.

            Nodo nuevo = new Nodo(cancion); // asigna un nuevo nodo 

            if (cabeza == null) { // Comprueba si la lista está vacía.

                cabeza = nuevo; //  asigna a cabeza el nodo creado 

                System.out.println("Canción agregada correctamente."); // Confirma la operación.

                return; // devuelve la operacion fuera del if
            } // Finaliza la condición.

            Nodo temporal = cabeza; //  selecciona el nodo cabeza y lo asigna  como el temporal

            while (temporal.siguiente != null) { // Repite mientras exista otro nodo.

                temporal = temporal.siguiente; // asigna a la bariable temporal el valor del nodo en la variable siguiente del nodo
            } // Termina el recorrido.

            temporal.siguiente = nuevo; // asigna al nodo temporal en la casilla siguiente el valor del nodo nuevo 

            System.out.println("Canción agregada correctamente."); // confirma la creacion del nodo 

        } // Finaliza el método agregar.

        // ===== MÉTODO MOSTRAR =====

        static void mostrar() { // una funcion sin valor de tetorno para mostrar la lista anidada

            if (cabeza == null) { // comprueba  si la cabeza esta vacia 

                System.out.println("La playlist está vacía."); // indica que la lista esta vacia    

                return; // Termina el método.
            } // Finaliza la condición.

            Nodo temporal = cabeza; // asigna un Nodo temporal con el valor de la cabeza

            int posicion = 1; // Inicializa el número de posición.

            System.out.println("\n--- CANCIONES DE MI PLAYLIST ---"); // Muestra el encabezado.

            while (temporal != null) { // Recorre mientras exista un nodo.

                System.out.println(posicion + ". " + temporal.cancion); // el sistema imprime la linea con pocicion y la cancion del Nodo temporal

                temporal = temporal.siguiente; // asigna al Nodo temporal el valor de la casilla siguiente del mismo nodo

                posicion++; // Incrementa el contador de posición.
            } // Finaliza el ciclo.

        } // Finaliza el método mostrar.

        // ===== MÉTODO BUSCAR =====

        static void buscar(String cancion) { // metodo de busqueda con una condicion ingreso con string

            Nodo temporal = cabeza; // nodo temporal creado con el balor de la cabeza de la lista.

            int posicion = 1; // inicia en la pocicion 1

            while (temporal != null) { // Recorre la lista hasta llegar al final.

                if (temporal.cancion.equalsIgnoreCase(cancion)) { // Compara sin distinguir mayúsculas si el valor de la cancion en el nodo temporal es la misma  a la cancion .

                    System.out.println("Canción encontrada en la posición: " + posicion); // imprime el valor de la cancion encontrada

                    return; // Finaliza la búsqueda.
                } // Finaliza la comparación.

                temporal = temporal.siguiente; // asigna al mnodo temporal el valor de la casilla siguiente que es otro nodo

                posicion++; // Incrementa la posición.
            } // Finaliza el recorrido.

            System.out.println("La canción no se encuentra en la playlist."); // Informa si no existe.

        } // Finaliza el método buscar.

        // ===== MÉTODO ELIMINAR =====

        static void eliminar(String cancion) { // un metodo para eliminar una pocicion de la lista con un string

            if (cabeza == null) { // Comprueba si la lista está vacía.

                System.out.println("La playlist está vacía."); // Muestra un aviso.

                return; // Finaliza el método.
            } // Finaliza la condición.

            if (cabeza.cancion.equalsIgnoreCase(cancion)) { // Comprueba si es la primera canción.

                cabeza = cabeza.siguiente; // Cambia la cabeza al siguiente nodo.

                System.out.println("Canción eliminada correctamente."); // Confirma la eliminación.

                return; // Finaliza el método.
            } // Finaliza la condición.

            Nodo temporal = cabeza; // Empieza el recorrido desde la cabeza.

            while (temporal.siguiente != null) { // Recorre mientras exista otro nodo.

                if (temporal.siguiente.cancion.equalsIgnoreCase(cancion)) { //  mira si el valor de la cancion del nodo .siguiente es igual al valor de la cancion que se quiere eliminar

                    temporal.siguiente = temporal.siguiente.siguiente; // Salta el nodo que se elimina.

                    System.out.println("Canción eliminada correctamente."); // Confirma la eliminación.

                    return; // Finaliza el método.
                } // Finaliza la comparación.

                temporal = temporal.siguiente; // Avanza al siguiente nodo.
            } // Finaliza el ciclo.

            System.out.println("La canción no fue encontrada."); // imprime un  mensaje de error si no se encuentra la cancion en la lista

        } // Finaliza el método eliminar.

        // ===== MÉTODO PRINCIPAL =====

        public static void main(String[] args) { // Punto de inicio del programa.

            Scanner entrada = new Scanner(System.in); // Crea el lector del teclado.

            int opcion; //inicialisa una variable opcion vacia para el menu

            do { // Inicia un ciclo que repite el menú.

                System.out.println("\n================================"); // Separador visual.

                System.out.println("        MI PLAYLIST MUSICAL"); // Título del programa.

                System.out.println("================================"); // Separador visual.

                System.out.println("1. Agregar canción"); // Opción para agregar.

                System.out.println("2. Mostrar playlist"); // Opción para mostrar.

                System.out.println("3. Buscar canción"); // Opción para buscar.

                System.out.println("4. Eliminar canción"); // Opcion para eliminar.

                System.out.println("5. Salir"); // Opción para terminar.

                System.out.print("Seleccione una opción: "); // Solicita una opción.

                String texto = entrada.nextLine(); // Lee la opción como texto.

                try { // Intenta convertir el texto a número entero.

                    opcion = Integer.parseInt(texto); // Convierte la entrada a entero.

                } catch (NumberFormatException e) { // Captura errores si no es un número.

                    opcion = 0; // Asigna una opción inválida.
                } // Finaliza la validación.

                switch (opcion) { // Evalúa la opción seleccionada.

                    case 1: //extablece el primer caso para agregar una cancion a la lista

                        System.out.print("Ingrese el nombre de la canción: "); // Solicita el título.

                        String nuevaCancion = entrada.nextLine(); // Lee el nombre completo.

                        agregar(nuevaCancion); // Llama al método agregar.

                        break; // Finaliza esta opción.

                    case 2: // Opción para mostrar la lista.

                        mostrar(); // muestra la lista de canciones

                        break; // Finaliza esata opcion.

                    case 3: // inicializa la tercera opcion para buscar una cancion en la lista

                        System.out.print("Ingrese la canción a buscar: "); // Solicita el título.

                        String cancionBuscar = entrada.nextLine(); //

                        buscar(cancionBuscar); // Ejecuta la búsqueda.

                        break; // Finaliza esta opción.

                    case 4: // Opción para eliminar una canción.

                        System.out.print("Ingrese la canción a eliminar: "); // Solicita el título.

                        String cancionEliminar = entrada.nextLine(); // Lee la canción.

                        eliminar(cancionEliminar); // Ejecuta la eliminación.

                        break; // Finaliza esta opción.

                    case 5: // Opción para salir.

                        System.out.println("Gracias por utilizar la playlist."); // Despedida.

                        break; // Finaliza esta opción.

                    default: // Se ejecuta cuando la opción no es válida.

                        System.out.println("Opción incorrecta. Intente nuevamente."); // Informa el error.

                } // Finaliza la estructura switch.

            } while (opcion != 5); // Repite el menú hasta seleccionar salir.

            entrada.close(); // Cierra el lector del teclado.

        } // Finaliza el método main.

    } // Finaliza la clase PlaylistEnlazada.
