import java.io.File;
import java.io.IOException;
import java.util.Base64;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

public class JSONParser  {
	
	private File file;
	private ObjectMapper mapper;
	private JsonNode node;
	
	public JSONParser() {
		file = new File("resources/data.json");
		mapper = new ObjectMapper();
		try {node = mapper.readTree(file);
		} 
		catch (JsonProcessingException e) {
			e.printStackTrace();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	public Inventory loadInventory() {
		Inventory inventory = new Inventory();
		ArrayNode ingredients = (ArrayNode) node.get("Inventory");
		
		if(ingredients != null) {
			for(int i=0; i<ingredients.size(); i++) {
				JsonNode ingredient = ingredients.get(i);
				String name = ingredient.get("ingredient").asText();
				float amount = ingredient.get("amount").asLong(); 
				float price = ingredient.get("price").asLong(); 
				Ingredient ingre = new Ingredient(name, amount, price);
				inventory.add(ingre);
			}
		}
		 return inventory;
	}
	
	
	public Dishes loadDishes() {
		Dishes dishes = new Dishes();
		ArrayNode dishs = (ArrayNode) node.get("Dishes");
		if(dishs != null) {
			for(int i=0; i<dishs.size(); i++) {
				Inventory inventory = new Inventory();
				JsonNode dish = dishs.get(i);
				String name = dish.get("dish").asText();
				String recipe = dish.get("recipe").asText();
				ArrayNode ingredients = (ArrayNode) dish.get("ingredients");			
				if(ingredients != null) {
					for(int j=0; j<ingredients.size(); j++) {
						JsonNode ingredient = ingredients.get(j);
						String nick = ingredient.get("ingredient").asText();
						float amount = ingredient.get("amount").asLong(); 
						float price = ingredient.get("price").asLong(); 
						Ingredient ingre = new Ingredient(nick, amount, price);
						inventory.add(ingre);
					}
				}
				Dish dsh = new Dish(name, recipe, inventory);
				dishes.add(dsh);
			}
		}
		 return dishes;
	}
	
	
	public Users loadUsers() {
		Users users = new Users();
		ArrayNode nodeuser = (ArrayNode) node.get("Users");
		
		if(nodeuser != null) {
			for(int i=0; i<nodeuser.size(); i++) {
				JsonNode user = nodeuser.get(i);
				String name = user.get("user").asText();
				String password = user.get("password").asText();
				byte[] passEncode = Base64.getEncoder().encode(password.getBytes());	
				int type = user.get("type").asInt();
				User nUser = new User(name, passEncode, type);
				users.add(nUser);
			}
		}
		 return users;
	}
	
}
		
