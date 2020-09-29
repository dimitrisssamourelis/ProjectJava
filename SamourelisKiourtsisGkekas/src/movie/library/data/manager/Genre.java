package movie.library.data.manager;

import java.util.ArrayList;

public class Genre {

	private String genre;
	private ArrayList<Movie> movies;

	public Genre(String[] data) {
		movies = new ArrayList<Movie>();
		initFields(data);
	}

	public void initFields(String[] data) {
		genre = data[1];

	}

	public void addMovie(Movie aMovie) {
		movies.add(aMovie);
	}

	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}

	public ArrayList<String> getAllData() {
		ArrayList<String> data = new ArrayList<String>();
		String text = "";
		data.add(genre); // 0
		data.add(genre + " Genre has " + movies.size() + " movies.!@!"); // 1
		data.add("Movies List");//2
		text = "";
		for (Movie movie : movies) {
			text += (movie.getMovieTitle() + " - " + movie.getMovieYear() + " - " + movie.getMovieDirectorsString()
					+ "!@!");
		}
		data.add(text);// 3
		return data;
	}

}
