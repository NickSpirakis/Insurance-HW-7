/**
 * This class will do the calculation of the risk of each of the member in the list 
 * it will then print out the the risk of each member to the conslue 
 *  
 * 
 * */

import java.util.ArrayList;

public class Assessor {//this is proprly  going to be a static class
	
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
	
	
	//function for the BMI return a string 		
	public String elvBMI(int height, int weight) {
		//the unit system is in Imperial units (lb and inches )
		double  bmi =((weight*703) / Math.pow(height,2));
		
		if( bmi <= 24.9 ) {
			return "normal";
		}else if(  25.0<=bmi || bmi<=29.9 ) {			
			return "overweight";
		}else {//30.0-34.9			
			return "obesity";
		}		
	}
	
	//function for bloodpressure 
	public String elvBP(int sys, int dia ) {
				////have to change the print stat into return
		//hav eto check the logic
		//need to reuten normal, elevated,stage1, stage2, crisis
		
		if(sys < 120 && dia < 80) 
		{
			System.out.println("Normal");
		}
		else if( (120<=sys && sys<=139) | (80<=dia && dia<=89)    ) 
		{
			System.out.println("Prehypertension");
		}
		
		//add satge two 
		
		else if ( 140<=sys | 90<=dia  ) 
		{
			System.out.println("High Blood Pressure");
		}	
		//add cirst 
		
		
	}
	
	public int totalPoints(String BMI, String BP, int age, boolean c, boolean d, boolean a ) {
		
		
		return 0;
	}
	
	//function to pick the risk name and saving to the list 
	public void evalAll() {
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
	
	
	
	
	
	
	
}//end of class
