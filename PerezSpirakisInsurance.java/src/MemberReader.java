import java.util.ArrayList;
import java.util.Scanner;
import java.beans.XMLDecoder;
import java.io.*;
public class MemberReader {

	public static ArrayList<Member> readDataFile(String fname){
		ArrayList<Member> result = new ArrayList<Member>();
		try {
		Scanner fsc = new Scanner(new File(fname));
		String line, name, insurance;
		Member mem;
		while (fsc.hasNextLine()) {
			name = fsc.next();
			insurance = fsc.nextLine().trim();
			mem = new Member(name, insurance);
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
