package movie.library.data.export;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class MarkDownExporter implements Exporter {

	private Path path;
	private ArrayList<String> data;

	public void write(ArrayList<String> data, String name) {
		this.data = data;
		path = Paths.get(name + ".md");
		parseDataArray();
	}

	public void parseDataArray() {
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write("#" + data.get(0) + "\n");
			for (int i = 0; i < data.size(); i += 2) {
				if (data.get(i).equals(data.get(0))) { // skip first element
					// do nothing
				} else {
					writer.write("##" + data.get(i) + "\n");
				}
				String[] tmp = data.get(i + 1).split("!@!");
				for (int j = 0; j < tmp.length; j++) {
					writer.write("* " + tmp[j] + "\n");
				}
				writer.write("\n");
			}
		} catch (IOException e) {
			System.out.println("I couldn't create the file.");
			e.printStackTrace();
		}
	}

}
