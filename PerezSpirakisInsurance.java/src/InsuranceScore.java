/**
 * This class will be used to hold a member data
 * such as their full name, health score, and the risk level. 
 * 
 * This class will be used to make a list of objects from
 * 
 * */
public class InsuranceScore {
	private String name, score, level;
	
	public InsuranceScore(){
		name = ""; score = ""; level = "";		
	}
	
	//over overload
	public InsuranceScore(String na, String scr, String lev) {
		name = na; score = scr; level  = lev;		
	}
	
	//getter's and setter's
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScore() {
		return score;
	}

	public void setScore(String score) {
		this.score = score;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}
		
}//end of class
