import java.util.Scanner;

public class promedio1 {
    static public double verificar(double nota) {
        if (nota >= 0.0 && nota <= 5.0) {
            return nota;
        } else {
            System.out.println("Nota invalida");
            return 0;
        }
    }

    static public String estado(double promedio) {
        if (promedio >= 3.0) {
            return "Aprobado";
        } else {
            return "Reprobado";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double Nota1, Nota2, Nota3, Nota_final;

        System.out.println("Ingrese la primera nota");
        Nota1 = sc.nextDouble();
        Nota1 = verificar(Nota1);
        System.out.println("Ingrese la segunda nota");
        Nota2 = sc.nextDouble();
        Nota2 = verificar(Nota2);
        System.out.println("Ingrese la tercera nota");
        Nota3 = sc.nextDouble();
        Nota3 = verificar(Nota3);
        Nota1 = Nota1 * 30 / 100;
        Nota2 = Nota2 * 20 / 100;
        Nota3 = Nota3 * 50 / 100;
        Nota_final = Nota1 + Nota2 + Nota3;

        System.out.println("El promedio es: " + Nota_final);
        System.out.println("Su estado es: " + estado(Nota_final));
    }
}
