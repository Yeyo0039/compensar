import java.util.Scanner;
public class validacionContraseñas{

    static class usuario{
        String user;
        String contraseña;
    }
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);
        usuario[] usuarios = new usuario[3];
        String contraseña = "";
        String contraseñaIngresada = "";

         System.out.println("Bienvenido al sistema de validacion de contraseñas");
        boolean continuar = true;
        while (usuarios.length < 3  || continuar==true){ {
        int i = 0;
        System.out.println("Ingrese su nombre de usuario: ");

        String user = sc.nextLine();

       System.out.println("Ingrese y registre la contraseña: ");
        
        contraseñaIngresada = sc.nextLine();

        System.out.println("ingrea nuevamente la contraseña");
        String confirmarContraseña = sc.nextLine();

        while (!confirmarContraseña.equals(contraseñaIngresada)){
            System.out.println("tu contraseña ingresada no corresponde a la ingresada previamente ");
            confirmarContraseña = sc.nextLine();
            if (confirmarContraseña.equals(contraseñaIngresada)){
                contraseña=contraseñaIngresada;
                System.out.println("Contraseña registrada correctamente.");
            }        
        }   
        usuarios[i] = new usuario();
        usuarios[i].user = user;
        usuarios[i].contraseña = contraseña;
        i++;

        System.out.print("para iniciar secion ingresa 1 para registrar otro usuario ingresa 2: ");
        int opcion = sc.nextInt();
        sc.nextLine();
        if (opcion == 1){
            continuar = false;
        } else if (opcion == 2){
            continue;
        } else {
            System.out.println("opcion invalida");
        }
    }
}
int intento =0;
        System.out.println("ingresa tu usuario para iniciar secion");
        String userIngresado = sc.nextLine();
        
        System.out.println("ingresa tu contraseña para iniciar secion");
        while (!contraseñaIngresada.equals(usuarios[0].contraseña)){
            System.out.println("Contraseña incorrecta. Intente nuevamente.");
            contraseñaIngresada = sc.nextLine();
            intento++;
            if (intento == 3){
                System.err.println("muchos intentos invalidos saliendo del sistema...");
                return;
            }
        }
        if(contraseñaIngresada.equals(contraseña)){

        System.out.println("Contraseña correcta ingresando al usuario : " );
        
        }

        sc.close();
    }
}