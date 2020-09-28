import java.util.Scanner;
import java.util.Random;
public class GameZone {

// Function to print out the Welcome header
	public static void printHeading() {
		System.out.println("*********************************************");
		System.out.println("*         Welcome to the Game Zone          *");
		System.out.println("*********************************************");
	}
	
// Function to print out the Menu of game	
	public static void printMenu() {
		System.out.println("What would you like to play?");
		System.out.println("1. Twenty-one");
		System.out.println("2. Rock Paper Scissors");
		System.out.println("3. Neither - I'm done!");
}

// This functions runs the rock paper scissors game
	public static void gameTwo() {
		Random rand = new Random();
		String userChoiceString = "a", botChoiceString = "b"; int userRandomChoice, botChoice;
		userRandomChoice = rand.nextInt(3) + 1;
		
		if (userRandomChoice==1) {
			userChoiceString = "Paper";
		} else if (userRandomChoice == 2) {
			userChoiceString = "Scissors";
		} else if (userRandomChoice == 3) {
			userChoiceString = "Rock";
		}
		
		botChoice = rand.nextInt(3) + 1;
		if (botChoice == 1) {
			botChoiceString = "Paper";
		} else if (botChoice == 2) {
			botChoiceString = "Scissors";
		} else if (botChoice == 3) {
			botChoiceString = "Rock";
		}
		
		if (userRandomChoice == botChoice) {
			System.out.println("You played " + userChoiceString + ", and the computer played " + botChoiceString);
			System.out.println("It's a tie.");
		} else if (userChoiceString.equals("Paper") && botChoiceString.equals("Scissors")) {
			System.out.println("You played " + userChoiceString + ", and the computer played " + botChoiceString);
			System.out.println("You lost!");
		} else if (userChoiceString.equals("Scissors") && botChoiceString.equals("Paper")) {
			System.out.println("You played " + userChoiceString + ", and the computer played " + botChoiceString);
			System.out.println("Nice. You Won!");
		} else if (userChoiceString.equals("Rock") && botChoiceString.equals("Scissors")) {
			System.out.println("You played " + userChoiceString + ", and the computer played " + botChoiceString);
			System.out.println("Nice. You Won!");
		} else if (userChoiceString.equals("Scissors") && botChoiceString.equals("Rock")) {
			System.out.println("You played " + userChoiceString + ", and the computer played " + botChoiceString);
			System.out.println("You lost!");
		} else if (userChoiceString.equals("Paper") && botChoiceString.equals("Rock")) {
			System.out.println("You played " + userChoiceString + ", and the computer played " + botChoiceString);
			System.out.println("Nice. You Won!");
		} else if (userChoiceString.equals("Rock") && botChoiceString.equals("Paper")) {
			System.out.println("You played " + userChoiceString + ", and the computer played " + botChoiceString);
			System.out.println("You lost!");
		} 
	}
	@SuppressWarnings("unlikely-arg-type")
	
// Main function to run other 2 functions and ask a user for game choice
	public static void main(String[] args) {
		int userChoice, userDrew, userTotal, botTotal;
		String userDrawChoice;
		
		Random rnd = new Random();
		userChoice = 1;
		printHeading();

// while loop to run the game unless user wants to quit 
		while (userChoice > 0 && userChoice < 4) {
		
		System.out.println("\n");
		printMenu();
		
		Scanner scan = new Scanner (System.in);
		System.out.print("Please enter the number of your choice: ");
		userChoice = scan.nextInt();
		userDrawChoice = "y";
		userTotal = 0;
		
		if (userChoice == 1) {
	
// While loop to keep asking the user if they want to draw another card
			while (userDrawChoice.equals("y")) {
			userDrew = rnd.nextInt(11) + 1;
			System.out.println("You drew " + userDrew);
			userTotal = userTotal + userDrew;
			System.out.println("Your current total is " + userTotal + ".");
			System.out.print("Do you want to draw another card? ");
			userDrawChoice = scan.next();
			}
			
			botTotal = rnd.nextInt(20-13) + 1 + 13;
			
			if (botTotal > userTotal) {
				System.out.println("The Computer drew " + botTotal + ".");
				System.out.println("You lost.");
			} else if (userTotal >= 21) {
				System.out.println("You won automatically! Your total was equal or greater than 20");
			} else if (botTotal < userTotal) {
				System.out.println("The Computer drew " + botTotal + ".");
				System.out.println("Congratulations! You Won!");
			} else if (userTotal == botTotal) {
				System.out.println("The Computer drew " + botTotal + ".");
				System.out.println("It's a tie.");
			}
		} else if (userChoice == 2) {
			gameTwo();
			
		} else if (userChoice == 3) {
			System.out.println("Thank you for playing. Bye!");
			break;
		} else {
			System.out.println("Sorry. You didn't entered a valid option.");
			break;
		}
		
}
		
		}
}
