package movie.library.data.manager;

import java.util.ArrayList;

public class Movie {

	private String movieID;
	private String movieTitle;
	private String movieImdbID;
	private String movieSpanishTitle;
	private String movieImdbPictureURL;
	private String movieYear;
	private String movieRtID;
	private String movieRtAllCriticsRating;
	private String movieRtAllCriticsNumReviews;
	private String movieRtAllCriticsNumFresh;
	private String movieRtAllCriticsNumRotten;
	private String movieRtAllCriticsScore;
	private String movieRtTopCriticsRating;
	private String movieRtTopCriticsNumReviews;
	private String movieRtTopCriticsNumFresh;
	private String movieRtTopCriticsNumRotten;
	private String movieRtTopCriticsScore;
	private String movieRtAudienceRating;
	private String movieRtAudienceNumRatings;
	private String movieRtAudienceScore;
	private String movieRtPictureURL;
	private String genre;
	private String country = "-";
	private String[] allData;

	private ArrayList<Actor> actors;
	private ArrayList<Director> directors;
	private ArrayList<Genre> genres;
	private ArrayList<String> locations;

	public Movie(String[] data) {
		allData = data;
		actors = new ArrayList<Actor>();
		directors = new ArrayList<Director>();
		genres = new ArrayList<Genre>();
		locations = new ArrayList<String>();
		initFields(data);

	}

	public void initFields(String[] data) {
		movieID = data[0];
		movieTitle = data[1];
		movieImdbID = data[2];
		movieSpanishTitle = data[3];
		movieImdbPictureURL = data[4];
		movieYear = data[5];
		movieRtID = data[6];
		movieRtAllCriticsRating = data[7];
		movieRtAllCriticsNumReviews = data[8];
		movieRtAllCriticsNumFresh = data[9];
		movieRtAllCriticsNumRotten = data[10];
		movieRtAllCriticsScore = data[11];
		movieRtTopCriticsRating = data[12];
		movieRtTopCriticsNumReviews = data[13];
		movieRtTopCriticsNumFresh = data[14];
		movieRtTopCriticsNumRotten = data[15];
		movieRtTopCriticsScore = data[16];
		movieRtAudienceRating = data[17];
		movieRtAudienceNumRatings = data[18];
		movieRtAudienceScore = data[19];
		movieRtPictureURL = data[20];
	}

	public ArrayList<String> getMovieShortDesc() {
		ArrayList<String> data = new ArrayList<String>();
		String text = "";
		text += "Dataset's Movie ID: " + allData[0] + "!@!";
		text += "IMBD ID: " + allData[2] + "!@!";
		text += "Spanish Title: " + allData[3] + "!@!";
		text += "IMBD Picture URL: " + allData[4] + "!@!";
		text += "Year: " + allData[5] + "!@!";
		text += "Rotten Tomatoes Info " + "!@!";
		text += "All Critics Rating: " + allData[7] + "!@!";
		text += "All Critics Number Reviews: " + allData[8] + "!@!";
		text += "All Critics Number Fresh: " + allData[9] + "!@!";
		text += "All Critics Number Rotten: " + allData[10] + "!@!";
		text += "All Critics Score: " + allData[11] + "!@!";
		text += "Top Critics Rating: " + allData[12] + "!@!";
		text += "Top Critics Number Reviews: " + allData[13] + "!@!";
		text += "Top Critics Number Fresh: " + allData[14] + "!@!";
		text += "Top Critics Number Rotten: " + allData[15] + "!@!";
		text += "Top Critics Score: " + allData[16] + "!@!";
		text += "Audience Rating: " + allData[17] + "!@!";
		text += "Audience Number Ratings: " + allData[18] + "!@!";
		text += "Audience Score: " + allData[19] + "!@!";
		text += "Picture URL: " + allData[20] + "!@!";
		data.add(text);
		return data;
	}

	public ArrayList<String> getMovieActors() {
		ArrayList<String> data = new ArrayList<String>();
		data.add("The movie has " + actors.size() + " Actors" + "\n");
		String text = "";
		for (Actor actor : actors) {

			text += (actor.getActorName() + "!@!");
		}
		data.add(text);
		return data;
	}

	public ArrayList<String> getMovieDirectors() {
		ArrayList<String> data = new ArrayList<String>();
		data.add("The movie has " + directors.size() + " Directors" + "\n");
		String text = "";
		for (Director director : directors) {
			text += (director.getDirectorName() + "!@!");
		}
		data.add(text);
		return data;
	}

	public String getMovieDirectorsString() {
		String text = "";
		for (Director director : directors) {
			text += (director.getDirectorName());
		}
		return text;
	}

	public ArrayList<String> getMovieGenres() {
		ArrayList<String> data = new ArrayList<String>();
		data.add("The movie belongs in " + genres.size() + " Genres" + "\n");
		String text = "";
		for (Genre genre : genres) {
			text += (genre.getGenre() + "!@!");
		}
		data.add(text);
		return data;
	}

	public ArrayList<String> getMovieLocations() {
		ArrayList<String> data = new ArrayList<String>();
		String text = "";
		text += ("Movie's Country: " + country + "\n");
		text += ("The movie was shot in " + locations.size() + " locations" + "\n");
		data.add(text);
		text = "";
		for (String location : locations) {
			text += (location + "!@!");
		}
		data.add(text);
		return data;
	}

	public ArrayList<String> getAllData() {
		ArrayList<String> allMovieData = new ArrayList<String>();
		allMovieData.add(getMovieTitle());// 1
		allMovieData.addAll(getMovieShortDesc());// 2
		allMovieData.addAll(getMovieGenres());// 3-4
		allMovieData.addAll(getMovieDirectors());// 5-6
		allMovieData.addAll(getMovieActors());// 7-8
		allMovieData.addAll(getMovieLocations());
		return allMovieData;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void printMovieInfo() {
		System.out.println("****Movie: " + movieTitle);
		System.out.println("****Actors: " + actors.size());
		for (Actor actor : actors) {
			System.out.print(actor.getActorName() + ", ");
		}
		System.out.println(" ");
		System.out.println("****Director: " + directors.size());
		for (Director director : directors) {
			System.out.print(director.getDirectorName() + ", ");
		}
		System.out.println(" ");
		System.out.println("****Genres: " + genres.size());
		for (Genre genre : genres) {
			System.out.print(genre.getGenre() + ", ");
		}
		System.out.println(" ");
		System.out.println("****Locations: " + locations.size());
		for (String location : locations) {
			System.out.print(location + ", ");
		}
		System.out.println(" ");
	}

	public String getGenre() {
		return genre;
	}

	public void addActor(Actor aActor) {
		actors.add(aActor);
	}

	public void addDirector(Director aDirector) {
		directors.add(aDirector);
	}

	public void addGenre(Genre aGenre) {
		genres.add(aGenre);
	}

	public void setCountry(String aCountry) {
		country = aCountry;

	}

	public void addLocation(String aLocation) {
		locations.add(aLocation);

	}

	public String getMovieYear() {
		return movieYear;
	}

}
