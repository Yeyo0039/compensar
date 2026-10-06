import java.util.Scanner;
public class numeroIncognito {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numero = 24;
        boolean acertado = false;
        System.out.println("Bienvenido al sistema de numeros incognitos");
        System.out.println("    Ingresa un numero entero: ");
        while(acertado == false) {
            int numeroIngresado = sc.nextInt();
            if (numeroIngresado < numero) {
                System.out.println("El numero ingresado es menor al numero incognito");
            } else if (numeroIngresado > numero) {
                System.out.println("El numero ingresado es mayor al numero incognito");
            } else {
                System.out.println("Felicidades, has acertado el numero incognito");
                acertado = true;
            }
        }
    }
}
