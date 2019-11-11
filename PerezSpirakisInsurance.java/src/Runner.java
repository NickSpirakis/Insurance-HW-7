import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

//
public class Runner {
	public static ArrayList<Member> members ;
	
	public static void printStars(int howMany) {
		String stars = "";
		for (int i = 0; i < howMany; i++) {
			stars = stars + "*";
		}
		System.out.println(stars);
	}
	
	public static void printWelcome() {
		printStars(55);
		System.out.println("		Insurance Score Card");
		System.out.println("	This app scores a potential customer");
		System.out.println("	on various health attributes: blood");
		System.out.println("	pressure, age, height, weight, and");
		System.out.println("	family history of disease. It writes");
		System.out.println("	each members insurance grade to a");
		System.out.println("	JSON file so that they can be easily");
		System.out.println("	shared on a web based data exchange.");
		printStars(55);
	}
	
	public static void showMenu() {
		System.out.println("Here are your choices:");
		System.out.println("1. List members");
		System.out.println("2. Add a new member");
		System.out.println("3. Save members");
		System.out.println("4. Load members");
		System.out.println("5. Assess members");
		System.out.println("6. Save assessments as JSON");
		System.out.println("7. Exit");
		System.out.println("Enter the number of your choice: ");
	}
	
	public static void printMembers() {
		System.out.println("\nHere are the members: ");
		for(int i = 0; i<members.size();i++){
			System.out.println(members.get(i));			
		}//end for loop		
		System.out.println("");
	}
	
	public static void main(String[] args) {
		printWelcome();
		Scanner sc = new Scanner(System.in);
		int choice;
		String decide;
		String ofname;
		System.out.println("Enter the name of member file: ");
		String fname = sc.nextLine();
		
		//reading in the text file and save to list 
		members = MemberReader.readDataFile(fname);
		
		if (members == null) {
			System.out.println("Something bad happened");
		}else {
			do {
				showMenu();
				choice = sc.nextInt();
				
				if (choice == 1) {
					printMembers();					
					
				}else if (choice == 2) {
					
				}else if (choice == 3) {
					
				
					System.out.println("(T)ext, (B)inary, (X)ml: ");
					decide = sc.nextLine();
					
					//System.out.println("Enter the name of the output file: ");
					//ofname = sc.nextLine();
					
						if (decide.equals("T")) {
							System.out.println("Enter the name of the output file: ");
							ofname = sc.nextLine();
						
						}else if (decide.equals("B")) {
							System.out.println("Enter the name of the output file: ");
							ofname = sc.nextLine();
							ArrayList<Member> readFromBin = MemberReader.readMemberFromBinary(fname);
							System.out.println("Members were written successfully!");
					//MemberWriter.writeMembersToBinary;
						}else if (decide.equals("X")) {
							System.out.println("Enter the name of the output file: ");
							ofname = sc.nextLine();
							ArrayList<Member> readFromXML = MemberReader.readMemberFromXML(fname);
						}
					
				}else if (choice == 4) {
					
				}else if (choice == 5) {
					
				}else if (choice == 6) {
					System.out.println("Now we will write to JSON. Enter the file name: ");
					fname = sc.nextLine();
					if (MemberWriter.writeMembersToJSON(fname, members)) {
						System.out.println("The scores were written successfully.");
					} else {
						System.out.println("Something went wrong");
					}
				}
				
			}while(choice != 7);
		}
		
		
	}

}
