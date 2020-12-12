import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * This is our controller class
 * This class is used to read the data off from JSON object file
 * We parse the data from the file and iterate through data and
 * Then we add some stuff like a. and b. and print to give it to Quizzer class
 * @author yasir
 *
 */
public class QuestionReader {
	
	public ArrayList<Question> readFromJSON(String fname) {
		try {
			ArrayList<Question> Questions = new ArrayList<Question>();
			FileReader reader = new FileReader(new File(fname));
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)parser.parse(reader);
			JSONArray arr = (JSONArray)all.get("questions");
			Iterator itr = arr.iterator(); // This will help me step through every entry in arr
			JSONObject questionObject;
			String question, a, b, c, d, answer;
			int i=0;
			while (itr.hasNext()) {
				i++;
				questionObject = (JSONObject)itr.next();
				question = questionObject.get("question").toString();
				a = questionObject.get("a").toString();
				b = questionObject.get("b").toString();
				c = questionObject.get("c").toString();
				d = questionObject.get("d").toString();
				answer = questionObject.get("answer").toString();
				Questions.add(new Question(question,"a. " + a,"b. " + b,"c. " + c,"d. " + d,answer));
			}
			reader.close();
			return Questions;
		} catch (Exception ex) {
			return null;
		}
		 
	}
		
}
