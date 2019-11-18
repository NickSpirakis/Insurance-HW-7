import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.beans.XMLEncoder;
import org.json.simple.*;
//writing as binary


public class MemberWriter {
	
	//this function writes to a text file
	public static boolean writeMembersToTextFile(String fname, ArrayList<Member> members) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			
			for (Member m : members) {
				pw.println(m);
			}
			pw.close();
			return true;
		}catch(Exception ex) {
			return false;
		}
	}
	
	//this function writes to a binary file
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
	
	//this function writes to a XML file
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
	
	//this function will write to a json file
	public static boolean writeMembersToJSON(String fname, ArrayList<Member> members) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			JSONObject memObj;
			JSONArray array = new JSONArray();
			for (Member mem : members) {
				memObj = new JSONObject();
				memObj.put("First name", mem.getFirstName());
				memObj.put("Last name", mem.getLastName());
				memObj.put("Age", mem.getAge());
				memObj.put("Height", mem.getHeight());
				memObj.put("Weight", mem.getWeight());
				memObj.put("Blood Pressure Systolic", mem.getBPS());
				memObj.put("Blood Pressure Diastolic", mem.getBPD());
				memObj.put("Cancer", mem.getCan());
				memObj.put("Diabetes", mem.getDia());
				memObj.put("Alzheimers", mem.getAlz());
			}
			JSONObject outer = new JSONObject();
			outer.put("Members", array);
			pw.println(outer.toJSONString());
			pw.close();
			return true;
			
		}catch (Exception ex){
			return false;
		}
	}
	
}

