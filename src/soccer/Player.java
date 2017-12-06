package soccer;

public class Player {
	
	private String name;
	private String goals;
	private String country;
	private String age;
	
	public Player() {
		super();
	}
	
	public Player(String name, String goals, String country, String age) {
		super();
		this.name = name;
		this.goals = goals;
		this.country = country;
		this.age = age;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}

}
