import java.util.Scanner;

public class listaDoble {
    private static class Nodo {
        private final int valor;
        private Nodo anterior;
        private Nodo siguiente;

        private Nodo(int valor) {
            this.valor = valor;
        }
    }

    private Nodo cabeza;
    private Nodo cola;
    private int tamaño;

    public void agregar(int valor) {
        Nodo nuevo = new Nodo(valor);
        if (cabeza == null) {
            cabeza = nuevo;
            cola = nuevo;
            nuevo.siguiente = nuevo;
            nuevo.anterior = nuevo;
        } else {
            nuevo.anterior = cola;
            nuevo.siguiente = cabeza;
            cola.siguiente = nuevo;
            cabeza.anterior = nuevo;
            cola = nuevo;
        }
        tamaño++;
    }

    public void mostrarAdelante() {
        mostrar(true);
    }

    public void mostrarAtras() {
        mostrar(false);
    }

    private void mostrar(boolean adelante) {
        if (cabeza == null) {
            System.out.println("Lista vacía");
            return;
        }

        Nodo actual = adelante ? cabeza : cola;
        for (int i = 0; i < tamaño; i++) {
            System.out.print(actual.valor);
            if (i < tamaño - 1) {
                System.out.print(" <-> ");
            }
            actual = adelante ? actual.siguiente : actual.anterior;
        }
        System.out.println(adelante
                ? " <-> (regresa a cabeza)"
                : " <-> (regresa a cola)");
    }

    /**
     * Elimina todas las apariciones del dato y devuelve cuántos nodos quitó.
     */
    public int eliminar(int dato) {
        int nodosOriginales = tamaño;
        int eliminados = 0;
        Nodo actual = cabeza;

        for (int i = 0; i < nodosOriginales; i++) {
            Nodo siguienteOriginal = actual.siguiente;
            if (actual.valor == dato) {
                if (tamaño == 1) {
                    cabeza = null;
                    cola = null;
                } else {
                    actual.anterior.siguiente = actual.siguiente;
                    actual.siguiente.anterior = actual.anterior;
                    if (actual == cabeza) {
                        cabeza = actual.siguiente;
                    }
                    if (actual == cola) {
                        cola = actual.anterior;
                    }
                }
                actual.anterior = null;
                actual.siguiente = null;
                tamaño--;
                eliminados++;
            }
            actual = siguienteOriginal;
        }

        return eliminados;
    }

    public int getTamaño() {
        return tamaño;
    }

    public boolean esCircular() {
        if (tamaño == 0) {
            return cabeza == null && cola == null;
        }
        if (cabeza == null || cola == null
                || cabeza.anterior != cola || cola.siguiente != cabeza) {
            return false;
        }

        Nodo actual = cabeza;
        for (int i = 0; i < tamaño; i++) {
            if (actual == null || actual.siguiente == null || actual.anterior == null
                    || actual.siguiente.anterior != actual
                    || actual.anterior.siguiente != actual
                    || (i < tamaño - 1 && actual.siguiente == cabeza)
                    || (i == tamaño - 1 && actual != cola)) {
                return false;
            }
            actual = actual.siguiente;
        }
        return actual == cabeza;
    }

    private static int leerEntero(Scanner scanner, String mensaje, int minimo) {
        while (true) {
            System.out.print(mensaje);
            String entrada = scanner.nextLine().trim();
            try {
                int valor = Integer.parseInt(entrada);
                if (valor >= minimo) {
                    return valor;
                }
            } catch (NumberFormatException e) {
                // Se vuelve a solicitar una entrada entera válida.
            }
            System.out.println("Entrada inválida. Ingrese un entero mayor o igual a "
                    + minimo + ".");
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n--- Lista doble circular ---");
        System.out.println("1. Agregar varios nodos al final");
        System.out.println("2. Agregar un nodo al final");
        System.out.println("3. Mostrar hacia adelante");
        System.out.println("4. Mostrar hacia atrás");
        System.out.println("5. Mostrar en ambos sentidos");
        System.out.println("6. Eliminar todas las apariciones de un dato");
        System.out.println("0. Salir");
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            listaDoble lista = new listaDoble();

            boolean ejecutando = true;
            while (ejecutando) {
                mostrarMenu();
                int opcion = leerEntero(scanner, "Seleccione una opción: ", 0);

                switch (opcion) {
                    case 1:
                        int cantidad = leerEntero(scanner,
                                "¿Cuántos nodos desea agregar? ", 0);
                        for (int i = 0; i < cantidad; i++) {
                            int valor = leerEntero(scanner,
                                    "Ingrese el dato del nodo " + (i + 1) + ": ",
                                    Integer.MIN_VALUE);
                            lista.agregar(valor);
                        }
                        System.out.println(cantidad + " nodo(s) agregado(s) al final.");
                        break;
                    case 2:
                        int valor = leerEntero(scanner, "Ingrese el dato: ",
                                Integer.MIN_VALUE);
                        lista.agregar(valor);
                        System.out.println("Nodo agregado al final.");
                        break;
                    case 3:
                        System.out.println("Recorrido hacia adelante:");
                        lista.mostrarAdelante();
                        break;
                    case 4:
                        System.out.println("Recorrido hacia atrás:");
                        lista.mostrarAtras();
                        break;
                    case 5:
                        System.out.println("Recorrido hacia adelante:");
                        lista.mostrarAdelante();
                        System.out.println("Recorrido hacia atrás:");
                        lista.mostrarAtras();
                        System.out.println("Cantidad de nodos: " + lista.getTamaño());
                        System.out.println("Cierre circular correcto: "
                                + lista.esCircular());
                        break;
                    case 6:
                        int dato = leerEntero(scanner,
                                "Dato a eliminar (se borrarán todas sus apariciones): ",
                                Integer.MIN_VALUE);
                        int eliminados = lista.eliminar(dato);
                        System.out.println("Nodos eliminados: " + eliminados);
                        break;
                    case 0:
                        ejecutando = false;
                        System.out.println("Programa finalizado.");
                        break;
                    default:
                        System.out.println("Opción inválida. Seleccione una opción del menú.");
                }
            }
        }
    }
}
