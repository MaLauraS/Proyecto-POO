import java.util.ArrayList;
import java.util.List;

public class User{

	private String name;
	private String password;
  private char typeUser;
  private List<Direction> adresses = new ArrayList<>();
  private List<String> foodProfile = new ArrayList<>();
	
	public User(String name, String password, char typeUser) {
		this.name = name;
		this.password = password;
    this.typeUser = typeUser;
	}

  public String GetName(){
    return name;
  }

  public String GetPassword(){
    return password;
  }

  public char GetTypeUser(){
    return typeUser;
  }

  public List<Direction> GetDirections(){
    return adresses;
  }

  public List<String> GetFoodProfile(){
    return foodProfile;
  }

  public void AddDirection(Direction dir){
    adresses.add(dir);
  }

  public void AddFoodProfile(String food){
    foodProfile.add(food);
  }
}