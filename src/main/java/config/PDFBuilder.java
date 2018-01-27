package config;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import business.ConfirmationTO;
import business.OrderConfirmation;
import business.Product;

public class PDFBuilder extends AbstractITextPdfView {

	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document doc, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {
		// get data model which is passed by the Spring container
		OrderConfirmation orderConfirmation = (OrderConfirmation) model.get("listConfirmationTOs");

		doc.add(new Paragraph("Invoice Details"));

		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(100.0f);
		table.setWidths(new float[] { 3.0f, 2.0f, 2.0f, 2.0f });
		table.setSpacingBefore(10);

		// define font for table header row
		Font font = FontFactory.getFont(FontFactory.HELVETICA);
		font.setColor(BaseColor.WHITE);

		// define table header cell
		PdfPCell cell = new PdfPCell();
		cell.setBackgroundColor(BaseColor.BLUE);
		cell.setPadding(5);

		// write table header
		cell.setPhrase(new Phrase("ProductId", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("ProductName", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Price", font));
		table.addCell(cell);

		cell.setPhrase(new Phrase("Quantity", font));
		table.addCell(cell);

		/*cell.setPhrase(new Phrase("Price", font));
		table.addCell(cell);*/

		// write table row data
		for (Product aConfirmationTO : orderConfirmation.getPersonListContainer().getProductList()) {
			table.addCell(aConfirmationTO.getProductId());
			table.addCell(aConfirmationTO.getProductName());
			table.addCell(Double.toString(aConfirmationTO.getPrice()));
			table.addCell(Double.toString(aConfirmationTO.getQuantity()));
		}

		doc.add(table);
		doc.add(new Paragraph("Total:" + orderConfirmation.getTotal()));

	}

}
