import java.util.Scanner;
public class sumaConcatenada {
    public static void main (String[] args) {
    Scanner sc = new Scanner(System.in);

    System.out.println("ingresa tu numero");
    int numero = sc.nextInt();
    int suma = 0;

    for (int i =0;i<=numero;i++){
        suma += i;
        System.out.println("la suma de " + i + " es: " + suma);
    }
    System.out.println("la suma es: " + suma);
        sc.close();
    }

}
