
public class Ingredient {

	private String name;
	private int amount;
	
	public Ingredient(String name, int amount) {
		super();
		this.name = name;
		this.amount = amount;
	}

	public String seeIngredient() {
		return name;
	}
	
	public int seeAmount() {
		return amount;
	}
	
	public void getAmount(int amount) {
		this.amount -= amount;
	}

	public void addAmount(int amount) {
		this.amount += amount;
	}	
		
}
