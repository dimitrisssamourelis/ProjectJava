package movie.library.data.loader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import movie.library.data.manager.Actor;
import movie.library.data.manager.Country;
import movie.library.data.manager.Director;
import movie.library.data.manager.Genre;
import movie.library.data.manager.Movie;

public class CountryLoader implements Loader {
	private FileReader fileReader;
	private BufferedReader in;
	private String fileName = "movie_countries.dat";
	private HashMap<String, Movie> movies;
	private HashMap<String, Country> countries = new HashMap<String, Country>();
	private int countriesCounter;
	private int locationsCounter;

	public CountryLoader(HashMap<String, Movie> movieshm) {
		movies = movieshm;
		countriesCounter = 0;
		try {
			fileReader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("To arxeio movie_genres.dat den mporese na fortwthei.");
		}
		in = new BufferedReader(fileReader);
		parseFile();
		loadLocations();
	}

	private void loadLocations() {
		fileName = "movie_locations.dat";
		try {
			fileReader = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			System.out.println("To arxeio movie_locations.dat den mporese na fortwthei.");
		}
		in = new BufferedReader(fileReader);
		parseLocationsFile();
	}

	public int parseFile() {
		String line;
		try {
			in.readLine(); // Kanw skip tin proti grammi
			while ((line = in.readLine()) != null) {
				makeObject(line.split("\t"));
				countriesCounter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Den mporw na diavasw to arxeio.");
			return -1;
		}
		return countriesCounter;
	}

	public void makeObject(String[] countryInfo) {
		Movie tmpMovie = movies.get(countryInfo[0]);
		if (countryInfo.length == 2) { // gia tis provlimatikes eggrafes
			if (countries.containsKey(countryInfo[1])) { // an uparxei auth h country
				countries.get(countryInfo[1]).addMovie(tmpMovie);
				movies.get(countryInfo[0]).setCountry(countryInfo[1]);
			} else {
				countries.put(countryInfo[1], new Country(countryInfo));
				countries.get(countryInfo[1]).addMovie(tmpMovie);
				movies.get(countryInfo[0]).setCountry(countryInfo[1]);
			}
		}
	}

	public int parseLocationsFile() {
		String line;
		try {
			in.readLine(); // Kanw skip tin proti grammi
			while ((line = in.readLine()) != null) {
				setLocations(line.split("\t"));
				locationsCounter++;
			}
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Den mporw na diavasw to arxeio.");
			return -1;
		}
		return locationsCounter;

	}

	public void setLocations(String[] locationInfo) {
		if (locationInfo.length > 1) { // gia tis provlimatikes eggrafes
			String locations = "";
			for (int i = 1; i < locationInfo.length; i++) {
				locations += locationInfo[i] + " ";
			}
			movies.get(locationInfo[0]).addLocation(locations);
		} else {
			movies.get(locationInfo[0]).addLocation("( Sorry we don't have info for shotted locations)");
		}
	}

	/**
	 * @return the countries
	 */
	public HashMap<String, Country> getCountries() {
		return countries;
	}

	@Override
	public HashMap<String, Actor> getActors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Director> getDirectors() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Movie> getMovies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<String, Genre> getGenres() {
		// TODO Auto-generated method stub
		return null;
	}
}
