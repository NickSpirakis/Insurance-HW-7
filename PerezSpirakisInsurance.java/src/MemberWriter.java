import java.io.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import java.beans.XMLEncoder;
import org.json.simple.*;
//writing as binary


public class MemberWriter {
	
	//this function writes to a text file
	public static boolean writeMembersToTextFile(String fname, ArrayList<Member> mems) {
		PrintWriter pw;
		try {
			pw = new PrintWriter(new BufferedWriter(new FileWriter(fname)));
			
			
		}catch(Exception ex) {
			return false;
		}
		
		
		String line = "etsetsetse";
		for(int i = 0; i<mems.size(); i++) {
			//first name, last name, age, height, weight, bps, bpd, hascancer, hasdia, hasalz 
			//pw.print(line);
			
			line = String.format("%s\t%s\t%d\t%d\t%d\t%d\t%d\t%s\t%s\t%s\n",  mems.get(i).getFirstName(), mems.get(i).getLastName(), mems.get(i).getAge(), 
			mems.get(i).getHeight(), mems.get(i).getWeight(), mems.get(i).getBPS(), mems.get(i).getBPD(), 
			mems.get(i).getCan(), mems.get(i).getDia(), mems.get(i).getAlz());
			pw.print(line);	
		}
		pw.close();
		return true;
		
		
	}
	
	//this function writes to a binary file
	public static boolean writeMembersToBinary(String fname, ArrayList<Member> members) {  //FIXME TODO have to redo odo the function in thie class must out put the text liek the one on the exampe 
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

