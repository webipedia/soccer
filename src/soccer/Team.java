package soccer;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="teams")
public class Team implements Serializable {
	
	static final long serialVersionUID = 1;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID_TEAM")
	private int id;

	@Column(name="NAME")
	private String name;
	
	@Column(name="FOUNDATION_YEAR")
	private String foundationYear;
	
	@Column(name="RANKING_POSITION")
	private String rankingPosition;
	
	@OneToOne(mappedBy="team",cascade=CascadeType.ALL)
	@PrimaryKeyJoinColumn
	@JsonManagedReference
	private Stadium stadium;
	
	@OneToMany(mappedBy="team",cascade=CascadeType.ALL)
	@JsonManagedReference
	private Set<Player> players;
	
	public Team() {
		super();
	}
	
	public Team(String name, String foundationYear, String rankingPosition) {
		super();
		this.name = name;
		this.foundationYear = foundationYear;
		this.rankingPosition = rankingPosition;
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
	
	public String getFoundationYear() {
		return foundationYear;
	}
	public void setFoundationYear(String foundationYear) {
		this.foundationYear = foundationYear;
	}
	
	public String getRankingPosition() {
		return rankingPosition;
	}
	public void setRankingPosition(String rankingPosition) {
		this.rankingPosition = rankingPosition;
	}
	
	public Stadium getStadium() {
		return stadium;
	}
	public void setStadium(Stadium stadium) {
		this.stadium = stadium;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}
		
}
