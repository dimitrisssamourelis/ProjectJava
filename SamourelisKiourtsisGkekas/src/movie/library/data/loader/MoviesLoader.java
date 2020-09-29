package movie.library.data.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import movie.library.data.manager.Actor;
import movie.library.data.manager.Country;
import movie.library.data.manager.Director;
import movie.library.data.manager.Genre;
import movie.library.data.manager.Movie;;

public class MoviesLoader implements Loader {

	private FileReader fileReader;
	private BufferedReader in;
	private String moviesDataFile = "movies.dat";
	private HashMap<String, Movie> movieshm = new HashMap<String, Movie>();
	int sum = 0;

	public MoviesLoader() {
		try {
			fileReader = new FileReader(moviesDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("To arxeio movies.dat den mporese na fortwthei.");
		}
		in = new BufferedReader(fileReader);
		parseFile();
	}

	public int parseFile() {
		String line;
		try {
			in.readLine(); // Kanw skip tin proti grammi
			while ((line = in.readLine()) != null) {
				makeObject(line.split("\t"));
				sum++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Den mporw na diavasw to arxeio.");
		}
		return sum;
	}

	public void makeObject(String[] movieArrayDetails) {
		movieshm.put(movieArrayDetails[0], new Movie(movieArrayDetails));
	}

	/**
	 * @return the movies
	 */
	public HashMap<String, Movie> getMovies() {
		return movieshm;
	}

	@Override
	public HashMap<String, Actor> getActors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Country> getCountries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Director> getDirectors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Genre> getGenres() {
		// TODO Auto-generated method stub
		return null;
	}

}
