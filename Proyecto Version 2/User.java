import java.util.ArrayList;
import java.util.List;

public class User{

	private String name;
	private String password;
  private int typeUser = 0;
  private List<Direction> adresses = new ArrayList<>();
  private List<String> foodProfile = new ArrayList<>();
	
	public User(String name, String password, int typeUser) {
		this.name = name;
		this.password = password;
    this.typeUser = typeUser;
	}

  public User(){

  }

  public String GetName(){
    return name;
  }

  public String GetPassword(){
    return password;
  }

  public int GetTypeUser(){
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

