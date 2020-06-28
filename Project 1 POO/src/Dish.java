
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

	//ADD calculatePrice(Inventory ingredients)
	
	public String getName() {
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

	public Inventory getIngredients() {
		return ingredients;
	}

	public void setIngredients(Inventory ingredients) {
		this.ingredients = ingredients;
	}
	
	
}
