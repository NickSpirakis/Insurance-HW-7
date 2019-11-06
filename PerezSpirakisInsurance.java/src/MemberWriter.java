import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.beans.XMLEncoder;
//writing as binary


public class MemberWriter {
	
	public static boolean writeMembersToBinary(String fname, ArrayList<Member> members) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
			oos.writeObject(members);
			oos.close();
		return true;
			
		}catch(Exception ex) {
			
		}
	}
	
	public static boolean writeMembersToXML(String fname, ArrayList<Member> members) {
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fname)));
			enc.writeObject(members);
		
		}catch(Exception ex) {
			
		}
	}
	
	
	
}

