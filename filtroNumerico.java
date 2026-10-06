import java.util.Scanner;
public class filtroNumerico {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pares = 0, inpares = 0, negativos = 0, ceros = 0;
        int numero ;
        int[] lista = new int[10];
                System.out.println("Bienvenido al sistema de filtrado numerico");
        for (int i = 0; i < 10; i++) {

        System.out.println("Ingresa un numero entero: ");
        numero = sc.nextInt();
        if (numero < 0) {
            System.out.println("El numero ingresado es negativo");
            negativos++;
        } else if (numero == 0) {
            System.out.println("El numero ingresado es cero");
            ceros++;
        } else {
            System.out.println("El numero ingresado es positivo");
            pares++;
        }
        lista[i] = numero;
        }
    System.out.println("Resumen:");
    System.out.println("Numeros ingresados: " + java.util.Arrays.toString(lista));
    System.out.println("Numeros negativos: " + negativos);
    System.out.println("Numeros ceros: " + ceros);
    System.out.println("Numeros positivos: " + pares);
    
   
}
}