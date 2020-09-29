package movie.library.data.export;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class TxtToPdfConverter {
	private String fileName;
	private String newFileName;

	public void write(String name) {
		fileName = name + ".txt";
		newFileName = name + ".pdf";
		File file = new File(newFileName);
		try {
			createPdf();
		} catch (DocumentException | IOException e) {
			System.out.println("I couldn't find that file name...");
		}
	}

	public void createPdf() throws DocumentException, IOException {
		Document document = new Document();
		PdfWriter.getInstance(document, new FileOutputStream(newFileName));
		document.open();
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		String line;
		Paragraph p;
		Font normal = new Font(FontFamily.TIMES_ROMAN, 12);
		Font bold = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD);
		boolean title = true;
		while ((line = br.readLine()) != null) {
			p = new Paragraph(line, title ? bold : normal);
			p.setAlignment(Element.ALIGN_JUSTIFIED);
			title = line.isEmpty();
			document.add(p);
		}
		document.close();
	}

}
