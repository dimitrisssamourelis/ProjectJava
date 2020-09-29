package movie.library.data.export;

import java.util.ArrayList;

public interface Exporter {

	void write(ArrayList<String> data, String fileName);

	void parseDataArray();
}
