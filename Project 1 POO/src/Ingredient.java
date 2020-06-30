
public class Ingredient {

	private String name;
	private float amount;
	private float price;
	
	public Ingredient(String name, float amount, float price) {
		super();
		this.name = name;
		this.amount = amount;
		this.price = price;
	}

	public String getIngredient() {
		return name;
	}
	
	public float GetCantidad() {
		return amount;
	}
	
	public float GetPrecio() {
		return price;
	}
	
	public String GetNombre() {
		return name;
	}
	
	public void takeAmount(float amount) {
		this.amount -= amount;
	}

	public void addAmount(float amount) {
		this.amount += amount;
	}	
	
	
		
}
