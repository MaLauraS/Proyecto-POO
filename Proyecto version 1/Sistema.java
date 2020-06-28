import java.util.ArrayList;
import java.util.List;

public class Sistema {
  
  private List<User> users = new ArrayList<>();
  private List<Platillo> platillos = new ArrayList();
  private List<Ingrediente> inventario = new ArrayList();

  public Sistema(List<User> users, List<Platillo> platillos, List<Ingrediente> inventario){
    this.users = users;
    this.platillos = platillos;
  }

  public Sistema(){

  }

  public boolean LogIn(String usuario, String password){
    if(getUser(usuario) != null && getUser(usuario).GetPassword() == password){
      return true;
    } else {
      return false;
    }
  }

  public void SignIn(String name, String password, char typeUser){
    if(getUser(name) == null)
      {
        User U = new User(name, password, typeUser);
        users.add(U);
      }
  }
  
  public User getUser(String usuario){
    for(int indice = 0;indice<users.size();indice++)
    {
      if(users.get(indice).GetName() == usuario){
        return users.get(indice);
      }
    }
    return null;
  }

  public void RegistrarDireccion(String name, float latitud, float longitud, User usuario){
    Direction d = new Direction(name,latitud,longitud);
    usuario.AddDirection(d);
  }

  public void CompletarPerfilAlimentario(int food, User usuario, String alergia){
    switch(food){
      case 1:
      //Vegano
      usuario.AddFoodProfile("Queso");
      usuario.AddFoodProfile("Huevo");
      usuario.AddFoodProfile("Gelatina");
      usuario.AddFoodProfile("Leche");
      usuario.AddFoodProfile("Res");
      usuario.AddFoodProfile("Cerdo");
      usuario.AddFoodProfile("Pescado");
      usuario.AddFoodProfile("Pollo");
      usuario.AddFoodProfile("Marisco");
      break;
      case 2:
      //Vegetariano
      usuario.AddFoodProfile("Gelatina");
      usuario.AddFoodProfile("Res");
      usuario.AddFoodProfile("Cerdo");
      usuario.AddFoodProfile("Pescado");
      usuario.AddFoodProfile("Pollo");
      usuario.AddFoodProfile("Marisco");
      break;
      case 3:
      //Gluten
      usuario.AddFoodProfile("Trigo");
      usuario.AddFoodProfile("Espelta");
      usuario.AddFoodProfile("Centeno");
      usuario.AddFoodProfile("Cebada");
      usuario.AddFoodProfile("Avena");
      usuario.AddFoodProfile("Kamut");
      usuario.AddFoodProfile("Triticale");
      usuario.AddFoodProfile("Escanda");
      break;
      case 4:
      //Halal
      usuario.AddFoodProfile("Cerdo");
      usuario.AddFoodProfile("Alcohol");
      break;
      case 5:
      //Kosher
      usuario.AddFoodProfile("Cerdo");
      usuario.AddFoodProfile("Marisco");
      break;
      case 6:
      usuario.AddFoodProfile(alergia);
      break;
    }
  }

  public List<Platillo> SolicitarMenu(User u){
    List<String> foodProf = new ArrayList<>();
    for(int indice = 0;indice<users.size();indice++)
    {
      if(users.get(indice).GetName() == u.GetName()){
        foodProf = users.get(indice).GetFoodProfile();
        break;
      }
    }
    List<Platillo> tempPlat = platillos;

    for(int a = 0; a < foodProf.size(); a++)
    {
      int b = 0;
      while(tempPlat.get(b) != null){
        for(int c = 0; c < tempPlat.get(b).GetIngredientes().size(); c++)
        {
          if(tempPlat.get(b).GetIngredientes().get(c).GetNombre() == foodProf.get(a)){
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



  public void AgregarPlatillo(Platillo dish){
    platillos.add(dish);
  }

  public List<Ingrediente> VerInventario(){
    return inventario;
  }

  public void AgregarIngrediente(Ingrediente ing){
    inventario.add(ing);
  }


}