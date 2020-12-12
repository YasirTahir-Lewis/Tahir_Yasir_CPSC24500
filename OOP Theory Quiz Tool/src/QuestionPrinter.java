import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/*
 * We use this class to print all the questions will answers to check
 */
public class QuestionPrinter {

	public static void PrintAllQuestions(String fname) {
		 try {
				ArrayList<Question> questions = new ArrayList<Question>();
				QuestionReader qr = new QuestionReader();
				questions = qr.readFromJSON(fname);
				System.out.println();
				System.out.println("Here are the answers:");
				for (Question ques: questions) {
					System.out.println(ques);	
				}
			} catch (Exception ex) {
				return;
			}		 
	}
	
}


