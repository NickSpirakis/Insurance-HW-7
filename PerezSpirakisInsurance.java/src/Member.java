import java.io.*;
import java.util.ArrayList;

//must have a public default constructor
public class Member implements Serializable{
	
	private String name;
	private ArrayList<Integer> insurance;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ArrayList<Integer> getInsurance(){
		return insurance;
	}
	
	public void setInsurance(ArrayList<Integer> insurance) {
		this.insurance = insurance;
	}
	
	public void setInsurance(String insuranceString) {
		insuranceString = insuranceString.trim();
		String[] parts = insuranceString.split("	");
		insurance = new ArrayList<Integer>();
		for (String part : parts) {
			insurance.add(Integer.parseInt(part));
		}
	}
	
	public Member(String name, String insuranceString) {
		setName(name);
		setInsurance(insuranceString);
	}
	
	public Member (String name, ArrayList<Integer> insurance) {
		setName(name);
		setInsurance(insurance);
	}
	
	//this will be a public default constructor for xml
	public Member() {
		name = "";
		insurance = null;
	}
	
	public String getInsuranceAsString() {
		String result = "";
		for (int insure : insurance) {
			result = result + insure + " ";
		}
		result = result.trim();
		return result;
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", name, getInsuranceAsString());
	}
	
}
