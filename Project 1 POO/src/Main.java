import java.util.Scanner;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

class Main {
  public static void main(String[] args){

  PrintStream print = System.out;
  Scanner ID = new Scanner(System.in);
  boolean flag1 = true;
  boolean flag2 = true;
  boolean flag0 = true;
  
  JSONParser parser = new JSONParser();
  Users users = parser.loadUsers();
  Dishes dishes = parser.loadDishes();
  Inventory inventory = parser.loadInventory();
  
  Syst sys = new Syst(users, dishes, inventory);
  User usuarioApp = new User();
  float carrito = 0;


  while (flag0 == true){

    while (flag1 == true){
    	
      print.println("Restaurante App");
      print.println("1: Registrarse");
      print.println("2: Iniciar Sesion");
      print.println("3: Salir");
      print.println("Ingrese su selecci�n: ");
      int InputMenu = ID.nextInt();
      print.println("");
      
      switch(InputMenu){
      
        case 1:
            print.println("Digite:\n - 1 para Cuenta Cliente \n - 2 para Cuenta Cocinero \n - 3 para Cuenta Administrador");
            int typeUser = ID.nextInt();
            if (typeUser < 1 || typeUser > 3){
              typeUser = 1;
            }
            print.println("Ingrese el nombre para la cuenta");
            String name = ID.next();
            print.println("Ingrese una contrase�a para la cuenta");
            String password = ID.next();
            sys.SignIn(name, password, typeUser);
            print.println("");
            print.println("Registro de usuario completado");
            print.println("");
            break;
            
        case 2:
            print.println("Ingrese su nombre de Usuario:");
            String nameuser = ID.next();
            print.println("Ingrese su Contrase�a:");
            String passuser = ID.next();
            
            if(sys.LogIn(nameuser, passuser) == true){
              usuarioApp = sys.getUser(nameuser);
              print.println("");
              print.println("Inicio exitoso");
              print.println("");
              flag1 = false;
              flag2 = true;
              
            } else {
              print.println("");
              print.println("Nombre de usuario o contrase�a incorrecto");
              print.println("");
            }
            break;
            
        case 3:
            print.println("");
            print.println("Saliendo...");
            flag1 = false;
            flag0 = false;
            print.println("");
            break;

        default:
            break;
      }
    }
    switch(usuarioApp.GetTypeUser()){
          
    case 1:
      while (flag2 == true){
    	  
        print.println("");
        print.println("Menu de Clientes");
        print.println("1: Registrar Direccion");
        print.println("2: Completar Perfil Alimenticio");
        print.println("3: Solicitar Menu del Dia");
        print.println("4: Salir");
        print.println("Ingrese su selecci�n: ");
        int InputMenu2 = ID.nextInt();
        switch(InputMenu2){
        
          case 1:
             print.println("Ingrese el nombre de la Direccion");
            String nameDir = ID.next();
            print.println("Ingrese la latitud");
            String lat = ID.next();
            print.println("Ingrese la longitud");
            String lon = ID.next();
            sys.RegistrarDireccion(nameDir, lat, lon, usuarioApp);
            print.println("Direccion registrada correctamente");
            break;
            
          case 2:
            boolean tempflag = true;
            
            String alergia = "";
            
            while(tempflag == true){
            	
              print.println("");
              print.println("Seleccione su Perfil Alementicio: ");
              print.println("1: Vegano");
              print.println("2: Vegetariano");
              print.println("3: Libre de Gluten");
              print.println("4: Halal");
              print.println("5: Kosher");
              print.println("6: Alergia o Intolerancia");
              print.println("Elija una opcion: ");
              int InputMenu3 = ID.nextInt();
              
              switch (InputMenu3) {
              
                case 1:
                  sys.CompletarPerfilAlimentario(InputMenu3, usuarioApp, alergia);
                  break;
                  
                case 2:
                  sys.CompletarPerfilAlimentario(InputMenu3, usuarioApp, alergia);
                  break;
                  
                case 3:
                  sys.CompletarPerfilAlimentario(InputMenu3, usuarioApp, alergia);
                  break;
                  
                case 4:
                  sys.CompletarPerfilAlimentario(InputMenu3, usuarioApp, alergia);
                  break;
                  
                case 5:
                  sys.CompletarPerfilAlimentario(InputMenu3, usuarioApp, alergia);
                  break;
                  
                case 6:
                  print.println("");
                  System.out.println("Ingrese en singular y comenzando en mayuscula, el alimento que le provoca Alergia o Intolerancia: ");
                  alergia = ID.next();
                  sys.CompletarPerfilAlimentario(InputMenu3, usuarioApp, alergia);
                  break;
                  
                default:
                  break;
              }

              print.println("");
              System.out.println("�Quiere seguir actualizando su Perfil Alimenticio?");
              System.out.println("1: Si");
              System.out.println("0: No");
              int YN = ID.nextInt();
              switch(YN){
              
                case 1:
                  tempflag = true;
                  alergia = "";
                  break;
                  
                case 0:
                  tempflag = false;
                  break;
                  
                default:
                  tempflag = false;
                  break;
              }
            }
            break;
            
          case 3:
            Dishes tempP = sys.SolicitarMenu(usuarioApp);
            for(int i = 0; i < tempP.size(); i++){
              System.out.println("ID "+i+" - " + tempP.get(i).GetName() + " - Precio: " + tempP.get(i).GetPrecio(tempP.get(i).GetIngredientes()) +" Colones");
            }
              System.out.println("");
              System.out.println("**Precios no incluyen IVA y Costos de Servicio");
              System.out.println("");
              System.out.println("�Quiere proceder a ordenar uno o varios platillos?");
              System.out.println("1: Si");
              System.out.println("0: No");
              int YN2 = ID.nextInt();
              switch(YN2){
              
                case 1:
                  boolean tempFlag2 = true;
                  while(tempFlag2 == true){
                	  
                    System.out.println("Digite el ID del Platillo: ");
                    int dishID = ID.nextInt();
                    if(tempP.isEmpty()){
                      System.out.println("El platillo no existe o no se encuentra disponible");
                    } else {
                      System.out.println("Usted a agregado al carrito: "+tempP.get(dishID).GetName());
                      carrito = carrito + tempP.get(dishID).GetPrecio(tempP.get(dishID).GetIngredientes());
                    }
                    System.out.println("�Desea agregar otro Platillo?");
                    System.out.println("1: Si");
                    System.out.println("0: No");
                    int YN3 = ID.nextInt();
                    switch(YN3){
                    
                      case 0:
                       tempFlag2 = false;
                       break;
                       
                      case 1:
                       tempFlag2 = true;
                       break;
                       
                       default:
                      tempFlag2 = false;
                       break;
                    }
                  }
                  carrito = carrito + ((carrito/100)*35);
                  carrito = carrito + ((carrito/100)*13);
                  System.out.println("");
                  System.out.println("Precio a pagar: "+carrito+" colones");
                  System.out.println("");
                  System.out.println("�Pagar?");
                  System.out.println("1: Si");
                  System.out.println("0: No");
                  int YN4 = ID.nextInt();
                  
                  switch(YN4){
                  
                      case 0:
                       System.out.println("");
                       System.out.println("Borrando Carrito, Regresando al Menu Principal");
                       carrito = 0;
                       System.out.println("");
                       break;
                       
                      case 1:
                       System.out.println("");
                       System.out.println("Orden Realizada, Regresando al Menu Principal");
                       carrito = 0;
                       System.out.println("");
                       break;
                       
                       default:
                       System.out.println("");
                       System.out.println("Borrando Carrito, Regresando al Menu Principal");
                       carrito = 0;
                       System.out.println("");
                       break;
                    }
                  break;
                  
                case 0:
                  break;
                  
                default:
                  break;
              }
            break;
            
          case 4:
            flag2 = false;
            flag1 = true;
           break;
           
          default:
           break;
        }
      }
      break;
      
    case 2:
      while (flag2 == true){
    	  
        print.println("");
        print.println("Menu de Cocinero");
        print.println("1: Agregar Platillo");
        print.println("2: Ver Inventario de Ingredientes");
        print.println("3: Agregar Ingrediente");
        print.println("4: Salir");
        print.println("Ingrese su selecci�n: ");
        int InputMenu3 = ID.nextInt();
        
        switch(InputMenu3){
        
          case 1:
            print.println("");
            print.println("Ingrese el Nombre del Platillo: ");
            String nameDish = ID.next();
            ID.nextLine();
            print.println("");
            
            Inventory ingredientDish = new Inventory();
            List<Float> cantidadDish = new ArrayList<Float>();
            boolean flag3 = true;
            
            while(flag3 == true){
            	
              print.println("Ingrese el Nombre del Ingrediente");
              String ingName = ID.next();
              ID.nextLine();
              print.println("Ingrese la cantidad de este Ingrediente en el Inventario");
              float ingCant = ID.nextFloat();
              print.println("Ingrese la cantidad de este Ingrediente en el Platillo");
              float ingCant2 = ID.nextFloat();
              print.println("Ingrese el Precio por Medida");
              float ingPrecio = ID.nextFloat();
              ID.nextLine();
              
              Ingredient TempIng = new Ingredient(ingName, ingCant, ingPrecio);
              cantidadDish.add(ingCant2);
              ingredientDish.add(TempIng);
              
              System.out.println("�Quiere agregar otro Ingrediente al Platillo?");
              System.out.println("1: Si");
              System.out.println("0: No");
              int YN5 = ID.nextInt();
              
              switch(YN5){
              
                case 1:
                flag3 = true;
                break;
                
                case 0:
                flag3 = false;
                break;
                
                default:
                flag3 = false;
                break;
              }
            }

            print.println("Describa la preparacion del platillo: ");
            String preparacionDish = ID.next();
            ID.nextLine();
            print.println("");

            Dish tempPlatillo = new Dish(nameDish, preparacionDish, ingredientDish);

            sys.AgregarPlatillo(tempPlatillo);

            print.println("Platillo Agregado al Sistema");
            print.println("");
            break;
            
          case 2:
        	Inventory tempInv = sys.VerInventario();
            for(int i = 0; i < tempInv.size(); i++){
              System.out.println(tempInv.get(i).GetNombre()+" - Stock:"+tempInv.get(i).GetCantidad()+" - Precio por Medida:"+tempInv.get(i).GetPrecio());
            }
            break;
            
          case 3:
              print.println("Ingrese el Nombre del Ingrediente");
              String ingName3 = ID.next();
              print.println("Ingrese la cantidad de este Ingrediente en el Inventario");
              float ingCant3 = ID.nextFloat();
              print.println("Ingrese el Precio por Medida");
              float ingPrecio3 = ID.nextFloat();
              Ingredient Ing3 = new Ingredient(ingName3, ingCant3, ingPrecio3);
              sys.AgregarIngrediente(Ing3);
            break;
            
          case 4:
            flag2 = false;
            flag1 = true;
            break;
        }
      }
      break;
      
    case 3:
      while (flag2 == true){
        print.println("");
        print.println("Menu de Administrador");
        print.println("1: Agregar Ingrediente");
        print.println("2: Salir");
        print.println("Ingrese su selecci�n: ");
        int InputMenu4 = ID.nextInt();
        
        switch(InputMenu4){
        
          case 1:
            print.println("Ingrese el Nombre del Ingrediente");
            String ingName4 = ID.next();
            print.println("Ingrese la cantidad de este Ingrediente en el Inventario");
            float ingCant4 = ID.nextFloat();
            print.println("Ingrese el Precio por Medida");
            float ingPrecio4 = ID.nextFloat();
            Ingredient Ing4 = new Ingredient(ingName4, ingCant4, ingPrecio4);
            sys.AgregarIngrediente(Ing4);
            break;
            
          case 2:
            flag2 = false;
            flag1 = true;
            break;
        }
      }
      break;
      
    default:
      break;
    }
  }
  ID.close();
} 
}