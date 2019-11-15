/**
 * This class will do the calculation of the risk of each of the member in the list 
 * it will then print out the the risk of each member to the conslue 
 * 
 * */

import java.util.ArrayList;

public class Assessor {
	
	//will hold the list of the members passed passed from main
	private ArrayList<Member> members;
	
	/*
	 * it will hold:
	 * full name 
	 * risk score
	 * verdit 
	 * {{name,socre, ver},
	 * {--,--,--},
	 * {--,--}}
	 * 
	 * */
	private String [][] riskMembers; 
	
	
	//Constructor methods
	public Assessor() {
		members = null;	
		riskMembers = null;
	}	

	public Assessor(ArrayList<Member> mems) {
		members = mems;
					// [#of members] [3 data points needed]
		riskMembers = new String [members.size()] [3];
	}
	
	
	/**
	 * This function will calculate the Body Mass Index (BMI)
	 * it needs two int the height and weight (in that order) 
	 * and then it will return one of three Strings
	 * 'normal', 'overweight', 'obesity'
	 * 
	 * @param int height int weight
	 * @return String: 'normal', 'overweight', 'obesity'
	 * */		
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
	
	/**
	 * 
	 * 
	 * @return String
	 * */
	public String evalBP(int sys, int dia ) {
		//will return one of this strings
		//normal, elevated,stage1, stage2, crisis
		
		if(sys < 120 && dia < 80) {
			return "normal";
		}
		else if( (120<=sys && sys<=129) && (dia<80) )		{
			return "elevated";
		}
		else if( (130<=sys && sys<=139) || (80<=dia && dia<=89) ){
			return "stage1";
		}
		else if(  (140<=sys && sys<180) || (90<=dia && dia<120) ) {			
			return "stage2";
		}	
		else if(180<=sys || 120<=dia){
			return "crisis";
		}	
		else {return "normal"; }//need this for the defluat function return 			
	}
	
	/**
	 * The function will calculate the total number of points 
	 * from each of the different factors BMI, BloodPessure, 
	 * age and the three health question  
	 * 
	 * This function will need 6 input, 5 String 1 int 
	 * @return int 
	 * */
	private int totalPoints(String BMI, String BP, int age, String c, String d, String a ) {
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
		else {totalPoint = totalPoint + 0;}
				
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
		else {totalPoint = totalPoint + 0;}
		
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
		else if(60 <= 60) {
			totalPoint = totalPoint + 30;
		}
		
		//the three question
			//cancer
		if(c.equals("y")) {totalPoint = totalPoint + 10;}
			//diabetes
		if(d.equals("y")) {totalPoint = totalPoint + 10;}
			//alzhe
		if(a.equals("y")) {totalPoint = totalPoint + 10;}
		
		return totalPoint;
	}
	
	/**
	 * This function will be called only after totalPoint() has done its worked
	 * this function then can be use then output one of three string based
	 * on the number of points a member has gained
	 *  
	 * @return String
	 * */
	private String calRisk(int num) {
		
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
	
	/**
	 * All right, this function does  most of the 'heavy lifting'
	 * it calls the other functions to do the calculations once that is 
	 * it will save the data into a double string array for each member 
	 * that will then later be used to print a report
	 * 
	 * @return void
	 * */
	private void evalAll() {
		String BMI = "";
		String BP = "";
		int point = 0;
		String risk = "";
		String name = "";
		
		for(int i=0; i<members.size(); i++) {
						//enter the height then weight
			BMI = evalBMI(members.get(i).getHeight(), members.get(i).getWeight());
					//this need two papam systolic and diastolic
			BP = evalBP(members.get(i).getBPS(), members.get(i).getBPD());
				//total all the point based on thiese factors
			point = totalPoints(BMI, BP, members.get(i).getAge(), members.get(i).getCan(), members.get(i).getDia(), members.get(i).getAlz() );	
			//set it into one of three category's
			risk = calRisk(point);
			//setting full name 
			name = members.get(i).getLastName() +", " + members.get(i).getFirstName();
			//saving results into a double string array
			riskMembers[i][0] = name ;
			riskMembers[i][1] =  ""+point ;//like casting to a string
			riskMembers[i][2] = risk;				
		}//end if i loop			
	}	
	
	/**
	 * This will print out a report on the members it will do it some
	 * System.out.println Statements within an a for loop
	 * @return System.out.println()
	 * */
	public void printRisk() {//this function has to be called from the main
		evalAll();
		System.out.println("Here are the insurance assessments:");
		
		for(int i = 0; i<members.size(); i++) {
			System.out.printf("Name:    %20s\n", riskMembers[i][0]);
			System.out.printf("Score:   %20s\n", riskMembers[i][1]);
			System.out.printf("Verdict: %20s\n", riskMembers[i][2]);
			System.out.println("");//spacer
		}		
	}	
}//end of class