/**
 * This is our model class.
 * It stores our data, and nothing more.
 * This holds data about each movie saved in file.
 * @author yasir
 *
 */
public class Movie {
	private String title;
	private String company;
	private String director;
	private String producer;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getProducer() {
		return producer;
	}
	public void setProducer(String producer) {
		this.producer = producer;
	}
	public Movie() {
		title = "none";
		company = "none";
		director = "none";
		producer = "none";
	}
	public Movie(String title, String company, String director, String producer) {
		setTitle(title);
		setCompany(company);
		setDirector(director);
		setProducer(producer);
	}
	@Override
	public String toString() {
		return String.format("%s\n%s\n%s\n%s",title,company,director,producer);
	}
}