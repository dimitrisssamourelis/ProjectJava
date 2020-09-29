package movie.library.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import movie.library.data.manager.DataHandler;

public class QuestionsHandler {

	private DataHandler dataHandler;
	private Scanner reader = new Scanner(System.in); // Reading from System.in;
	private int menuAnswer;

	public QuestionsHandler(DataHandler aDataHandler) {
		dataHandler = aDataHandler;

	}

	public void start() {
		while (true) {
			clearConsole();
			printMenu();
			answerSelect(readMenu());
		}
	}

	public void printMenu() {
		System.out.println(" ** Menu ** ");
		System.out.println("Press 1 to search for a short description of a movie");
		System.out.println("Press 2 to search for all movies by a Genre");
		System.out.println("Press 3 to search for all movies by a Country");
		System.out.println("Press 4 to search for all movies by an Actor");
		System.out.println("Press 5 to search for all movies by a Director");
		System.out.println("Press 10 to exit.");
	}

	public int readMenu() {
		System.out.println("Enter a number: ");
		menuAnswer = reader.nextInt(); // Scans the next token of the input as an int.
		return menuAnswer;
	}

	public void answerSelect(int answer) {

		switch (answer) {
		case 1:
			String movie = "";
			int option = printIdOrTitleOption();
			if (option == 22) {
				movie = getMovieTitle();
			} else if (option == 11) {
				movie = getMovieID();
			}
			String movieId = dataHandler.findMovieId(option, movie);
			dataHandler.createMovieDescription(movieId);
			break;
		case 2:
			String movieGenre = getGenreFromUser();
			dataHandler.createListbyGenre(movieGenre);
			break;
		case 3:
			String movieCountry = getCountryFromUser();
			dataHandler.createListbyCountry(movieCountry);
			break;
		case 4:
			String movieActor = getActorFromUser();
			dataHandler.createListbyActor(movieActor);
			break;
		case 5:
			String movieDirector = getDirectorFromUser();
			dataHandler.createListbyDirector(movieDirector);
			break;
		case 10:
			System.out.println("I am exiting.. bye bye!");
			System.exit(0);
			break;

		default:
			System.out.println("Invalid menu option");
			break;
		}

	}

	public int printIdOrTitleOption() {
		System.out.println(" ** Do you you want to search by ID or by Title? ** ");
		System.out.println("Press 11 to search by ID..");
		System.out.println("Press 22 to search by Title");
		System.out.println("Enter a number [11 for ID - 22 for Title]: ");
		menuAnswer = reader.nextInt(); // Scans the next token of the input as an int.
		return menuAnswer;
	}

	public final static void clearConsole() {
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			// Handle any exceptions.
		}
	}

	private String getActorFromUser() {
		String menuAnswer = "";
		reader.useDelimiter("[\\r\\n]+");
		System.out.println(" ** Please type the Actor you want ** ");
		menuAnswer = reader.next();

		return menuAnswer;
	}

	private String getDirectorFromUser() {
		String menuAnswer = "";
		reader.useDelimiter("[\\r\\n]+");
		System.out.println(" ** Please type the Director you want ** ");
		menuAnswer = reader.next();

		return menuAnswer;
	}

	private String getCountryFromUser() {
		String menuAnswer = "";
		System.out.println(" ** Please type the Country you want ** ");
		menuAnswer = reader.next();

		return menuAnswer;
	}

	private String getGenreFromUser() {
		String menuAnswer = "";
		System.out.println(" ** Please type the Genre you want ** ");
		menuAnswer = reader.next(); // Scans the next token of the input as an int.
		System.out.println("Please type the Movie title: " + menuAnswer);

		return menuAnswer;
	}

	public String getMovieTitle() {
		String movieName;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please type the Movie title: ");

		try {
			movieName = in.readLine();
			return movieName;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}

		
	}

	public String getMovieID() {
		String movieID;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please type the Movie ID: ");
		try {
			movieID = in.readLine();
			return movieID;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

}
