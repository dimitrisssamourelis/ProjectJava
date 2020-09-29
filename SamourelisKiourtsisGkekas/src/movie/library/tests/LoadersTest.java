package movie.library.tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

import movie.library.data.loader.ActorsLoader;
import movie.library.data.loader.CountryLoader;
import movie.library.data.loader.DirectorLoader;
import movie.library.data.loader.GenreLoader;
import movie.library.data.loader.MoviesLoader;

public class LoadersTest {
	private MoviesLoader loader;
	private ActorsLoader actorsLoader;
	private DirectorLoader drectorsLoader;
	private GenreLoader genresLoader;
	private CountryLoader countryLoader;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		// this runs once, before _all_ tests. Nothing todo here.
		// See CDTest for explanations
	}

	@Before
	public void setUp() throws Exception {
		loader = new MoviesLoader();
		loader.parseFile();
		actorsLoader = new ActorsLoader(loader.getMovies());
		drectorsLoader = new DirectorLoader(loader.getMovies());
		genresLoader = new GenreLoader(loader.getMovies());
		countryLoader = new CountryLoader(loader.getMovies());
		// this runs before _each_ test. create a book to test constructor, price and
		// final price
	}

	@Test
	public final void testLoadersNull() {
		// remember: the setUp() method has run already: Loader should have been
		// initialized!
		assertNotNull("After setup, the loader is not null", loader);
		assertNotNull("After setup, the loader is not null", actorsLoader);
		assertNotNull("After setup, the loader is not null", drectorsLoader);
		assertNotNull("After setup, the loader is not null", genresLoader);
		assertNotNull("After setup, the loader is not null", countryLoader);


		// at the beginning to see that the test works.
		// fail("Not yet implemented");
	}

	@Test
	public final void testGettersHashMap() {
		assertNotNull("test if getMovies() works OK", loader.getMovies());
        assertThat(loader.getMovies().size(), not(is(0)));
        assertThat(actorsLoader.getActors().size(), not(is(0)));
        assertThat(countryLoader.getCountries().size(), not(is(0)));
        assertThat(drectorsLoader.getDirectors().size(), not(is(0)));
        assertThat(genresLoader.getGenres().size(), not(is(0)));
		// fail("Not yet implemented");
	}

}
