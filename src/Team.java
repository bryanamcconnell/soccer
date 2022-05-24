
public class Team {

	private String name, cityName;
	private double atkRating, defRating, baseScore;
	private int tableRank, id;
	
	public Team() {
		
	}

	public Team(String name, double atkRating, double defRating, int tableRank, double baseScore, int id) {
		this.name = name;
		this.atkRating = atkRating;
		this.defRating = defRating;
		this.tableRank = tableRank;
		this.baseScore = baseScore;
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getCityName() {
		return cityName;
	}


	public void setCityName(String cityName) {
		this.cityName = cityName;
	}


	public double getAtkRating() {
		return atkRating;
	}


	public void setAtkRating(double atkRating) {
		this.atkRating = atkRating;
	}


	public double getDefRating() {
		return defRating;
	}


	public void setDefRating(double defRating) {
		this.defRating = defRating;
	}


	public int getTableRank() {
		return tableRank;
	}


	public void setTableRank(int tableRank) {
		this.tableRank = tableRank;
	}


	public double getBaseScore() {
		return baseScore;
	}


	public void setBaseScore(double baseScore) {
		this.baseScore = baseScore;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Team [name=" + name + ", cityName=" + cityName + ", atkRating=" + atkRating + ", defRating=" + defRating
				+ ", tableRank=" + tableRank + ", baseScore=" + baseScore + ", id=" + id + "]";
	}
	
	
}

