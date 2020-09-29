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
import movie.library.data.manager.Movie;

public class DirectorLoader implements Loader {

	private FileReader fileReader;
	private BufferedReader in;
	private String moviesDataFile = "movie_directors.dat";
	private HashMap<String, Movie> movies;
	private HashMap<String, Director> directors = new HashMap<String, Director>();
	private int directorsCounter;

	public DirectorLoader(HashMap<String, Movie> movieshm) {
		movies = movieshm;
		directorsCounter = 0;
		try {
			fileReader = new FileReader(moviesDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("To arxeio movie_directors.dat den mporese na fortwthei.");
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
				directorsCounter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Den mporw na diavasw to arxeio movie_directors.");
			return -1;
		}
		return directorsCounter;

	}

	public void makeObject(String[] directorInfo) {
		Movie tmpMovie = movies.get(directorInfo[0]);
		if (directors.containsKey(directorInfo[1])) {
			directors.get(directorInfo[1]).addMovie(tmpMovie);
			movies.get(directorInfo[0]).addDirector(directors.get(directorInfo[1]));
		} else {
			directors.put(directorInfo[1], new Director(directorInfo));
			directors.get(directorInfo[1]).addMovie(tmpMovie);
			movies.get(directorInfo[0]).addDirector(directors.get(directorInfo[1]));
		}

	}

	/**
	 * @return the directors
	 */
	public HashMap<String, Director> getDirectors() {
		return directors;
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
	public HashMap<String, Movie> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Genre> getGenres() {
		// TODO Auto-generated method stub
		return null;
	}
}
