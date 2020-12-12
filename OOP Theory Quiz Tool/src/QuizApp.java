import java.util.ArrayList;
import java.util.Scanner;

/*
 * This is our main class which we use print things like header, footer and choice menu
 * After that we take user's choice and call the class which is appropriate 
 */
public class QuizApp {
	
	public static String PrintHeader(Scanner sc) {
		System.out.println("*          What could possibly be more fun than this?           *");
		System.out.println("*****************************************************************");
		System.out.println("*               OOP Theory and Concept Questions                *");
		System.out.println("*****************************************************************");
		System.out.println("*          Nothing. Nothing at all. Nope. Nada. Nunca.          *");
		System.out.println();
		System.out.print("Enter name of file containing questions: ");
		String fn = sc.nextLine();
		System.out.println();
		return fn;
	}
	
	public static int showMenuAndGetChoice(Scanner sc) {
		System.out.println("Here are your choices: ");
		System.out.println("1. Take a quiz.");
		System.out.println("2. See questions and answers");
		System.out.println("3. Exit");
		System.out.print("Enter the number of your choice: ");
		int result = sc.nextInt();
		sc.nextLine();
		return result;
	}
	
	public static void printQuestion() {
		
	}

	public static void main(String[] args) {
		int choice;
		Scanner sc = new Scanner(System.in);
		QuestionReader qr = new QuestionReader();
		String fn = PrintHeader(sc);
		do {
			choice = showMenuAndGetChoice(sc);
			if (choice==1) {
				Quizzer.PrintQuestions(fn);
			} else if (choice==2) {
				QuestionPrinter.PrintAllQuestions(fn);
			}
				System.out.println();				
			}			
			while (choice!=3);
			System.out.println("*****************************************************************");
			System.out.println("*               Thank you for taking CPSC 24500                 *");
			System.out.println("*****************************************************************");			
	}

}
