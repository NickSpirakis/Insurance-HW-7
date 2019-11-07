import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

//
public class Runner {

	public static void printStars(int howMany) {
		String stars = "";
		for (int i = 0; i < howMany; i++) {
			stars = stars + "*";
		}
		System.out.println(stars);
	}
	
	public static void printWelcome() {
		printStars(55);
		System.out.println("		Ensurance Score Card");
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
	
	public static void main(String[] args) {
		printWelcome();
		Scanner sc = new Scanner(System.in);
		int choice;
		String choose;
		System.out.println("Enter the name of member file: ");
		String fname = sc.nextLine();
		
		//FIXME TODO i am almost most done getter this thing  to work -Adrian
		ArrayList<Member> members = MemberReader.readDataFile(fname);
		
		if (members == null) {
			System.out.println("Something bad happened");
		}else {
			do {
				showMenu();
				choice = sc.nextInt();
				
				if (choice == 1) {
					System.out.println(members);
				}else if (choice == 2) {
					
				}else if (choice == 3) {
					System.out.println("(T)ext, (B)inary, (X)ml: ");
					choose = sc.next();
					
					if (choose == "T") {
						
					}else if (choose == "B") {
						ArrayList<Member> readFromBin = MemberReader.readMemberFromBinary(fname);
					//MemberWriter.writeMembersToBinary;
					}else if (choose == "X") {
					ArrayList<Member> readFromXML = MemberReader.readMemberFromXML(fname);
					}
					
					
					
				}else if (choice == 4) {
					
				}else if (choice == 5) {
					
				}else if (choice == 6) {
					
				}
				
			}while(choice != 7);
		}
		
		
	}

}
