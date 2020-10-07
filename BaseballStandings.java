import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class BaseballStandings {

	public static int showMenuAndGetChoice(Scanner sc) {
		System.out.println("Which standings would you like to see?");
		System.out.println("1. AL East");
		System.out.println("2. AL Central");
		System.out.println("3. AL West");
		System.out.println("4. NL East");
		System.out.println("5. NL Central");
		System.out.println("6. NL West");
		System.out.println("7. Overall");
		System.out.println("8. Exit");
		System.out.print("Enter the number of your choice: ");
		int choice = sc.nextInt();
		return choice;
	}
	
	
	public static double getBehind(String line) {
		double behind;
		int diffWins, diffLosses, prevWins, prevLosses;
		prevWins = 0;
		prevLosses = 0;
		String[] parts = line.split("\t");
		diffWins = prevWins + Integer.parseInt(parts[1]);
		diffLosses = prevLosses + Integer.parseInt(parts[2]);
		behind = (diffWins + diffLosses) / 2;
		return behind;
	}
	public static void printStats(ArrayList<String> lines) {
		String[] parts; String name; int wins, losses; double pct, behind;
		System.out.println("Team		Wins	Losses	Pct.	Behind");
		System.out.println("--------------------------------------");
		for (String line : lines) {
			parts = line.split("\t");
			name = parts[0];
			pct = Integer.parseInt(parts[1]) / (Integer.parseInt(parts[1]) + Integer.parseInt(parts[2]));
			behind = getBehind(line);
			System.out.println(name + "\t" + "\t" + parts[1] + "\t" + parts[2] + "\t" + pct +"\t" + behind);
		}
	}
	
//	public static double getAverage(String line) {
//		String[] parts = line.split("\t");
//		double avg = (Integer.parseInt(parts[1]) + (Integer.parseInt(parts[2]))) / 2.0;
//		return avg;
//	}
	public static void main(String[] args) {
		String line, standing, league;
		boolean canGoAhead;
		int choice;
		String[] parts;
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the standings file: ");
		String fname = sc.nextLine();
		ArrayList<String> aleast = new ArrayList<String>();
		ArrayList<String> alcentral = new ArrayList<String>();
		ArrayList<String> alwest = new ArrayList<String>();
		ArrayList<String> nleast = new ArrayList<String>();
		ArrayList<String> nlcentral = new ArrayList<String>();
		ArrayList<String> nlwest = new ArrayList<String>();
		ArrayList<String> overall = new ArrayList<String>();
		ArrayList<String> target = null;
		
		
		try {
				Scanner fsc = new Scanner(new File(fname));
				while (fsc.hasNextLine()) {
					line = fsc.nextLine();
					parts = line.split("\t");
					if (parts[0].equalsIgnoreCase("LEAGUE")) {
						target = overall;
						target.add(line);
						league = parts[1].toUpperCase();
						if (league.equalsIgnoreCase("AL East")) {
							target = aleast;
						} else if (league.equalsIgnoreCase("AL Central")) {
							target = alcentral;
						} else if (league.equalsIgnoreCase("AL West")) {
							target = alwest;
						} else if (league.equalsIgnoreCase("NL East")) {
							target = nleast;
						} else if (league.equalsIgnoreCase("NL Central")) {
							target = nlcentral;
						} else if (league.equalsIgnoreCase("NL West")) {
							target = nlwest;
						} 
						
						} else {
								target.add(line);
						}
						
					
					}
					fsc.close();
					canGoAhead = true;
			}		catch (Exception ex) {
					System.out.println("Couldn't read the file.");
					canGoAhead = false;
}

		if (canGoAhead) {
			do {
				choice = showMenuAndGetChoice(sc);
				if (choice == 1) {
					printStats(aleast);
				} else if (choice == 2) {
					printStats(alcentral);
				} else if (choice == 3) {
					printStats(alwest);
				} else if (choice == 4) {
					printStats(nleast);
				} else if (choice == 5) {
					printStats(nlcentral);
				} else if (choice == 6) {
					printStats(nlwest);
				} else if (choice == 7) {
					printStats(overall);
				} else if (choice ==8 ) {
					System.out.println("Thank you for using the program. See you. Bye!");
					break;
				} else if (choice > 8 || choice < 0) {
					System.out.println("That was not a valid choice. Please select an option from above");
					showMenuAndGetChoice(sc);
				}
					
} while (choice != 9);

	}
}
}
				

