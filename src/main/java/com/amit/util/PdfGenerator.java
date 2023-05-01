package com.amit.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;

import com.amit.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

@Component
public class PdfGenerator {
	
	public void generate(HttpServletResponse response,List<CitizenPlan> plans , File f) throws Exception{
		
		Document document = new Document(PageSize.A4);
		PdfWriter pdfWriter = PdfWriter.getInstance(document, response.getOutputStream());
		pdfWriter.getInstance(document,new FileOutputStream(f));
		document.open();
		// Creating font
		// Setting font style and size
		Font fontTiltle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
		fontTiltle.setSize(20);

		// Creating paragraph
		Paragraph paragraph = new Paragraph("Citizen Plan", fontTiltle);

		// Aligning the paragraph in document
		paragraph.setAlignment(Paragraph.ALIGN_CENTER);

		// Adding the created paragraph in document
		document.add(paragraph);

		PdfPTable table = new PdfPTable(7);
		table.setSpacingBefore(6);

		table.addCell("ID");
		table.addCell("Citizen Name");
		table.addCell("Plan Name");
		table.addCell("Citizen Status");
		table.addCell("Start Date ");
		table.addCell("End Date");
		table.addCell("benefitAmount");

		for (CitizenPlan plan : plans) {
			table.addCell(String.valueOf(plan.getCitizenId()));
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());

			if (null != plan.getPlanStartDate()) {
				table.addCell(plan.getPlanStartDate() + "");
			} else {
				table.addCell("N/A");
			}

			if (null != plan.getPlanEndDate()) {
				table.addCell(plan.getPlanEndDate() + "");
			} else {
				table.addCell("N/A");
			}

			if (null != plan.getBenefitAmount()) {
				table.addCell(plan.getBenefitAmount() + "");
			} else {
				table.addCell("N/A");
			}
		}
		document.add(table);
		document.close();
	}
}
