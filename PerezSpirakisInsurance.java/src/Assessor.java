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
	
	
	//Constructor methods
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
	public String evalBMI(int height, int weight) {
		//the unit system is in Imperial units (lb and inches )
		double bmi =((weight*703) / Math.pow(height,2));
		
		if( bmi <= 24.9 ) {
			return "normal";
		}else if(  25.0<=bmi || bmi<=29.9 ) {			
			return "overweight";
		}else {//30.0-34.9			
			return "obesity";
		}		
	}
	
	//function for bloodpressure 
	public String evalBP(int sys, int dia ) {
		//will return one of this strings
		//normal, elevated,stage1, stage2, crisis
		
		if(sys < 120 && dia < 80) 
		{
			return "normal";
		}
		else if( (120<=sys && sys<=129) && (dia<80) ) 
		{
			return "elevted";
		}
		else if( (130<=sys && sys<=139) || (dia<=80 && dia<=89) ) {
			
			return "stage1";
		}
		else if(  (140<=sys && sys<180) || (90<=dia && dia<120) ) {
			
			return "stage2";
		}	
		else //if(180<=sys || 120<=dia)
		{
			return "crisis";
		}	
			
	}
	
	//this function will totlat all the points for the peoples information 
	public int totalPoints(String BMI, String BP, int age, String c, String d, String a ) {
		int totalPoint = 0;
		
		//BMI
		if(BMI.equals("normal")) {
			totalPoint = totalPoint + 0;
		}
		else if(BMI.equals("overweight")) {
			totalPoint = totalPoint + 30;
			
		}
		else if(BMI.equals("obesity")) {
			totalPoint = totalPoint + 75;
		}
				
		//Blood Pressure
		if(BP.equals("normal")) {
			totalPoint = totalPoint + 0;
		}
		else if(BP.equals("elevated")) {
			totalPoint = totalPoint + 15;
			
		}
		else if(BP.equals("stage1")) {
			totalPoint = totalPoint + 30;
		}
		else if(BP.equals("stage2")) {
			totalPoint = totalPoint + 75;
		}
		else if(BP.equals("crisis")) {
			totalPoint = totalPoint + 100;
		}
		
		//Age
		if(age<30) {
			totalPoint = totalPoint + 0;
		}
		else if(30<=age && age<45) {
			totalPoint = totalPoint + 10;
		}
		else if(45<=age && age<60) {
			totalPoint = totalPoint + 20;
		}
		else {
			totalPoint = totalPoint + 30;
		}		
		
		//the three question
			//cancer
		if(c.equals("n")) {totalPoint = totalPoint + 10;}
			//diabetes
		if(d.equals("n")) {totalPoint = totalPoint + 10;}
			//alzhe
		if(a.equals("n")) {totalPoint = totalPoint + 10;}
		
		
		return totalPoint;
	}
	
	public String calRisk(int num) {
		
		if(num<=20) {
			return "low risk";
		}
		else if(20<num && num<=50) {
			return "moderate risk";
		}
		else if(50<num && num<=75) {
			return "high risk";
		}
		else {
			return "uninsurable";
		}
	}
	
	
	public void printRisk() {
		System.out.println("Here are the insurance assessments:");
		
		for(int i = 0; i<members.size(); i++) {
			System.out.printf("Name: %20s\n", riskMembers[i][0]);
			System.out.printf("Score: %20s\n", riskMembers[i][1]);
			System.out.printf("Verdict: %20s\n", riskMembers[i][2]);
			System.out.println("");//spacer
		}		
	}		
	
	//function to pick the risk name and saving to the list 
	public void evalAll() {//this is main function to call to get everything started in one go
		String BMI = "";
		String BP = "";
		int point = 0;
		String risk = "";
		String name = "";
		
		for(int i=0; i<members.size(); i++) {
						//for the papam  enter the height then weight
			BMI = evalBMI(members.get(i).getHeight(), members.get(i).getWeight());
					//this need two papam systolic and diastolic
			BP = evalBP(members.get(i).getBPS(), members.get(i).getBPS());
			
			point = totalPoints(BMI, BP, members.get(i).getAge(), members.get(i).getCan(), members.get(i).getDia(), members.get(i).getAlz() );	
			
			risk = calRisk(point);
			
			name = members.get(i).getLastName() +", " + members.get(i).getFirstName();
			
			riskMembers[i][0] = name ;
			riskMembers[i][1] =  ""+point ;//like casting to a string
			riskMembers[i][2] = risk;			 
			
		}//end if i loop
		
		printRisk();		
	}	
	
}//end of class
