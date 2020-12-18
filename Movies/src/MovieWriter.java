import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 * DotWriter writes dots in a variety of file formats.
 * Eventually, it will write text, binary, xml, and json.
 * @author yasir
 *
 */
public class MovieWriter {
	/**
	 * Write dots to a text file
	 * @param fname the name of the text file
	 * @param dots list of dots to write
	 * @return true if successfully written; false otherwise
	 */
	
	@SuppressWarnings("unchecked")
	public boolean writeToJSON(String fname, ArrayList<Movie> movies) {
		try {
			File f = new File(fname);
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			JSONObject jobj;
			JSONArray movv = new JSONArray();
			for (Movie mov : movies) {
				jobj = new JSONObject();
				jobj.put("title",mov.getTitle());
				jobj.put("company",mov.getCompany());
				jobj.put("director",mov.getDirector());
				jobj.put("producer",mov.getProducer());
				movv.add(jobj);
			}
			JSONObject all = new JSONObject();
			all.put("movies",movv);
			pw.println(all.toJSONString());
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean writeToText(String fname, ArrayList<Movie> movies) {
		File f = new File(fname);
		return writeToText(f,movies);  
	}
	/**
	 * writes dots to a file
	 * @param f the File object to write to
	 * @param dots the list of dots
	 * @return true if successfully written, false otherwise
	 */
	public boolean writeToText(File f, ArrayList<Movie> movies) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (Movie movie : movies) {
				pw.println(movie);
			}
			pw.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean writeToBinary(String fname, ArrayList<Movie> movies) {
		File f = new File(fname);
		return writeToBinary(f,movies);
	}
	
	public boolean writeToBinary(File f, ArrayList<Movie> movies) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(movies);
			oos.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	
	public boolean write(String fname, ArrayList<Movie> movies) {
		File f = new File(fname);
		return write(f,movies);
	}
	public boolean writeToXML(String fname, ArrayList<Movie> movies) {
		File f = new File(fname);
		return writeToXML(f,movies);
	}
	public boolean writeToXML(File f, ArrayList<Movie> movies) {
		try {
			XMLEncoder enc = new XMLEncoder(new 
					BufferedOutputStream(new FileOutputStream(f)));
			enc.writeObject(movies);
			enc.close();
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	/**
	 * It chooses which function to call
	 * based on the file extension.
	 * .txt - writeToText
	 * .bin - writeToBinary
	 * .xml - writeToXML
	 * @param f This is the file object
	 * @param dots The dots to write
	 * @return true if successful, false otherwise (including if unrecognized extension)
	 */
	public boolean write(File f, ArrayList<Movie> movies) {
		try {
			String fname = f.getName().toUpperCase();
			if (fname.endsWith(".TXT")) {
				return writeToText(f,movies);
			} else if (fname.endsWith(".BIN")) {
				return writeToBinary(f,movies);
			} else if (fname.endsWith(".XML")) {
				return writeToXML(f,movies);
			} else {
				return false;  // unrecognized file format
			}
		} catch (Exception ex) {
			return false;
		}
	}
}