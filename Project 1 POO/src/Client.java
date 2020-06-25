
public class Client extends User{

	private direction[] addresses;
	private feedingType[] foodProfile;
	
	public Client(String name, String password) {
		super(name, password, 3);
	}
	
	public void addAdress() {
		String name; 
		addresses += direction(name);
	}

	@Override
	public void signIn(String name, String password) {
	}

	@Override
	public void lognIn(String name, String password) {
	}
}
