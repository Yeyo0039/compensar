import java.util.Scanner;

public class MATRIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] matriz = leerMatriz(sc, 3, 3);

        System.out.println("La matriz ingresada es:");
        mostrarMatriz(matriz);
        System.out.println("El número mayor de la matriz es: " + obtenerMayor(matriz));
        int[] ubicacionMayor = obtenerUbicacionMayor(matriz);
        System.out.println("La ubicación del número mayor es: [" + ubicacionMayor[0] + "][" + ubicacionMayor[1] + "]");
        System.out.println("La suma de los elementos de la matriz es: " + sumarElementos(matriz));
        sc.close();
    }

    public static int[][] leerMatriz(Scanner sc, int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];

        System.out.println("Ingrese los elementos de la matriz 3x3:");
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                matriz[i][j] = sc.nextInt();
            }
        }
        return matriz;
    }

    public static int obtenerMayor(int[][] matriz) {
        int mayor = Integer.MIN_VALUE;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                if (valor > mayor) {
                    mayor = valor;
                }
            }
        }
        return mayor;
    }

    public static int[] obtenerUbicacionMayor(int[][] matriz) {
        int mayor = Integer.MIN_VALUE;
        int[] ubicacion = new int[2];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                if (matriz[i][j] > mayor) {
                    mayor = matriz[i][j];
                    ubicacion[0] = i;
                    ubicacion[1] = j;
                }
            }
        }
        return ubicacion;
    }

    public static int sumarElementos(int[][] matriz) {
        int suma = 0;
        for (int[] fila : matriz) {
            for (int valor : fila) {
                suma += valor;
            }
        }
        return suma;
    }

    public static void mostrarMatriz(int[][] matriz) {
        for (int[] fila : matriz) {
            for (int valor : fila) {
                System.out.print(valor + " ");
            }
            System.out.println();
        }
    }
}