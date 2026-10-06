import java.util.Scanner;

public class Tablas {

    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    
    System.out.println("ingresa un numero");
    int number = sc.nextInt();

        for (int i = 0; i<= 10; i++) {
        int multiplicacion = i * number;
        System.out.println(i + " X " + number + " = " + multiplicacion);

        }
    }

}