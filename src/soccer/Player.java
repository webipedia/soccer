package soccer;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name="players")
public class Player implements Serializable {
	
	static final long serialVersionUID = 3;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_PLAYER")
	private int id;
	
	@Column(name="NAME")
	private String name;
	
	@Column(name="GOALS")
	private String goals;
	
	@Column(name="COUNTRY")
	private String country;
	
	@Column(name="AGE")
	private String age;
	
	@ManyToOne
	@JoinColumn(name="ID_TEAM")
	@JsonBackReference
	private Team team;
	
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
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Team getTeam() {
		return team;
	}

	public void setTeam(Team team) {
		this.team = team;
	}
	
}
