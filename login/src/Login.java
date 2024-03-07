
import java.util.Scanner;


public class Login {

    public static void main(String[] args) {
        
        Scanner sc= new Scanner (System.in);
        
    String Usuario;
    String Contraseña;
    System.out.println("Escribe el nombre de usuario");
    Usuario =sc.nextLine();
    System.out.println("Escribe la contraseña");
    Contraseña = sc.nextLine();
    
    Usuarios objusuarios = new Usuarios(Usuario,Contraseña);
    objusuarios.autenticar();
    
                System.out.println("Inicio de sesión exitoso.");
                System.out.println("Puedes comenzar a jugar :)");
                // Aquí podrías iniciar el juego de laberinto
                Laberinto laberinto = new Laberinto();
                laberinto.jugar();
           
        
              
        }

    }
