import java.util.ArrayList;
import java.util.Scanner;
import java.beans.XMLDecoder;
import java.io.*;
public class MemberReader {

	public static ArrayList<String> readDataFile(String fname){
		try {
		ArrayList<String> Members = new ArrayList<String>();
		Scanner fsc = new Scanner(new File(fname));
		String line;
		while (fsc.hasNextLine()) {
			line = fsc.nextLine().trim();
			if (line.length() > 0) {
				Members.add(line);
			}
		}
		fsc.close();
		return Members;
	}catch (Exception ex) {
		return null; // indicates a problem
	}
}
	public static ArrayList<Member> readMemberFromBinary(String fname){
		try {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
			ArrayList<Member> result = (ArrayList<Member>)ois.readObject();
			ois.close();
		}catch(Exception ex) {
			return null;
		}
	}
	public static ArrayList<Member> readMemberFromXML(String fname){
		try {
			XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(fname)));
			ArrayList<Member> result = (ArrayList<Member>)dec.readObject();
			dec.close();
		}catch(Exception ex) {
			return null;
		}
	}
	
}
