import java.util.ArrayList;
import java.util.List;

public class Syst{
	static List<String[]> users = new ArrayList<>();
	
	public void signIn(String name, String password) {
		String[] nUser = {name, password}; 
		users.add(nUser);
	}
	
	public void lognIn(String name, String password) {
		boolean found = false;
		String[] userAux;
		for(int i=0; i<users.size(); i++) {
			if (users.get(i)[0] == name) {
				found = true;
				userAux = users.get(i);
				break;
			}
			
		}
		if(found) {
			//Logn in
		}
		else {
			// Unregistered User
		}
		
	}	
	
}
