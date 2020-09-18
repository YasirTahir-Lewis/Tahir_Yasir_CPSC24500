import java.util.Currency;
import java.util.Locale;
// This program is for calculating the number of laminating boards we need to cover the room floor 
public class Flooring {

// Function calculates the area of single laminating board
	public static float computeAreaOfBoard () {
	
		int boardWidth = 6;
		int boardLength = 30;
		float areaOfBoard = boardWidth * boardLength;
		return areaOfBoard;
		
	}
	
// Function Calculates the area of room before subtracting the corner
	public static int computeAreaOfRoom () {
		
		int roomWidth = 25;
		int roomLength = 20;
		int areaOfRoom = roomWidth * roomLength;
		return areaOfRoom;
		
	}
	
// Function Calculates the area of right triangle which is missing from room
	public static double computeAreaOfTriangle () {
		
		int roomWidth = 25;
		int roomLength = 20;
		int base = roomLength - 10;
		int perpendicular = roomWidth - 13;
		double areaOfTriangle = 0.5 * (base * perpendicular);
		return areaOfTriangle;
		
	}
	public static void main(String[] args) {
		
		
		float areaOfPackage; int packagesRequired; double costOfOnePackage = 24.99; int costOfTotalPackages; int areaAvailable;
		
// Getting US Currency sign from java library
		Locale locale = Locale.US;
		Currency USCurrency = Currency.getInstance(locale);
		
		String symbol = USCurrency.getSymbol();
// This will calculate the area of room available for flooring
		areaAvailable = (int) ((computeAreaOfRoom()) - (computeAreaOfTriangle()));
		
// This will calculate how much area can we cover with one package of boards and converting it to sq.feet
// Each package contains 6 boards and we convert it from sq.inch to sq.feet
		areaOfPackage = (computeAreaOfBoard() * 6) / 144;
		
// This calculates How many packages do we need plus 20% waste
		packagesRequired = (int) ((int) ((areaAvailable / areaOfPackage)) * 1.20);
				
// This calculates the cost of packages required
		costOfTotalPackages = (int) (costOfOnePackage * packagesRequired);
		
// This prints out the values for total cost and packages required
		System.out.println("Area of floor covered by one package of board: " + areaOfPackage + " sq.feet");
		System.out.println("No. of packages of board required including wastage: " + packagesRequired);
		System.out.println("Cost of Packages of board: " + symbol + (costOfTotalPackages));
		
				
		
	}

}

