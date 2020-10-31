import java.util.Random;	
import java.util.Scanner;

// This program is to create three buildings which are build using | and _
// Building widths are decided by the user which must be an odd integer
// Building heights (floors) are decided randomly by the computer from the range of 2 to 8 (any even number)
public class Buildings {
	
	// This method prints out the heading
	public static void displayHeading() {
		
				System.out.println("Programming Fundamentals");
				System.out.println("Name: Yasir Tahir");
				System.out.println("PROGRAMMING ASSIGNMENT 2\n");
} 
	
	// This method gets us the buildings widths from the user
	public static int getBuildingWidth(int buildingNumber) {
		
		int buildingWidth = 0, testBuildingWidth;
		Scanner scan = new Scanner(System.in);
		
		System.out.print("Enter the width of building " + buildingNumber + " (an odd number): ");
		testBuildingWidth = scan.nextInt();
		
		// Loop to make sure user enters odd number for the width of the building
		do  {
			
			if (testBuildingWidth % 2 == 0) {
				System.out.println("Invalid Input! Width needs to be odd.");
				System.out.print("Reenter the width of building " + buildingNumber + " (an odd number):");
				testBuildingWidth = scan.nextInt();
		} else {
		}
		}  while (testBuildingWidth % 2 == 0); 
		
		buildingWidth = testBuildingWidth;
		return buildingWidth;
}
	
	// This method creates random building height which are floors
	public static int getRandomBuildingHeight() {
		int buildingHeight;
		
		Random rand = new Random();
		buildingHeight = rand.nextInt(7) + 2;
		
		// Loop to make sure we get out even floors
		do {
			if ((buildingHeight % 2) != 0) {
				buildingHeight = rand.nextInt(7) + 2;
			} else {
				
			}
		} while ((buildingHeight % 2) != 0);
		
		return buildingHeight;
		
}
	
	// This method is to create buildings with the given widths and heights from other two methods
	public static void showBuildings(int width1, int height1, int width2, int height2, int width3, int height3) {
		
		// Creates the first building
		for (int h = 0; h<width1;h++) {
		System.out.print("_");
		}
		for (int i = 1; i<=height1;i++) {
			System.out.print("\n");
			for (int j = 0; j<width1;j++) {
		
			System.out.print("| ");
			j++;
		}
		
		System.out.print("\n|");
		
			for (int k = 1; k<width1;k++) {
			
				System.out.print("_");
				k++;
				System.out.print('|');
				
			}
	}
	
		// Creates the second building
		System.out.println(" ");
		for (int s = 0; s<width2;s++) {
			System.out.print("_");
			}
		for (int l = 1; l<=height2;l++) {
			System.out.print("\n");
			for (int m = 0; m<width2;m++) {
		
			System.out.print("| ");
			m++;
		}
		
		System.out.print("\n|");
		
			for (int n = 1; n<width2;n++) {
			
				System.out.print("_");
				n++;
				System.out.print('|');
				
			}
		}
			
			// Creates the third building
			System.out.println(" ");
			for (int o = 0; o<width3;o++) {
				System.out.print("_");
				}
			for (int p = 1; p<=height3;p++) {
				System.out.print("\n");
				for (int q = 0; q<width3;q++) {
			
				System.out.print("| ");
				q++;
			}
			
			System.out.print("\n|");
			
				for (int r = 1; r<width3;r++) {
				
					System.out.print("_");
					r++;
					System.out.print('|');
					
				}
	}
}

		public static void main(String[] args) {
		int buildingNumberFixed = 3, buildingNumber, width1 = 0, width2 = 0, width3 = 0, height1 = 0, height2 = 0, height3 = 0;
		
		// First method used to display heading
		displayHeading();
		
		// This loop is to designed to assign widths and height for all three building to their variables using methods
		for (int i = 0; i<buildingNumberFixed; i++) {
			
		buildingNumber = i + 1;
		if (i==0) {
			width1 = getBuildingWidth(buildingNumber);
			height1 = getRandomBuildingHeight();
		} else if (i==1) {
			width2 = getBuildingWidth(buildingNumber);
			height2 = getRandomBuildingHeight();
		} else if (i==2) {
			width3 = getBuildingWidth(buildingNumber);
			height3 = getRandomBuildingHeight();
		} else {
		}
		}
		
		// And lastly we use this method to pass widths and heights variable values to their functions and display the buildings
		showBuildings(width1, height1, width2, height2, width3, height3);
		
}
}

