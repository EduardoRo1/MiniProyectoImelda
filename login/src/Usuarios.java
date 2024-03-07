
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author utma
 */
public class Usuarios {
    Scanner sc=new Scanner(System.in);
    String user;
    String password;
    int opcion;
    
    Usuarios(String usuario, String contraseña){
    user = usuario;
    password = contraseña;
    }
    public void autenticar(){
    if ((this.user.compareTo("Administrador")==0)&&
            (this.password.compareTo("Admin12345")==0)){
    
    }else{
            System.out.println("DATOS INCORRECTOS");
    
    }
    
}
}
