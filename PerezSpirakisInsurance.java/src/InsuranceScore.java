/*
 * Models the risk associated with each member using an object of class InsuranceScore that stores the name, score, and risk level for a member.
 *
 * the work for this class is all  ready done withhin the assessor class
 * i just have to moste the fnction into to this class  * 
 * 
 */
public class InsuranceScore {
	String name, score, level;
	
	public InsuranceScore(){
		name = "" ; score = "" ; level = "";		
	}
	
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
