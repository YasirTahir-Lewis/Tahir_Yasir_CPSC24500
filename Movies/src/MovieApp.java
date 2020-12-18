import java.util.ArrayList;
import java.util.Scanner;

public class MovieApp {

	public static int showMenuAndGetChoice(Scanner sc) {
		System.out.println("Here are your choices: ");
		System.out.println("1. Add a movie.");
		System.out.println("2. Print movies.");
		System.out.println("3. Save movies.");
		System.out.println("4. Delete movies.");
		System.out.println("5. Load movie.");
		System.out.println("6. Write to text");
		System.out.println("7. Exit");
		System.out.print("Enter your choice: ");
		int result = sc.nextInt();
		sc.nextLine(); // clear the end-of-line marker
		return result;
	}
	
	public static void printMovies(ArrayList<Movie> movies) {
		for (Movie movie : movies) {
			System.out.println(movie);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		/* 
		 * this will present a menu of options to the user.
		 * the user will be able to create movies, print them,
		 * delete them, and save to a json file.
		 */
		int choice;
		String title, company, director, producer;
		Scanner sc = new Scanner(System.in);
		Movie movie;
		ArrayList<Movie> movies = new ArrayList<Movie>();
		int toRemove;
		String path; // where the json to write is located
		MovieWriter aw = new MovieWriter();   // controller class
		MovieReader ar = new MovieReader();
		ObjectWriter<Movie> writer = new ObjectWriter<Movie>();
		do {
			
			choice = showMenuAndGetChoice(sc);
			if (choice == 1) { //add a movie
				System.out.print("Enter title: ");
				title = sc.nextLine();
				System.out.print("Enter production company: ");
				company = sc.nextLine();
				System.out.print("Enter director: ");
				director = sc.nextLine();
				System.out.print("Enter producer: ");
				producer = sc.nextLine();
				movie = new Movie(title,company,director,producer);
				movies.add(movie);
			} else if (choice == 2) {
				System.out.println();
				printMovies(movies);
			} else if (choice == 3) {
				System.out.print("Enter path to json file: ");
				path = sc.nextLine();
				if (aw.writeToJSON(path,movies)) {
					System.out.println("Saved movies successfully.");
				} else {
					System.out.println("Couldn't save movies.");
				}
			} else if (choice == 4) {
				System.out.print("Enter number of movie to remove: ");
				toRemove = sc.nextInt();
				movies.remove(toRemove);
			} else if (choice == 5) {
				System.out.print("Enter name of file: ");
				path = sc.nextLine();
				movies = ar.readFromJSON(path);
				if (movies == null) {
					System.out.println("Fail!");
				} else {
					System.out.println("Success!");
				}
			} else if (choice == 6) {
				System.out.print("Enter name of file: ");
				path = sc.nextLine();
				writer.writeToText(path,movies);
			}
		} while (choice != 7);
		System.out.println("Thank you for using our application. Bye!");
	}
}
