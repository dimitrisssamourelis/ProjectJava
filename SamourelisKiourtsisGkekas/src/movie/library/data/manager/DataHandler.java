package movie.library.data.manager;

import java.util.HashMap;

import movie.library.data.export.ExportersManager;

public class DataHandler {
	private ExportersManager exportersManager = new ExportersManager();
	private HashMap<String, Movie> movies;
	private HashMap<String, Genre> genres;
	private HashMap<String, Actor> actors;
	private HashMap<String, Director> directors;
	private HashMap<String, Country> countries;

	public String findMovieId(int option, String movie) {
		String movieName;
		String movieID;
		if (option == 22) {
			movieName = movie;
			for (String key : movies.keySet()) {
				if (movies.get(key).getMovieTitle().equalsIgnoreCase(movieName)) {
					movieID = key;
					return movieID;
				}
			}
		} else {
			movieID = movie;
			if (movies.containsKey(movieID)) {
				return movieID;
			}
		}

		return null;
	}

	public void createMovieDescription(String movieId) {
		try {
			Movie movieObject = movies.get(movieId);

			exportersManager.export(movieObject.getAllData());

		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("I couldn't find that movie...");
		}

	}

	public void createListbyGenre(String genre) {

		try {
			exportersManager.export(genres.get(genre).getAllData());
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("I couldn't find that genre...");
		}

	}

	public void createListbyCountry(String country) {

		try {
			exportersManager.export(countries.get(country).getAllData());
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("I couldn't find that country...: " + country);
		}

	}

	public void createListbyActor(String movieActor) {
		String actorKey = "";

		try {
			for (String key : actors.keySet()) {
				if (actors.get(key).getActorName().equals(movieActor)) {
					actorKey = key;
					//System.out.println(key);
				}
			}
			exportersManager.export(actors.get(actorKey).getAllData());
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("I couldn't find that Actor...: " + movieActor);
		}

	}

	public void createListbyDirector(String movieDirector) {
		String directorKey = "";

		try {
			for (String key : directors.keySet()) {
				if (directors.get(key).getDirectorName().equals(movieDirector)) {
					directorKey = key;
					//System.out.println(key);
				}
			}
			exportersManager.export(directors.get(directorKey).getAllData());
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println("I couldn't find that Director...: " + movieDirector);
		}

	}

	/**
	 * @param movies
	 *            the movies to set
	 */
	public void setMovies(HashMap<String, Movie> movies) {
		this.movies = movies;
	}

	/**
	 * @param genres
	 *            the genres to set
	 */
	public void setGenres(HashMap<String, Genre> genres) {
		this.genres = genres;
	}

	/**
	 * @param hashMap
	 *            the actors to set
	 */
	public void setActors(HashMap<String, Actor> hashMap) {
		this.actors = hashMap;
	}

	/**
	 * @param directors
	 *            the directors to set
	 */
	public void setDirectors(HashMap<String, Director> directors) {
		this.directors = directors;
	}

	/**
	 * @param countries
	 *            the countries to set
	 */
	public void setCountries(HashMap<String, Country> countries) {
		this.countries = countries;
	}

}
