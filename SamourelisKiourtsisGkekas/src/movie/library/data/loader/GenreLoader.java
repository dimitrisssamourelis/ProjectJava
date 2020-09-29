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

public class GenreLoader implements Loader {
	private FileReader fileReader;
	private BufferedReader in;
	private String moviesDataFile = "movie_genres.dat";
	private HashMap<String, Movie> movies;
	private HashMap<String, Genre> genres = new HashMap<String, Genre>();
	private int genresCounter;

	public GenreLoader(HashMap<String, Movie> movieshm) {
		movies = movieshm;
		genresCounter = 0;
		try {
			fileReader = new FileReader(moviesDataFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("To arxeio movie_genres.dat den mporese na fortwthei.");
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
				genresCounter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Den mporw na diavasw to arxeio.");
			return -1;
		}
		return genresCounter;

	}

	public void makeObject(String[] genreInfo) {
		Movie tmpMovie = movies.get(genreInfo[0]);
		if (genres.containsKey(genreInfo[1])) { // an uparxei auto to genre
			genres.get(genreInfo[1]).addMovie(tmpMovie); //kanw add tin tainia sto genre
			movies.get(genreInfo[0]).addGenre(genres.get(genreInfo[1])); //kanw add to genre sto movie
		} else {
			genres.put(genreInfo[1], new Genre(genreInfo)); //Comedy,antikeimeno comedy
			genres.get(genreInfo[1]).addMovie(tmpMovie);
			movies.get(genreInfo[0]).addGenre(genres.get(genreInfo[1]));
		}

	}

	/**
	 * @return the directors
	 */
	public HashMap<String, Genre> getGenres() {
		return genres;
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
	public HashMap<String, Movie> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}

}
