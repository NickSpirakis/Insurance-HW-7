/**
 * This class will do the calculation of the risk of each of the member in the list 
 * it will then print out the the risk of each member to the conslue 
 *  
 * 
 * */

import java.util.ArrayList;

public class Assessor {
	
	private ArrayList<Member> members;//hold the list of the members
	/*
	 * it will hold:
	 * full name 
	 * risk score
	 * verdit 
	 * */
	private String [][] riskMembers; //this will hold the member data on rather there are a risk of not  
	
		
	
	
	public Assessor() {
		members = null;	
		riskMembers = null;
	}
	

	public Assessor(ArrayList<Member> mems) {
		members = mems;
								//the number oif member  //there information
		riskMembers = new String [members.size()] [3];
	}
	
	
	//function for the BMI
	public int calBMI(int h, int w) {
		
		return 0;
	}	
	
	public string elvBMI() {}
	
	//function for bloodpressure 
	public String elvBP(int s, int d ) {
		
		return "";
	}
	
	public int totalPoints(String BMI, String BP, int age, boolean c, boolean d, boolean a ) {
		
		
		return 0;
	}
	
	//function to pick the risk name and saving to the list 
	public void eval() {
		int BMI;
		String BP;
		int point;//??
		
		for(int i=0; i<members.size(); i++) {
						//for the papam  enter the height then weight
			BMI = calBMI();
					//this need two papam systolic and diastolic
			BP = calBP();
			
			point = totalPoints();
			
			
			
		}
				
		
	}
	
	//last step print ou the list of rht string[][]
	public void printRisk() {
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
