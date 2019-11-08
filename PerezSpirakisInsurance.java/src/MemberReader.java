import java.util.ArrayList;
import java.util.Scanner;
import java.beans.XMLDecoder;
import java.io.*;
import org.json.simple;
public class MemberReader {

	/**
	 * This function will read in a text tab-delimited file 
	 * 
	 * @param String
	 * */
	public static ArrayList<Member> readDataFile(String fname){
		ArrayList<Member> result = new ArrayList<Member>();
						
		try {
			Scanner fsc = new Scanner(new File(fname));
			String line;
			String [] parts;
			
			while(fsc.hasNextLine()) {
				line = fsc.nextLine();
				
				parts = line.split("\t"); //split line by the tabs and making a list
				
				result.add(new Member(parts[0], parts[1], Integer.parseInt(parts[2]), Integer.parseInt(parts[3]),
						Integer.parseInt(parts[4]), Integer.parseInt(parts[5]), Integer.parseInt(parts[6]),
						parts[7], parts[8], parts[9]));					
			}//end of while loop			
			fsc.close();			
			return result;			
		}catch (Exception ex) {
			System.out.println("There was a problem load in the text file");
			ex.printStackTrace();//for debugging 
			return null; // indicates a problem
		}
			
	}//end of readDataFile()
	
	
	public static ArrayList<Member> readMemberFromBinary(String fname){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
			ArrayList<Member> result = (ArrayList<Member>)ois.readObject();
			ois.close();
			return result;
		}catch(Exception ex) {
			return null;
		}
	}
	public static ArrayList<Member> readMemberFromXML(String fname){
		try {
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(fname)));
			ArrayList<Member> result = (ArrayList<Member>)dec.readObject();
			dec.close();
			return result;
		}catch(Exception ex) {
			return null;
		}
	}
	
}//end of class
