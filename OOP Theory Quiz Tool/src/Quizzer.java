import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This class is used to take number of questions user want to take the quiz
 * And then it selects random questions of that number from the whole question array
 * And then show the questions one by one and give the choices
 * After that we take the user answer and compare it with actual answer and keep the number of correct answers
 * In the end we tell the user how many questions he got right 
 * @author yasir
 *
 */
public class Quizzer {
	
	public static void PrintQuestions(String fname) {
		Scanner sc = new Scanner(System.in);
		Random rnd = new Random();
		System.out.println();
		System.out.print("How many questions would you like? ");
		int noq = sc.nextInt();
		sc.nextLine();

		try {
			ArrayList<Question> questions = new ArrayList<Question>();
			QuestionReader qr = new QuestionReader();
			questions = qr.readFromJSON(fname);
			int j=0;
		 
			for (int i=0; i<noq; i++) {
				int quesindex = rnd.nextInt(questions.size());
				Question questionObject = questions.get(quesindex);
				System.out.println();
				System.out.println(questionObject.getQuestion());
				System.out.println(questionObject.getA());
				System.out.println(questionObject.getB());
				System.out.println(questionObject.getC());
				System.out.println(questionObject.getD());
				String answer = questionObject.getAnswer();
				System.out.print("Type the letter of your choice: ");
				String choiceans = sc.nextLine();
				if (choiceans.equalsIgnoreCase(answer)) {
					j++;
					System.out.println("You selected the correct answer!");
				} else {
					System.out.println("Sorry the correct answer is " + answer + ".");
				}
			}
			System.out.println();
			System.out.println("You answered " + j + " correct out of " + noq + " questions asked.");
			
		} catch (Exception ex) {
			System.out.println("Fail");
			return;
		}
		
	}
}
