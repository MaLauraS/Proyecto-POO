import java.util.ArrayList;
import java.util.List;

public class Client extends User{

	private List<Direction> addresses = new ArrayList<>();
	private List<String[]> foodProfile = new ArrayList<>();
	
	public Client(String name, String password) {
		super(name, password);
	}
	
	public void addAdress(String name, int lat, int lon) {
		Direction na = new Direction(name, lat, lon);
		this.addresses.add(na);
		
	}
	
	public void addFoodProfile(String[] type) {
		this.foodProfile.add(type);
		
	}

}

