import java.util.ArrayList;
import java.util.Scanner;
import java.beans.XMLDecoder;
import java.io.*;
public class MemberReader {

	/**
	 * This function will read in a text tab-delimited file 
	 * 
	 * @param String
	 * */
	public static ArrayList<Member> readDataFile(String fname){
		ArrayList<Member> result = new ArrayList<Member>();
					//i should be able to do this on 11/7/2019 around the after noon
		try {	//FIXME re write this function to make it read the file 
			//something to so is make a String list then .split(\t) for each line from the text file 
			//
			
	
		Scanner fsc = new Scanner(new File(fname));
		String line, name, insurance;
		Member mem;
		while (fsc.hasNextLine()) {
			name = fsc.next();
			//insurance = fsc.nextLine().trim();
			//mem = new Member(name, insurance);
			result.add(mem);
			}
		fsc.close();
		return result;
	}catch (Exception ex) {
		return null; // indicates a problem
	}
}
	
	
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
	
}
