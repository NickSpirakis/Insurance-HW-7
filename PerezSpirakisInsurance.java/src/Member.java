/**
 * This Member class will hold a persons information
 * such as their first and last name, age, height, weight
 * blood pressure of systolic and diastolic,
 * and three yes or no question 
 * 
 * */
import java.io.Serializable;

//must have a public default constructor
public class Member implements Serializable{//FIXME there might be a error with the Serializable not sure?
	
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
	 * y = yes
	 * n = no
	 * */
	private String can, dia, alz;
	
	
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

	public String getCan() {
		return can;
	}

	public void setCan(String can) {
		this.can = can;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public String getAlz() {
		return alz;
	}

	public void setAlz(String alz) {
		this.alz = alz;
	}
		
	
	//This is a public default constructor
	public Member() {
		firstName = "";
		lastName = "";
		
		age = 0; 
		height = 0;
		weight = 0;
		BPS = 0;
		BPD = 0; 
		 
		can = "n";
		dia = "n";
		alz = "n";
	}	
	
	
	/**
	 * This is a overload constructor that can take in 10 parameters
	 * note: this follows the format with the text file 
	 * 
	 * @param String firstName String lastName, int age, int height, int weight, int bPS, int bPD, String can,
	 * String dia, String alz
	 * 
	 * */
	public Member(String firstName, String lastName, int age, int height, int weight, int bPS, int bPD, String can,
			String dia, String alz) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.height = height;
		this.weight = weight;
		BPS = bPS;
		BPD = bPD;
		this.can = can;
		this.dia = dia;
		this.alz = alz;
	}

	
	/**
	 * overriding the toString() function to display all of the information 
	 * that is within the class  
	 * */
	@Override
	public String toString() {
		String line = "";
		
		line = line + String.format("%s, %s\n", getLastName(), getFirstName() );
		line = line + String.format("Age %15d\n", getAge());
		line = line + String.format("Height %15d in\n", getHeight());
		line = line + String.format("Weight %15d lbs\n", getWeight());
		line = line + String.format("BP Sys %15d\n", getBPS());
		line = line + String.format("BP Dias %15d\n", getBPD());
		line = line + String.format("Cancer %15s\n", getCan());
		line = line + String.format("Diabetes %15s\n", getDia());
		line = line + String.format("Alzheimers %15s\n", getAlz());
		line = line +               "-------------------------------------";		
		
		return line; 
	}
	
}
