package soccer;

public class Stadium {
	
	private String capacity;
	private String name;
	private String city;
	
	public Stadium() {
		super();
	}
	
	public Stadium(String capacity, String name, String city) {
		super();
		this.capacity = capacity;
		this.name = name;
		this.city = city;
	}
	
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}

}
