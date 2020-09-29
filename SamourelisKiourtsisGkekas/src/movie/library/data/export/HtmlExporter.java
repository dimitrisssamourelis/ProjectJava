package movie.library.data.export;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class HtmlExporter implements Exporter {
	private ArrayList<String> dataToWrite;
	BufferedWriter writer = null;
	File logFile;

	@Override
	public void write(ArrayList<String> data, String fileName) {
		dataToWrite = data;
		try {
			logFile = new File(fileName + ".html");
			writer = new BufferedWriter(new FileWriter(logFile));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}

		writeStart();
		parseDataArray();
		writeEnd();

	}

	public void parseDataArray() {
		try {
			writer.write("<center><b>" + dataToWrite.get(0) + "</b></center><br>\n");
			for (int i = 0; i < dataToWrite.size(); i += 2) {
				if (dataToWrite.get(i).equals(dataToWrite.get(0))) { // skip first element
					// do nothing
				} else {
					writer.write("<b>" + dataToWrite.get(i) + "</b><br>");
				}
				String[] tmp = dataToWrite.get(i + 1).split("!@!");
				for (int j = 0; j < tmp.length; j++) {
					writer.write(tmp[j] + "<br>\n");
				}
				writer.write("<br><br>\n");
			}
		} catch (IOException e) {
			System.out.println("I couldn't create the file.");
			e.printStackTrace();
		}
	}

	public void writeStart() {
		try {
			writer.write("<!DOCTYPE html> \n");
			writer.write("<html> \n");
			writer.write("<head> \n");
			writer.write("\t<title>" + dataToWrite.get(0) + "</title> \n");
			writer.write("</head> \n");
			writer.write("	<body> \n");

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void writeEnd() {
		try {
			writer.write("</body>\n");
			writer.write("</html>");
			writer.close();
			System.out.println("OK!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
