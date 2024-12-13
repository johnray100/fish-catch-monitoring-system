package jay.fishcatchmonitoringsystem.City.Controller;

import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import jay.fishcatchmonitoringsystem.City.Model.City;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class CityDataPdfExport extends AbstractPdfView {

    @Override
    protected void buildPdfMetadata(Map<String, Object> model, Document document, HttpServletRequest request) {
        Font headerFont = new Font(Font.TIMES_ROMAN, 14, Font.BOLD, Color.black);
        HeaderFooter header = new HeaderFooter(new Phrase("All City Data View", headerFont), false);
        header.setAlignment(Element.ALIGN_CENTER);
        document.setHeader(header);

        Font dateFont = new Font(Font.NORMAL, 11, Font.NORMAL, Color.DARK_GRAY);

        HeaderFooter footer = new HeaderFooter(new Phrase("PDF Export Executed On : " + new Date(), dateFont), true);
        footer.setAlignment(Element.ALIGN_CENTER);
        document.setFooter(footer);
    }

    @Override
    protected void buildPdfDocument(
            Map<String, Object> model,
            Document document,
            PdfWriter writer,
            HttpServletRequest request,
            HttpServletResponse response)
            throws Exception {

        //download PDF with a given filename
        response.addHeader("Content-Disposition", "attachment;filename=cityData.pdf");

        //read data from controller
        List<City> list = (List<City>) model.get("city");

        //create element
        Font titleFont = new Font(Font.TIMES_ROMAN, 11, Font.BOLD, Color.DARK_GRAY);
        Paragraph title = new Paragraph("ALL CITY DATA", titleFont);
        title.setAlignment(Element.ALIGN_CENTER);
        title.setSpacingBefore(20.0f);
        title.setSpacingAfter(25.0f);

        //add to document
        document.add(title);
        Font tableHead = new Font(Font.TIMES_ROMAN, 11, Font.BOLD, Color.GRAY);
        PdfPTable table = new PdfPTable(3);// no.of columns
        table.addCell(new Phrase("ID", tableHead));
        table.addCell(new Phrase("CITY NAME", tableHead));
        table.addCell(new Phrase("PROVINCE", tableHead));

        for (City city: list) {
            table.addCell(String.valueOf(city.getId()));
            table.addCell(city.getCityName());
            table.addCell(city.getProvinceName());
        }
        //add table data to document
        document.add(table);
    }
}
