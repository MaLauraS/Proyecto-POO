import java.util.ArrayList;
import java.util.List;
import java.util.Base64;

public class Syst {
  
  private Users users = new Users();
  private Dishes platillos = new Dishes();
  private Inventory inventario = new Inventory();

  public Syst(Users users, Dishes platillos, Inventory inventario){
    this.users = users;
    this.platillos = platillos;
    this.inventario = inventario;
  }

  public Syst(){

  }

  public boolean LogIn(String usuario, String password){
    User tempU = getUser(usuario);
    
    if(tempU != null){
      if(tempU.GetPassword().equals(password)){
        return true;
        
      } else {
        return false;
        
      }
      
    } else {
      return false;
    } 
  }

  public void SignIn(String name, String password, int typeUser){
    if(getUser(name) == null)
      {
    	byte[] passEncode = Base64.getEncoder().encode(password.getBytes());	
        User U = new User(name, passEncode , typeUser);
        users.add(U);
      }
  }
  
  public User getUser(String usuario){
    for(int indice = 0; indice < users.size(); indice++)
    {
      if(usuario.equals(users.get(indice).GetName())){
        return users.get(indice);
      }
    }
    return null;
  }

  public List<User> getListUsers(){
    return users;
  }

  public void RegistrarDireccion(String name, String latitud, String longitud, User usuario){
    Address d = new Address(name,latitud,longitud);
    getUser(usuario.GetName()).AddDirection(d);
  }

  public void CompletarPerfilAlimentario(int food, User usuario, String alergia){
	  
    switch(food){
    
      case 1:
      //Vegano
      getUser(usuario.GetName()).AddFoodProfile("Queso");
      getUser(usuario.GetName()).AddFoodProfile("Huevo");
      getUser(usuario.GetName()).AddFoodProfile("Gelatina");
      getUser(usuario.GetName()).AddFoodProfile("Leche");
      getUser(usuario.GetName()).AddFoodProfile("Res");
      getUser(usuario.GetName()).AddFoodProfile("Cerdo");
      getUser(usuario.GetName()).AddFoodProfile("Carne");
      getUser(usuario.GetName()).AddFoodProfile("Pescado");
      getUser(usuario.GetName()).AddFoodProfile("Pollo");
      getUser(usuario.GetName()).AddFoodProfile("Marisco");
      break;
      
      case 2:
      //Vegetariano
      getUser(usuario.GetName()).AddFoodProfile("Gelatina");
      getUser(usuario.GetName()).AddFoodProfile("Res");
      getUser(usuario.GetName()).AddFoodProfile("Cerdo");
      getUser(usuario.GetName()).AddFoodProfile("Pescado");
      getUser(usuario.GetName()).AddFoodProfile("Pollo");
      getUser(usuario.GetName()).AddFoodProfile("Marisco");
      break;
      
      case 3:
      //Gluten
      getUser(usuario.GetName()).AddFoodProfile("Trigo");
      getUser(usuario.GetName()).AddFoodProfile("Espelta");
      getUser(usuario.GetName()).AddFoodProfile("Centeno");
      getUser(usuario.GetName()).AddFoodProfile("Cebada");
      getUser(usuario.GetName()).AddFoodProfile("Avena");
      getUser(usuario.GetName()).AddFoodProfile("Kamut");
      getUser(usuario.GetName()).AddFoodProfile("Triticale");
      getUser(usuario.GetName()).AddFoodProfile("Escanda");
      break;
      
      case 4:
      //Halal
      getUser(usuario.GetName()).AddFoodProfile("Cerdo");
      getUser(usuario.GetName()).AddFoodProfile("Alcohol");
      break;
      
      case 5:
      //Kosher
      getUser(usuario.GetName()).AddFoodProfile("Cerdo");
      getUser(usuario.GetName()).AddFoodProfile("Marisco");
      break;
      
      case 6:
      getUser(usuario.GetName()).AddFoodProfile(alergia);
      break;
    }
  }

  public Dishes SolicitarMenu(User u){
    List<String> foodProf = new ArrayList<>();
    for(int indice = 0;indice<users.size();indice++)
    {
      if(users.get(indice).GetName().equals(u.GetName())){
        foodProf = users.get(indice).GetFoodProfile();
        break;
      }
    }
    Dishes tempPlat = platillos;

    for(int a = 0; a < foodProf.size(); a++)
    {
      int b = 0;
      while(b < tempPlat.size()){
        for(int c = 0; c < tempPlat.get(b).GetIngredientes().size(); c++)
        {
          if(tempPlat.get(b).GetIngredientes().get(c).GetNombre().equals(foodProf.get(a))){
            tempPlat.remove(b);
            b = b-1;
            break;
          }
        }
        b++;
      }
    }

    return tempPlat;
  }



  public void AgregarPlatillo(Dish dish){
    platillos.add(dish);
  }

  public Inventory VerInventario(){
    return inventario;
  }

  public void AgregarIngrediente(Ingredient ing){
    inventario.add(ing);
  }


}
