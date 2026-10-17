import java.util.Arrays;
import java.util.Scanner;

public class FiltroNumerico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int positivos = 0, negativos = 0, ceros = 0;
        int sumaTotal = 0;
        int[] lista = new int[10];

        System.out.println("Bienvenido al sistema de filtrado numérico (Problema 4)");

        for (int i = 0; i < 10; i++) {
            System.out.print("Ingresa el número entero [" + (i + 1) + "]: ");

            while (!sc.hasNextInt()) {
                System.out.println("Dato inválido. Por favor ingresa un número entero:");
                sc.next();
            }
            int numero = sc.nextInt();
            lista[i] = numero;

            sumaTotal += numero;

            if (numero < 0) {
                System.out.println("El número ingresado es negativo");
                negativos++;
            } else if (numero == 0) {
                System.out.println("El número ingresado es cero");
                ceros++;
            } else {
                System.out.println("El número ingresado es positivo");
                positivos++;
            }
        }

        double promedio = (double) sumaTotal / 10;

        System.out.println("Resumen del análisis:");
        System.out.println("Números ingresados: " + Arrays.toString(lista));
        System.out.println("Cantidad de números positivos: " + positivos);
        System.out.println("Cantidad de números negativos: " + negativos);
        System.out.println("Cantidad de números ceros: " + ceros);
        System.out.println("Suma de todos los números: " + sumaTotal);
        System.out.println("Promedio general: " + String.format("%.2f", promedio));

        sc.close();
    }
}
