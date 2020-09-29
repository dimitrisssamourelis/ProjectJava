package movie.library.data.manager;

import java.util.ArrayList;

public class Actor {
	private String actorID;
	private ArrayList<Movie> actorMovies;
	private String actorName;

	public Actor(String[] data) {
		actorMovies = new ArrayList<Movie>();
		initFields(data);
	}

	public void addMovie(Movie aMovie) {
		actorMovies.add(aMovie);
	}

	public void initFields(String[] data) {
		actorName = data[2];
		actorID = data[1];

	}

	public void printMovies() {
		System.out.println("****Actor: " + actorName);
		System.out.println("****Movies: " + actorMovies.size());
		for (Movie movie : actorMovies) {
			System.out.println(movie.getMovieTitle());
		}
	}

	/**
	 * @return the actorName
	 */
	public String getActorName() {
		return actorName;
	}

	public ArrayList<String> getAllData() {
		ArrayList<String> data = new ArrayList<String>();
		String text = "";
		data.add(actorName + "'s Movies List"); // 0
		data.add(actorName + " has " + actorMovies.size() + " movies.!@!"); // 1
		data.add("Movies List"); // 2
		text = "";
		for (Movie movie : actorMovies) {
			text += (movie.getMovieTitle() + " - " + movie.getMovieYear() + " - " + movie.getMovieDirectorsString()
					+ "!@!");
		}
		data.add(text);// 3
		return data;
	}

}
