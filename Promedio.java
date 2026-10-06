import java.util.Scanner;

public class Promedio {

    static class estudiante {
        String nombre;
        double[] notas;
        double promedio;
        String menssage;
    }

    static estudiante[] estudiantes = new estudiante[10];
    static int cantidadEstudiantes = 0;
    static int cantidadAprobados = 0;
    static int cantidadNoAprobados = 0;
    static double nota ;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Bienvenido al sistema academico");
            boolean continuar = true;
            String nombre ;

            while (continuar) {
                System.out.println("Ingresa el nombre del estudiante: ");

                nombre = sc.next();

                double[] notas = new double[3];
                for (int i = 0; i < notas.length; i++) {
                    System.out.println("Ingresa la nota " + (i + 1) + ": ");

                     nota = sc.nextDouble();
                     // punto del taller numero 2 v c  en el sistema academico 
                    while (nota < 0.0 || nota > 5.0) {
                        System.out.println("Nota inválida, ingresa un valor entre 0 y 5");
                        nota = sc.nextDouble();
                    }

                    notas[i] = nota;


                    notas[i] = nota;
                    System.out.println("Nota ingresada: " + notas[i]);
                }

                double promedio = (notas[0] + notas[1] + notas[2]) / 3.0;

                System.out.println("El promedio es: " + promedio);

                String menssage;

                if (promedio < 3.0) {
                    menssage = "as suspendido";
                    cantidadNoAprobados++;
                } else if (promedio >= 3.0 && promedio < 4.0) {
                    menssage = "as aprobado";
                    cantidadAprobados++;
                } else if (promedio >= 4.0 && promedio <= 5.0) {
                    menssage = "as aprobado con nota superior felicidades";
                    cantidadAprobados++;
                } else {
                    menssage = "Nota fuera de rango";
                }

                System.out.println(menssage);

                estudiante e = new estudiante();
                e.nombre = nombre;
                e.notas = notas;
                e.promedio = promedio;
                e.menssage = menssage;

                estudiantes[cantidadEstudiantes] = e;
                cantidadEstudiantes++;

                System.out.println("Desea registrar otro estudiante? (si/no)");
                String respuesta = sc.next();
                if (respuesta.equalsIgnoreCase("no")) {
                    continuar = false;
                    System.out.println("Lista de estudiantes registrados: ");
                    if (cantidadEstudiantes > 0) {
                        for (int i = 0; i < cantidadEstudiantes; i++) {
                            System.out.println("Nombre: " + estudiantes[i].nombre);
                            System.out.println("Notas: ");
                            for (double nota : estudiantes[i].notas) {
                                System.out.println(nota);
                            }
                            System.out.println("Promedio: " + estudiantes[i].promedio);
                            System.out.println("Mensaje: " + estudiantes[i].menssage);
                        }

                        System.out.println("Cantidad de estudiantes registrados: " + cantidadEstudiantes);
                        System.out.println("Cantidad de aprobados: " + cantidadAprobados);
                        System.out.println("Cantidad de no aprobados: " + cantidadNoAprobados);
                    } else {
                        System.out.println("No hay estudiantes registrados.");
                    }
                } else if (respuesta.equalsIgnoreCase("si")) {
                    continuar = true;
                } else {
                    System.out.println("Respuesta inválida, se asumirá que desea continuar.");
                    continuar = true;
                }
            }
        }

    }
