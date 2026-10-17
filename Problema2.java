import java.util.Scanner;

public class Problema2 {

    private static int solicitarCantidadNotas(Scanner sc, int porcentaje) {
        int cantidad;

        System.out.println("¿Cuántas notas conforman el porcentaje del " + porcentaje + " %?");
        while (!sc.hasNextInt()) {
            System.out.println("Ingrese una cantidad entera mayor que cero:");
            sc.next();
        }

        cantidad = sc.nextInt();
        while (cantidad <= 0) {
            System.out.println("La cantidad de notas debe ser mayor que cero. Intente de nuevo:");
            while (!sc.hasNextInt()) {
                System.out.println("Ingrese una cantidad entera mayor que cero:");
                sc.next();
            }
            cantidad = sc.nextInt();
        }

        return cantidad;
    }

    private static double solicitarNota(Scanner sc, int numeroNota, int porcentaje) {
        double nota;

        System.out.println("Ingrese la nota " + numeroNota + " del porcentaje del " + porcentaje + " %:");
        while (!sc.hasNextDouble()) {
            System.out.println("Ingrese un valor numérico entre 0 y 5:");
            sc.next();
        }

        nota = sc.nextDouble();
        while (nota < 0.0 || nota > 5.0) {
            System.out.println("Nota inválida. Ingrese un valor entre 0 y 5:");
            while (!sc.hasNextDouble()) {
                System.out.println("Ingrese un valor numérico entre 0 y 5:");
                sc.next();
            }
            nota = sc.nextDouble();
        }

        return nota;
    }

    private static double calcularPromedioPonderado(Scanner sc, int porcentaje) {
        int cantidadNotas = solicitarCantidadNotas(sc, porcentaje);
        double sumaNotas = 0.0;

        for (int i = 1; i <= cantidadNotas; i++) {
            sumaNotas += solicitarNota(sc, i, porcentaje);
        }

        double promedio = sumaNotas / cantidadNotas;
        double valorPonderado = promedio * porcentaje / 100.0;

        System.out.printf("Promedio del %d %%: %.2f%n", porcentaje, promedio);
        System.out.printf("Valor correspondiente al %d %%: %.2f%n", porcentaje, valorPonderado);
        return valorPonderado;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Sistema de calificaciones");
        double nota30 = calcularPromedioPonderado(sc, 30);
        double nota20 = calcularPromedioPonderado(sc, 20);
        double nota50 = calcularPromedioPonderado(sc, 50);
        double definitiva = nota30 + nota20 + nota50;

        System.out.println("----------------");
        System.out.printf("Definitiva: %.2f%n", definitiva);
        System.out.println(definitiva >= 3.0 ? "Estado: Aprobado" : "Estado: Reprobado");
    }
}
