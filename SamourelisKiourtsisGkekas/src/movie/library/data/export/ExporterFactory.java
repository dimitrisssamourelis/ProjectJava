package movie.library.data.export;

public class ExporterFactory {

	public Exporter getExporter(String exportType) {
		if (exportType == null) {
			return null;
		}
		if (exportType.equalsIgnoreCase("TEXT")) {
			return new TextExporter();

		} else if (exportType.equalsIgnoreCase("PDF")) {
			return new PdfExporter();

		} else if (exportType.equalsIgnoreCase("MARKDOWN")) {
			return new MarkDownExporter();

		} else if (exportType.equalsIgnoreCase("HTML")) {
			return new HtmlExporter();
		}

		return null;
	}

	public TxtToPdfConverter getConverter(String convertType) {
		if (convertType == null) {
			return null;
		}
		if (convertType.equalsIgnoreCase("TXTTOPDF")) {
			return new TxtToPdfConverter();
		}
		return null;
	}
}