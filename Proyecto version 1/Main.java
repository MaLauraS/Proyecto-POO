import java.util.Scanner;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class Main {
  public static void main(String[] args){

  PrintStream print = System.out;
  int inputId = 0;
  Scanner ID = new Scanner(System.in);
  boolean flag = true;
  Sistema sys = new Sistema();

    //Inicio y Registro de Usuario
    while (flag == true){
      print.println("");
      print.println("Restaurante App");
      print.println("1: Registrarse");
      print.println("2: Iniciar Sesion");
      print.println("3: Salir");
      print.println("Ingrese su selección: ");
      int InputMenu = ID.nextInt();
      switch(InputMenu){
        case 1:
            print.println("Digite:\n - 1 para Cuenta Cliente \n - 2 para Cuenta Cocinero \n - 3 para Cuenta Administrador");
            char typeUser = ID.next().charAt(0);
            ID.close();
            print.println("Ingrese el nombre para la cuenta");
            String name = ID.nextLine();
            ID.close();
            print.println("Ingrese una contraseña para la cuenta");
            String password = ID.nextLine();
            ID.close();
            sys.SignIn(name, password, typeUser);
            print.println("Registro de usuario completado");
            break;
        case 2:
            print.println("Ingrese su nombre de Usuario:");
            String nameuser = ID.nextLine();
            ID.close();
            print.println("Ingrese su Contraseña:");
            String passuser = ID.nextLine();
            ID.close();
            if(sys.LogIn(nameuser, passuser)){
              print.println("Inicio exitoso");
              flag = false;
            } else {
              print.println("Nombre de usuario o contraseña incorrecto");
            }
            break;
        case 3:
            print.println("");
            print.println("Saliendo...");
            flag = false;
            print.println("");
            break;
      }
    }
  }

}




