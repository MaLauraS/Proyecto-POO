import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class User{

	private String name;
	private byte[] password;
	private int type;
	private List<Address> adresses = new ArrayList<>();
	private List<String> foodProfile = new ArrayList<>();
	
	public User(String name, byte[] passEncode, int typeUser) {
		super();
		this.name = name;
		this.password = passEncode;
		this.type = typeUser;
	}

	public User() {
		// TODO Auto-generated constructor stub
	}

	public String GetName() {
		return name;
	}
	
	public String GetPassword() {
		  byte[] decodedBytes = Base64.getDecoder().decode(password);
		  String passDecode = new String(decodedBytes);
		  return passDecode;
	}
	
	 public int GetTypeUser() {
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

