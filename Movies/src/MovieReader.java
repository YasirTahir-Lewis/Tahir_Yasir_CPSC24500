import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class MovieReader {
	
	public ArrayList<Movie> readFromJSON(String fname) {
		try {
			ArrayList<Movie> movies = new ArrayList<Movie>();
			FileReader reader = new FileReader(new File(fname));
			JSONParser parser = new JSONParser();
			JSONObject all = (JSONObject)parser.parse(reader);
			JSONArray movv = (JSONArray)all.get("movies");
			Iterator itr = movv.iterator();  // help me step through every entry
			JSONObject articleObject;
			String title, company, director, producer;
			while (itr.hasNext()) {
				articleObject = (JSONObject)itr.next();
				title = articleObject.get("title").toString();
				company = articleObject.get("company").toString();
				director = articleObject.get("director").toString();
				producer = articleObject.get("producer").toString();
				movies.add(new Movie(title,company,director,producer));
			}
			reader.close();
			return movies;
		} catch (Exception ex) {
			return null;
		}
		
	}
	public ArrayList<Movie> readFromText(String fname) {
		File f = new File(fname);
		return readFromText(f);
	}
	public ArrayList<Movie> readFromText(File f) {
		try {
			ArrayList<Movie> moviesRead = new ArrayList<Movie>();
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			String x, y, r, z;
			Movie movie;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine();
				parts = line.split(" ");
				x = parts[0];
				y = parts[1];
				r = parts[2];
				z = parts[3];
				movie = new Movie(x,y,r,z);
				moviesRead.add(movie);
			}
			fsc.close();
			return moviesRead;
		} catch (Exception ex) {
			return null;  // null means I wasn't able to build 
						  // the required array list of movies
		}
	}
	public ArrayList<Movie> readFromBinary(String fname) {
		File f = new File(fname);
		return readFromBinary(f);
	}
	public ArrayList<Movie> readFromBinary(File f) {
		try {
			ArrayList<Movie> moviesRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			moviesRead = (ArrayList<Movie>)ois.readObject();
			ois.close();
			return moviesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<Movie> readFromXML(String fname) {
		File f = new File(fname);
		return readFromXML(f);
	}
	public ArrayList<Movie> readFromXML(File f) {
		try {
			ArrayList<Movie> moviesRead;
			XMLDecoder dec = new XMLDecoder(
					new BufferedInputStream(new FileInputStream(f)));
			moviesRead = (ArrayList<Movie>)dec.readObject();
			dec.close();
			return moviesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	public ArrayList<Movie> read(String fname) {
		File f = new File(fname);
		return read(f);
	}
	public ArrayList<Movie> read(File f) {
		try {
			String fname = f.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return readFromText(f);
			} else if (fname.endsWith(".BIN")) {
				return readFromBinary(f);
			} else if (fname.endsWith(".XML")) {
				return readFromXML(f);
			} else {
				return null;  // unrecognized extension
			}
		} catch (Exception ex) {
			return null;
		}
	}
}