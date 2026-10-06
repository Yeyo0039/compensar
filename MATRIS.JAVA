public class MATRIDS{
    public void main (String[] args) {
        int[][] matriz = new int[3][3];
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese los elementos de la matriz 3x3:");

        // numero mayor 
        int mayor ;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print("Elemento [" + i + "][" + j + "]: ");
                
                 int valor = sc.nextInt();
                matriz[i][j] =valor;
                if (valor > mayor) {
                    mayor = valor;
                }

            
            }
            System.out.println("el numero mayor de la matriz es: " + mayor);
        }

        System.out.println("La matriz ingresada es:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println();
        }

      System.out.println("Suma de los elementos de la matriz:");
        int suma = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                suma += matriz[i][j];
            }
        }
        System.out.println("La suma de los elementos es: " + suma);1
       }

       
}