package movie.library.data.manager;

import java.util.ArrayList;

public class Director {
	private String directorID;
	private ArrayList<Movie> directorMovies;
	private String directorName;

	public Director(String[] data) {
		directorMovies = new ArrayList<Movie>();
		initFields(data);
	}

	public void addMovie(Movie aMovie) {
		directorMovies.add(aMovie);
	}

	public void initFields(String[] data) {
		directorName = data[2];
		directorID = data[1];

	}

	/**
	 * @return the directorName
	 */
	public String getDirectorName() {
		return directorName;
	}

	public ArrayList<String> getAllData() {
		ArrayList<String> data = new ArrayList<String>();
		String text = "";
		data.add(directorName + "'s Movies List"); // 0
		data.add(directorName + " has " + directorMovies.size() + " movies.!@!"); // 1
		data.add("Movies List"); // 2
		text = "";
		for (Movie movie : directorMovies) {
			text += (movie.getMovieTitle() + " - " + movie.getMovieYear() + " - " + movie.getMovieDirectorsString()
					+ "!@!");
		}
		data.add(text);// 3
		return data;
	}
}
