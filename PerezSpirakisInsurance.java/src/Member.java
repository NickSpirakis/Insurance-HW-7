import java.io.*;
import java.util.ArrayList;

//must have a public default constructor
public class Member implements Serializable{
	
	private String firstName;
	private String lastName;	
	/*
	 * age in years
	 * height in inches
	 * weight in pounds
	 * BPS = Blood Pressure Systolic
	 * BPD = Blood pressure Diastolic
	 * */
	private int age, height, weight, BPS, BPD; 
	/*
	 * can = Cancer
	 * dia = Diabetes
	 * alz = Alzheimers
	 * 
	 * true = yes
	 * false = no
	 * */
	
	//TODO change this into to a String data type
	private boolean can, dia, alz;
	//TODO change the getter and the setter for these three data types
	
	
	// getter and setter	//
		
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getBPS() {
		return BPS;
	}

	public void setBPS(int bPS) {
		BPS = bPS;
	}

	public int getBPD() {
		return BPD;
	}

	public void setBPD(int bPD) {
		BPD = bPD;
	}

	public boolean isCan() {
		return can;
	}

	public void setCan(boolean can) {
		this.can = can;
	}

	public boolean isDia() {
		return dia;
	}

	public void setDia(boolean dia) {
		this.dia = dia;
	}

	public boolean isAlz() {
		return alz;
	}

	public void setAlz(boolean alz) {
		this.alz = alz;
	}
		
	//This is a default constructor
	public Member() {
		firstName = "";
		lastName = "";
		
		age = 0; 
		height = 0;
		weight = 0;
		BPS = 0;
		BPD = 0; 
		 
		can = false;
		dia = false;
		alz = false;
	}
	

	
	@Override
	public String toString() {
		String line = "";
		
		line = line + String.format("%s, %s\n", getLastName(), getFirstName() );
		line = line + String.format("Age\t\t\t %d\n", getAge());
		line = line + String.format("Height\t\t\t %d\n", getHeight());
		line = line + String.format("Weight\t\t\t %d\n", getWeight());
		line = line + String.format("BP Syst\t\t\t %d\n", getBPS());
		line = line + String.format("BP Dias\t\t\t %d\n", getBPD());
		line = line + String.format("Cancer\t\t\t %b", );//TODO FIXME finish up the last part only after i change the datatype to a String
		line = line + String.format("Diabetes       ", );
		line = line + String.format("Alzheimers     ", );
		line = line + "-------------------------";
		
		
		return line; 
	}
	
}
