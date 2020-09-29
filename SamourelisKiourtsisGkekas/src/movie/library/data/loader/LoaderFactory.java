package movie.library.data.loader;

import java.util.HashMap;

import movie.library.data.manager.Movie;

public class LoaderFactory {

	public Loader getLoader(String loaderType) {
		if (loaderType == null) {
			return null;
		}
		if (loaderType.equalsIgnoreCase("MOVIES")) {
			return new MoviesLoader();
		}

		return null;
	}

	public Loader getLoader(String loaderType, HashMap<String, Movie> movieshm) {
		if (loaderType.equalsIgnoreCase("ACTORS")) {
			return new ActorsLoader(movieshm);
		} else if (loaderType.equalsIgnoreCase("DIRECTORS")) {
			return new DirectorLoader(movieshm);
		} else if (loaderType.equalsIgnoreCase("GENRES")) {
			return new GenreLoader(movieshm);
		} else if (loaderType.equalsIgnoreCase("COUNTRY")) {
			return new CountryLoader(movieshm);
		}
		return null;
	}
}