package com.amit.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.amit.entity.CitizenPlan;
import com.amit.request.SearchRequest;
import com.amit.service.ReportService;

@Controller
public class ReportController {

	@Autowired
	private ReportService service;
	@GetMapping("/pdf")
	public void pdfExport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/pdf");
		
		String headerKey="Content-Disposition";
		String headerValue="attachment;filename=plans.pdf";
		response.addHeader(headerKey,headerValue);
		service.exportPdf(response);
	}
	
	
	@GetMapping("/excel")
	public void generateExcelReport(HttpServletResponse response) throws Exception {
		
		response.setContentType("application/octet-stream");
		response.addHeader("Content-Disposition","attachment;filename=plans.xls");

		service.exportExcel(response);
	}
	
	@PostMapping("/search")
	public String handleSearch(@ModelAttribute("search") SearchRequest search, Model model) {
		List<CitizenPlan> plans = service.search(search);
		model.addAttribute("plans", plans);
		init(model);
		return "index";
	}

	@GetMapping("/")
	public String LoadIndexPage(Model model) {
		model.addAttribute("search", new SearchRequest());
		init(model);
		return "index";
	}

	private void init(Model model) {

		model.addAttribute("names", service.getPlanName());
		model.addAttribute("status", service.getPlanStatus());
	}
}
