import java.util.Scanner;

public class reversarNodos {

    static Scanner sc = new Scanner(System.in);

    static class Nodo {
        int valor;
        Nodo siguiente;
        Nodo anterior;

        public Nodo(int valor) {
            this.valor = valor;
            this.anterior = null;
            this.siguiente = null;
        }
    }

    public static Nodo reversarNodos(Nodo[] nodos) {

     
        for (int i = 0; i < nodos.length; i++) {

            Nodo temporal = nodos[i].siguiente;

            nodos[i].siguiente = nodos[i].anterior;
            nodos[i].anterior = temporal;
        }

        return nodos[nodos.length - 1];
    }

    public static void main(String[] args) {

        Nodo[] nodos = new Nodo[5];

  
        for (int i = 0; i < nodos.length; i++) {

            System.out.print(
                "Ingrese el valor del nodo " + (i + 1) + ": "
            );

            nodos[i] = new Nodo(sc.nextInt());
        }

        for (int i = 0; i < nodos.length; i++) {

            if (i > 0) {
                nodos[i].anterior = nodos[i - 1];
            }

            if (i < nodos.length - 1) {
                nodos[i].siguiente = nodos[i + 1];
            }
        }

        System.out.println("\nLista original:");

        Nodo actual = nodos[0];

        while (actual != null) {
            System.out.print(actual.valor + " ");

            actual = actual.siguiente;
        }


        Nodo nuevoInicio = reversarNodos(nodos);

        System.out.println("\n\nLista invertida:");
        actual = nuevoInicio;

        while (actual != null) {

        System.out.print("Anterior: ");

        if (actual.anterior != null) {
            System.out.print(actual.anterior.valor);
        } else {
            System.out.print("null");
        }

        System.out.print(" | Actual: " + actual.valor);

        System.out.print(" | Siguiente: ");

        if (actual.siguiente != null) {
            System.out.print(actual.siguiente.valor);
        } else {
            System.out.print("null");
        }

        System.out.print(" | valor : " + actual.valor);
        
        
        System.out.println();

        actual = actual.siguiente;
        }
    }
}
