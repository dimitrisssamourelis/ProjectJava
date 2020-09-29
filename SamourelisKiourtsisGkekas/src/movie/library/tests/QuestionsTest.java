package movie.library.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import movie.library.data.loader.ActorsLoader;
import movie.library.data.loader.CountryLoader;
import movie.library.data.loader.DirectorLoader;
import movie.library.data.loader.GenreLoader;
import movie.library.data.loader.MoviesLoader;
import movie.library.data.manager.DataHandler;
import movie.library.data.manager.Movie;
import movie.library.view.QuestionsHandler;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;

public class QuestionsTest {
	private MoviesLoader loader;
	private DataHandler qs;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// this runs once, before _all_ tests. Nothing todo here.
		// See CDTest for explanations
	}

	@Before
	public void setUp() throws Exception {
		loader = new MoviesLoader();
		loader.parseFile();
		ActorsLoader actorsLoader = new ActorsLoader(loader.getMovies());
		DirectorLoader drectorsLoader = new DirectorLoader(loader.getMovies());
		GenreLoader genresLoader = new GenreLoader(loader.getMovies());
		CountryLoader countryLoader = new CountryLoader(loader.getMovies());

		qs = new DataHandler();
		qs.setActors(actorsLoader.getActors());
		qs.setCountries(countryLoader.getCountries());
		qs.setDirectors(drectorsLoader.getDirectors());
		qs.setGenres(genresLoader.getGenres());
		qs.setMovies(loader.getMovies());
	}

	@Test
	public final void testFindMovieByID() {
		// Give in the terminal: Toy Story
		assertTrue(qs.findMovieId(22,"3114").matches("3114"));
	}

	@Test
	public final void testGetMovieObject() {
		//assertThat(qs.getMovie("3114"), instanceOf(Movie.class));

	}

}
