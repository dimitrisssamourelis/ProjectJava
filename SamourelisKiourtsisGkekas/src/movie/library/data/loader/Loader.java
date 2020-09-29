package movie.library.data.loader;

import java.util.HashMap;

import movie.library.data.manager.Actor;
import movie.library.data.manager.Country;
import movie.library.data.manager.Director;
import movie.library.data.manager.Genre;
import movie.library.data.manager.Movie;


public interface Loader {

	int parseFile();
	void makeObject(String[] data);
	HashMap<String, Actor> getActors();
	HashMap<String, Country> getCountries();
	HashMap<String, Director> getDirectors();
	HashMap<String, Movie> getMovies();
	HashMap<String, Genre> getGenres();
	
	
}
