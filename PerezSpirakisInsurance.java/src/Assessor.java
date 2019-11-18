/**
 * This class will do the calculation for assessing each member such as 
 * the score for each member, put a risk level based on that score.
 * It will store that information that it just calculated into a 
 * InsureanceScore object which there will be a ArrayList. 
 * 
 * */

import java.util.ArrayList;
public class Assessor {
	
	//will hold the list of the members passed passed from main
	private ArrayList<Member> members;
	
	private ArrayList<InsuranceScore> mem = new ArrayList<InsuranceScore>();
	
	
	//Constructor methods
	public Assessor() {
		members = null;	
		mem = null;
	}	

	//overload
	public Assessor(ArrayList<Member> mems) {//pass the list of members
		members = mems;
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
	 * The function will need two inputs and will return a String.
	 * This will see what Blood Pressure a member has based on the two numbers
	 * from the inputs.
	 * There are only 5 different Strings that it can return
	 * normal, elevated, stage1, stage2, and crisis
	 * 
	 * @return String
	 * */
	public String evalBP(int sys, int dia ) {
		
		if(sys < 120 && dia < 80) {
			return "normal";
		}
		else if( (120<=sys && sys<=129) && (dia<80) ){
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
		else {return "normal"; }//need this for the default function return 			
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
			
			//saving results the array list called mem				
			mem.add(new InsuranceScore(name, ""+point, risk));				
		}//end if i loop			
	}	
	
	/**
	 * This function must be called with in main it will start the whole process 
	 * of the assessing and it will be start the calucaltion process
	 * pass list of insureanceScore to a object of InsuranceScoreWriter
	 * whcih wll then call a function in that class to printout the date out to the console 
	 * 
	 * */
	public void startAssessor() {
		evalAll();
		InsuranceScoreWriter ISW = new InsuranceScoreWriter(mem);		
		ISW.printRisk();
	}
	
	
}//end of class