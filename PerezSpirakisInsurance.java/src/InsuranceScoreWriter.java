//JSON file writter
/*Uses a class called InsuranceScoreWriter to write the insurance risk information in a nicely formatted way to the screen.*/
/*Uses a class called InsuranceScoreWriter to write the insurance risk information to a JSON file.*/

import java.util.ArrayList;
public class InsuranceScoreWriter {//FIXME TODO thi class may have to be a static class

	ArrayList<InsuranceScore> inSc;
	
	public InsuranceScoreWriter() {
		inSc = null;
	}
	
	public InsuranceScoreWriter(ArrayList<InsuranceScore> temp) {//going to use this to pass the array from the assessor class 
		inSc = temp;
	}	
	
	
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
