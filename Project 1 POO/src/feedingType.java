import java.util.HashMap;
import java.util.Map;

public class feedingType {
	private String type;
	private String[] doesNotEat;
	Map<String, String[]> feeding = new HashMap<String, String[]>();
	
	public feedingType(String type, String[] doesNotEat) {
		super();
		this.type = type;
		this.doesNotEat = doesNotEat;
		this.feeding.put(this.type, this.doesNotEat);
	}
	
	
}
