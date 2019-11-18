/**
 * 
 * 
 * */

import java.io.*;
import java.util.ArrayList;
import org.json.simple.*;		//FIXME TODO the static thing issue 
public class InsuranceScoreWriter {///have to make this who;e ont tp  astatoc one ???????????

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
	//FIXME TODO out this functio toption to th emain function of the main prgraon
	//do from get aboitu the if 
	public static boolean assessorToJson(String fname) {//ghe array list is in a gobal scoop
		
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			
			//making a json objects
			JSONObject stuObj;
			JSONArray array = new JSONArray();
			for(InsuranceScore is : inSc) {
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
			System.out.println("yes printed");
			return true ;
		}catch(Exception ex) {
			return false;			
		}
		
	}//end if function	
	
}//end of class
