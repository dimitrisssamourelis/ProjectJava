package movie.library.data.export;

import java.util.ArrayList;
import java.util.Scanner;

public class ExportersManager {
	ExporterFactory exporterFactory = new ExporterFactory();
	private Scanner reader = new Scanner(System.in); // Reading from System.in;
	private String fileName;

	public void export(ArrayList<String> allData) {
		answerSaveSelect(printSaveMenu(), allData);
	}

	public int printSaveMenu() {
		System.out.println(" ** Save Options ** ");
		System.out.println("Press 1 to save results in a simple txt file.");
		System.out.println("Press 2 to save in html file");
		System.out.println("Press 3 to save in a Markdown format.");
		System.out.println("Press 4 to save in pdf");
		System.out.println("Press 5 to convert txt file from option 1 in pdf file.");
		System.out.println("Enter a number between 1 - 5: ");
		int menuAnswer = reader.nextInt(); // Scans the next token of the input as an int.
		while (menuAnswer < 1 || menuAnswer > 5) {
			System.out.println("Invalid Input. Let's do it again!");
			System.out.println("Enter a number between 1 - 5: ");
			menuAnswer = reader.nextInt(); // Scans the next token of the input as an int.
		}
		return menuAnswer;

	}

	public void answerSaveSelect(int answer, ArrayList<String> data) {
		getFileName(data);
		switch (answer) {
		case 1:
			exporterFactory.getExporter("TEXT").write(data, fileName);
			break;
		case 2:
			exporterFactory.getExporter("HTML").write(data, fileName);
			break;
		case 3:
			exporterFactory.getExporter("MARKDOWN").write(data, fileName);
			break;
		case 4:
			exporterFactory.getExporter("PDF").write(data, fileName);
			break;
		case 5:
			exporterFactory.getConverter("TXTTOPDF").write(fileName);
			break;

		default:
			System.out.println("Invalid menu option");
			break;
		}

	}

	public void getFileName(ArrayList<String> data) {
		System.out.println("Enter a file name or press enter for default name.");
		Scanner reader2 = new Scanner(System.in);
		String name = reader2.nextLine();
		if (name.equals("")) {
			fileName = data.get(0);
		} else {
			fileName = name;
		}
	}

}
