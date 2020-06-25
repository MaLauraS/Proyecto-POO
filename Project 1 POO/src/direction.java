import java.util.HashMap;
import java.util.Map;

public class direction {

	private String name;
	private float[] location;
	Map<String, float[]> address = new HashMap<String, float[]>();
	
	public direction(String name, float latitude, float longitude) {
		super();
		this.name = name;
		this.location = new float[]{latitude, longitude};
		this.address.put(this.name, this.location);
	}
	
}
