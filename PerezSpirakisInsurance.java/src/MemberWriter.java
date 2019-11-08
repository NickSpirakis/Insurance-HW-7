import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.beans.XMLEncoder;
import org.json.simple.*;
//writing as binary


public class MemberWriter {
	
	public static boolean writeMembersToBinary(String fname, ArrayList<Member> members) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fname));
			oos.writeObject(members);
			oos.close();
		return true;
			
		}catch(Exception ex) {
			return false;
		}
	}
	
	public static boolean writeMembersToXML(String fname, ArrayList<Member> members) {
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(fname)));
			enc.writeObject(members);
			enc.close();
		return true;
		}catch(Exception ex) {
			return false;
		}
	}
	public static boolean writeMembersToJSON(String fname, ArrayList<Member> members) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedOutputStream(new FileWriter(fname)));
			JSONObject memObj;
			JSONArray array = new JSONArray();
			for (Member mem : members) {
				memObj = new JSONObject();
				//memObj.put("name", mem.getFirstName());
				
			}
			
		}
	}
	
}

