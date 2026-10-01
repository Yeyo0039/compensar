import java.util.Scanner;

public class listaAnidada {

    public class Nodo {
        int dato;
        Nodo siguiente;
        Nodo hijo;

        Nodo(int dato) {
            this.dato = dato;
            this.siguiente = null;
            this.hijo = null;
        }
    }

    public void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Nodo n1 = new Nodo(10);
        Nodo n2 = new Nodo(20);
        Nodo n3 = new Nodo(35);
        Nodo n4 = new Nodo(40);
        Nodo n5 = new Nodo(50);

        // Lista inicial
        n1.siguiente = n2;
        n2.siguiente = n3;
        n3.siguiente = n4;
        n4.siguiente = n5;

        // Nuevo nodo
        Nodo n6 = new Nodo(sc.nextInt());

        // Guardamos el nodo que estaba después de 20
        Nodo siguiente = n2.siguiente;

        // Insertamos n6 entre 20 y 35
        n2.siguiente = n6;
        n6.siguiente = siguiente;

        // Recorrer la lista
        Nodo actual = n1;

        while (actual != null) {
            System.out.println(actual.dato);
            actual = actual.siguiente;
        }

        sc.close();
    }
}