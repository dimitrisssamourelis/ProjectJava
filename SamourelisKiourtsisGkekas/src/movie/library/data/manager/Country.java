package movie.library.data.manager;

import java.util.ArrayList;

public class Country {

	private String country;
	private ArrayList<Movie> movies;

	public Country(String[] data) {
		movies = new ArrayList<Movie>();
		initFields(data);
	}

	public void initFields(String[] data) {
		country = data[1];
	}

	public void addMovie(Movie aMovie) {
		movies.add(aMovie);
	}

	public ArrayList<String> getAllData() {
		ArrayList<String> data = new ArrayList<String>();
		String text = "";
		data.add(country + "'s Movies List"); // 0
		data.add(country + " has " + movies.size() + " movies.!@!"); // 1
		data.add("Movies List"); // 2
		text = "";
		for (Movie movie : movies) {
			text += (movie.getMovieTitle() + " - " + movie.getMovieYear() + " - " + movie.getMovieDirectorsString()
					+ "!@!");
		}
		data.add(text);// 3
		return data;
	}

	public void printMovies() {
		String text = "";
		for (Movie movie : movies) {
			text += (movie.getMovieTitle() + " - " + movie.getMovieYear() + " - " + movie.getMovieDirectorsString()
					+ "\n");
		}
		System.out.println(text);
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
}
