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

public class ActorsLoader implements Loader {
	private FileReader fileReader;
	private int actorsCounter;
	private BufferedReader in;
	private String moviesDataFile = "movie_actors.dat";
	private HashMap<String, Movie> movies;
	private HashMap<String, Actor> actorshm = new HashMap<String, Actor>();

	/**
	 * @return the actorshm
	 */
	public HashMap<String, Actor> getActors() {
		return actorshm;
	}

	int sum = 1;

	public ActorsLoader(HashMap<String, Movie> movieshm) {
		movies = movieshm;
		actorsCounter = 0;
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
				actorsCounter++;
				makeObject(line.split("\t"));
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Den mporw na diavasw to arxeio.");
		}
		return actorsCounter;

	}

	public void makeObject(String[] actorInfo) {
		Movie tmpMovie = movies.get(actorInfo[0]);
		if (actorshm.containsKey(actorInfo[1])) {
			actorshm.get(actorInfo[1]).addMovie(tmpMovie);
			movies.get(actorInfo[0]).addActor(actorshm.get(actorInfo[1]));
		} else {
			actorshm.put(actorInfo[1], new Actor(actorInfo));
			actorshm.get(actorInfo[1]).addMovie(tmpMovie);
			movies.get(actorInfo[0]).addActor(actorshm.get(actorInfo[1]));
		}

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
