
public class Dish {

	private String name;
	private float price;
	private String recipe;
	private Inventory ingredients;
	
	public Dish(String name, String recipe, Inventory ingredients) {
		super();
		this.name = name;
		this.recipe = recipe;
		this.ingredients = ingredients;
	}
	
	public String GetName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecipe() {
		return recipe;
	}

	public void setRecipe(String recipe) {
		this.recipe = recipe;
	}

	public Inventory GetIngredientes() {
		return ingredients;
	}

	public void setIngredients(Inventory ingredients) {
		this.ingredients = ingredients;
	}
		
	public float GetPrecio(Inventory inventory) {
		float cost = 0;
		for(int i=0; i<inventory.size(); i++) {
			cost += inventory.get(i).GetPrecio() * inventory.get(i).GetCantidad();
		}
		return cost;
	}
	
}
