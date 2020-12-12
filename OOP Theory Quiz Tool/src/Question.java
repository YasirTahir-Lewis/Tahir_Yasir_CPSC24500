/**
 * This is our model class
 * We use it store data which are Questions, options and their answers here
 * @author yasir
 *
 */
public class Question {
	private String question;
	private String a;
	private String b;
	private String c;
	private String d;
	private String answer;
	
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getA() {
		return a;
	}
	public void setA(String a) {
		this.a = a;
	}
	public String getB() {
		return b;
	}
	public void setB(String b) {
		this.b = b;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getD() {
		return d;
	}
	public void setD(String d) {
		this.d = d;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Question() {
		question = "none";
		a = "none";
		b = "none";
		c = "none";
		d = "none";
		answer = "none";
	}
	
	public Question(String question, String a, String b, String c, String d, String answer) {
		setQuestion(question);
		setA(a);
		setB(b);
		setC(c);
		setD(d);
		setAnswer(answer);
	}
	
	public void allQuestions(String question, String answer) {
		setQuestion(question);
		setAnswer(answer);
	}
	@Override
	public String toString() {
		return (answer + "  " + question); 
		
	}

}
