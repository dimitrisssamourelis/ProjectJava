
import movie.library.data.loader.*;
import movie.library.data.manager.DataHandler;
import movie.library.view.QuestionsHandler;

public class Main {

	public static void main(String[] args) {
		LoaderFactory loaderFactory = new LoaderFactory();
		Loader moviesLoader = loaderFactory.getLoader("MOVIES");
		Loader actorsLoader = loaderFactory.getLoader("ACTORS", moviesLoader.getMovies());
		Loader directorsLoader = loaderFactory.getLoader("DIRECTORS", moviesLoader.getMovies());
		Loader genresLoader = loaderFactory.getLoader("GENRES", moviesLoader.getMovies());
		Loader countryLoader = loaderFactory.getLoader("COUNTRY", moviesLoader.getMovies());

		DataHandler dataHandler = new DataHandler();
		dataHandler.setActors(actorsLoader.getActors());
		dataHandler.setCountries(countryLoader.getCountries());
		dataHandler.setDirectors(directorsLoader.getDirectors());
		dataHandler.setGenres(genresLoader.getGenres());
		dataHandler.setMovies(moviesLoader.getMovies());

		QuestionsHandler questionsHandler = new QuestionsHandler(dataHandler);
		questionsHandler.start();

	}

}
