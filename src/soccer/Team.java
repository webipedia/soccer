package soccer;

public class Team {
	
	private String name;
	private String foundationYear;
	private String rankingPosition;
	
	public Team() {
		super();
	}
	
	public Team(String name, String foundationYear, String rankingPosition) {
		super();
		this.name = name;
		this.foundationYear = foundationYear;
		this.rankingPosition = rankingPosition;
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

}
