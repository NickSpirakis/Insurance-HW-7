/**
 * 
 * 
 * */

import java.io.*;
import java.util.ArrayList;
import org.json.simple.*;		//FIXME TODO the static thing issue 
public class InsuranceScoreWriter {///have to make this who;e ont tp  astatoc one ???????????

	private static ArrayList<InsuranceScore> inSc;
	
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
	public static void printRisk() {
		
		System.out.println("\nHere are the insurance assessments:");
		for(int i =0; i<inSc.size(); i++) {
			System.out.printf("Name:    %20s\n", inSc.get(i).getName()  );
			System.out.printf("Score:   %20s\n", inSc.get(i).getScore() );
			System.out.printf("Verdict: %20s\n", inSc.get(i).getLevel() );
			System.out.println("");//spacer
		}//end of loop		
	}
	
	
	
	/////code for the JSON/////
	public static boolean assessorToJson(String fname, ArrayList<InsuranceScore> islist ) {//ghe array list is in a gobal scoop
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			
			//making a json objects
			JSONObject stuObj;
			JSONArray array = new JSONArray();
			for(InsuranceScore is : islist) { // just going thort one by one of the member 
				stuObj = new JSONObject();
				stuObj.put("name", is.getName());
				stuObj.put("score", is.getScore());
				stuObj.put("Risk",is.getLevel());
				array.add(stuObj);
			}
			JSONObject outer = new JSONObject();
			outer.put("members", array);//puttint the hlist with  in a list 
			pw.println(outer.toJSONString());//printing to a file
			
			pw.close();
			return true ;
		}catch(Exception ex) {
			return false;			
		}
		
	}//end if function	
	
}//end of class
