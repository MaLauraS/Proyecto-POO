
public class Syst{
	
	JSONParser parser = new JSONParser();
	Users users = parser.loadUsers();
	
	public void signIn(String name, String password) {
		User user = new User(name, password);
		users.add(user);
	}
	
	public void lognIn(String name, String password) {
		boolean found = false;
		for(int i=0; i<users.size(); i++) {
			if (users.get(i).getName() == name) {
				found = true;
				//user found
				break;
			}
			
		}
		if(found) {
			//Login
		}
		else {
			// Unregistered User
		}
		
	}	
	
}
