import java.util.ArrayList;
import java.util.List;

public class User{

	private String name;
	private String password;
	private String type;
	private List<Address> adresses = new ArrayList<>();
	private List<String> foodProfile = new ArrayList<>();
	
	public User(String name, String password, String type) {
		super();
		this.name = name;
		this.password = password;
		this.type = type;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	
	public String getPassword() {
		return password;
	}
	
	 public String getType() {
		return type;
	 }
	 
	 public List<Address> GetDirections() {
	    return adresses;
	  }

	  public List<String> GetFoodProfile() {
	    return foodProfile;
	  }

	  public void AddDirection(Address dir) {
	    adresses.add(dir);
	  }

	  public void AddFoodProfile(String food) {
	    foodProfile.add(food);
	  }
	  
}

