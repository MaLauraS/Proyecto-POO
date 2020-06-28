import java.util.ArrayList;
import java.util.List;

public class Syst{
	
	JSONParser parser = new JSONParser();
	Users users = parser.loadUsers();
	Dishes dishes = parser.loadDishes();
	Inventory inventory = parser.loadInventory();
	
	public void signIn(String name, String password, String type) {
		if(getUser(name) == null) {
			User user = new User(name, password, type);
			users.add(user);
		}
		else {
			System.out.println("Username already exists");
		}
	}
	
	
	public boolean lognIn(String name, String password) {
		if(getUser(name) != null && getUser(name).getPassword() == password){
			return true;
		} else {
		    return false;
		}
	}	
	
	
	public User getUser(String name) {
		for(int i=0; i<users.size(); i++) {
			if(users.get(i).getName() == name) {
				return users.get(i);
			}
		}		
		return null;
	}
	
	
	public void RegisterAddress(String name, float latitude, float longitude, User user){
		Direction direction = new Direction(name, latitude, longitude);
		user.AddDirection(direction);
	}
	

	public void setFoodProfile(int food, User user, String allergy){
		switch(food){
	    case 1:
	    	//Vegano
	    	user.AddFoodProfile("Cheese");
	    	user.AddFoodProfile("Egg");
	    	user.AddFoodProfile("Jelly");
		    user.AddFoodProfile("Milk");
		    user.AddFoodProfile("Steak");
		    user.AddFoodProfile("Pork");
		    user.AddFoodProfile("Fish");
		    user.AddFoodProfile("Chicken");
		    user.AddFoodProfile("Seafood");
		    break;
	    case 2:
	    	//Vegetariano
		    user.AddFoodProfile("Jelly");
		    user.AddFoodProfile("Steak");
		    user.AddFoodProfile("Pork");
		    user.AddFoodProfile("Fish");
		    user.AddFoodProfile("Chicken");
		    user.AddFoodProfile("Seafood");
		      break;
	    case 3:
	    	//Gluten
		    user.AddFoodProfile("Wheat");
		    user.AddFoodProfile("Spelled");
		    user.AddFoodProfile("Rye");
	        user.AddFoodProfile("Barley");
	        user.AddFoodProfile("Oats");
		    user.AddFoodProfile("Kamut");
		    user.AddFoodProfile("Triticale");
		      break;
	    case 4:
	    	//Halal
		    user.AddFoodProfile("Pork");
		    user.AddFoodProfile("Alcohol");
	        break;
	    case 5:
	    	//Kosher
		    user.AddFoodProfile("Pork");
		    user.AddFoodProfile("Seafood");
		    break;
	    case 6:
	        user.AddFoodProfile(allergy);
	        break;
	    }
	}

	
	public Dishes RequestMenu(User user){
		List<String> foodProfile = new ArrayList<>();
	    for(int i = 0;i<users.size();i++) {
	    	if(users.get(i).getName() == user.getName()){
	    		foodProfile = users.get(i).GetFoodProfile();
	    		break;
	        }
	    }
	    Dishes auxDish = dishes;

	    for(int j=0; j< foodProfile.size(); j++) {
	    	int b = 0;
	    	while(auxDish.get(b) != null){
		        for(int c=0; c<auxDish.get(b).getIngredients().size(); c++) {
		        	if(auxDish.get(b).getIngredients().get(c).getIngredient() == foodProfile.get(j)){
		        		auxDish.remove(b);
		        		b--;
		        		break;
		        	}
		        }
		        b++;
	    	}
	    }
	    return auxDish;
	}


	  public void addDish(Dish dish){
	    dishes.add(dish);
	  }

	  
	  public Inventory seeInventory(){
	    return inventory;
	  }

	  
	  public void addIngredient(Ingredient ingredient){
		  inventory.add(ingredient);
	  }
}
