/**
 * 
 * 
 * */

import java.util.ArrayList;
public class InsuranceScoreWriter {

	private ArrayList<InsuranceScore> inSc;
	
	public InsuranceScoreWriter() {
		inSc = null;
	}
	
	//over load
	public InsuranceScoreWriter(ArrayList<InsuranceScore> temp) {//Using this to pass the array from the assessor class 
		inSc = temp;
	}	
	
	/**
	 * This function will print out to the console in a nice format
	 * displaying a members assessed information	 * 
	 * */
	public void printRisk() {
		
		System.out.println("\nHere are the insurance assessments:");
		for(int i =0; i<inSc.size(); i++) {
			System.out.printf("Name:    %20s\n", inSc.get(i).getName()  );
			System.out.printf("Score:   %20s\n", inSc.get(i).getScore() );
			System.out.printf("Verdict: %20s\n", inSc.get(i).getLevel() );
			System.out.println("");//spacer
		}//end of loop		
	}
	
	
	
	/////code for the JSON/////
	//this code is for option 6 
	
	
	
}//end of class
