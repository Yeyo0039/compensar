import java.util.Scanner;

public class Problema3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double saldo = 500000.0;
        int opcion;

        do {
            System.out.println("\n=== ENTIDAD BANCARIA ===");
            System.out.println("1. Consignar");
            System.out.println("2. Retirar");
            System.out.println("3. Mostrar saldo");
            System.out.println("4. Transferir");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");

            while (!sc.hasNextInt()) {
                System.out.println("Error: Ingrese un número entero válido (1-5):");
                sc.next();
            }
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese el valor a consignar: ");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Monto inválido. Ingrese un valor numérico:");
                        sc.next();
                    }
                    double montoConsignar = sc.nextDouble();

                    if (montoConsignar > 0) {
                        double interes = montoConsignar * 0.01;
                        saldo += (montoConsignar + interes);
                        System.out.printf("--- Recibo de Operación ---%n");
                        System.out.println("Consignación: " + montoConsignar);
                        System.out.println("Interés abonado (1%%): " + interes);
                        System.out.println("Saldo disponible actual: " + saldo);
                    } else {
                        System.out.println("Error: El valor a consignar debe ser mayor que cero.");
                    }
                    break;

                case 2:
                    System.out.print("Ingrese el valor a retirar: ");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Monto inválido. Ingrese un valor numérico:");
                        sc.next();
                    }
                    double montoRetirar = sc.nextDouble();

                    if (montoRetirar > 0) {
                        if (montoRetirar <= saldo) {
                            saldo -= montoRetirar;
                            System.out.println("Retiro exitoso. Saldo disponible actual: " + saldo);
                        } else {
                            System.out.println("Error: Fondos insuficientes. No puede retirar más de su saldo.");
                        }
                    } else {
                        System.out.println("Error: El valor a retirar debe ser mayor que cero.");
                    }
                    break;

                case 3:
                    System.out.println("Su saldo disponible es: " + saldo);
                    break;

                case 4:
                    System.out.print("Ingrese el valor a transferir: ");
                    while (!sc.hasNextDouble()) {
                        System.out.println("Monto inválido. Ingrese un valor numérico:");
                        sc.next();
                    }
                    double montoTransferir = sc.nextDouble();

                    if (montoTransferir > 0) {
                        double comision = montoTransferir * 0.005;
                        double totalDescontado = montoTransferir + comision;

                        if (totalDescontado <= saldo) {
                            saldo -= totalDescontado;
                            System.out.println("--- Recibo de Transferencia ---");
                            System.out.println("Monto enviado: " + montoTransferir);
                            System.out.println("Comisión bancaria (0.5%%): " + comision);
                            System.out.println("Total descontado de cuenta: " + totalDescontado);
                            System.out.println("Saldo remanente: " + saldo);
                        } else {
                            System.out.printf("Error: Fondos insuficientes.%n");
                            System.out.println("Monto + Comisión requiere un total de: " + totalDescontado);
                            System.out.println("Su saldo actual disponible es: " + saldo);
                        }
                    } else {
                        System.out.println("Error: El valor a transferir debe ser mayor que cero.");
                    }
                    break;

                case 5:
                    System.out.println("Cierre de sesión seguro realizado");
                    break;

                default:
                    System.out
                            .println("Error: Opción inválida");
            }
        } while (opcion != 5);

        sc.close();
    }
}
