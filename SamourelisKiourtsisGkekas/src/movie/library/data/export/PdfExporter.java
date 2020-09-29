package movie.library.data.export;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfExporter implements Exporter {
	private Document document;
	private Font paragraphFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.NORMAL);
	private Font boldFont = FontFactory.getFont(FontFactory.HELVETICA, 12, Font.BOLD);
	private ArrayList<String> data;
	private String fileName;
	private Paragraph details;
	private Paragraph detailsTitle;

	public PdfExporter() {
		// TODO Auto-generated constructor stub
	}

	public void write(ArrayList<String> data, String name) {
		document = new Document();
		this.fileName = name;
		this.data = data;
		parseDataArray();

		document.close();

	}

	public void parseDataArray() {
		try {
			PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));
			document.open();
			Paragraph titleInText = new Paragraph(data.get(0) + "\n", boldFont);
			titleInText.setAlignment(Element.ALIGN_CENTER);
			document.add(titleInText);
			System.out.println(data.size());
			for (int i = 0; i < data.size(); i += 2) {
				if (data.get(i).equals(data.get(0))) { // skip first element
					// do nothing
				} else {
					detailsTitle = new Paragraph(data.get(i), boldFont);
					document.add(detailsTitle);
				}
				String[] tmp = data.get(i + 1).split("!@!");
				for (int j = 0; j < tmp.length; j++) {

					details = new Paragraph(tmp[j] + "\n", paragraphFont);
					document.add(details);
				}
				details = new Paragraph("\n");
				document.add(details);

			}
		} catch (FileNotFoundException | DocumentException e) {
			System.out.println("I couldn't create the file.");
			e.printStackTrace();
		}
	}

}
