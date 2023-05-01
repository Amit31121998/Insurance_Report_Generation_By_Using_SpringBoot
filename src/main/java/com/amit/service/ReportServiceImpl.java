package com.amit.service;

import java.io.File;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.amit.entity.CitizenPlan;
import com.amit.repo.CitizenPlanRepository;
import com.amit.request.SearchRequest;
import com.amit.util.EmailUtils;
import com.amit.util.ExcelGenerator;
import com.amit.util.PdfGenerator;

@Service
public class ReportServiceImpl implements ReportService {

	@Autowired
	private CitizenPlanRepository planRepo;

	@Autowired
	private ExcelGenerator excelGenerator;
	
	@Autowired
	private PdfGenerator pdfGenerator;
	
	@Autowired
	private EmailUtils emailUtils;

	@Override
	public List<String> getPlanName() {
		return planRepo.getPlanNames();
	}

	@Override
	public List<String> getPlanStatus() {

		return planRepo.getPlanStatus();
	}

	@Override
	public List<CitizenPlan> search(SearchRequest request) {

		CitizenPlan entity = new CitizenPlan();
		if (null != request.getPlanName() && !"".equals(request.getPlanName())) {
			entity.setPlanName(request.getPlanName());
		}

		if (null != request.getPlanStatus() && !"".equals(request.getPlanStatus())) {
			entity.setPlanStatus(request.getPlanStatus());
		}

		if (null != request.getGender() && !"".equals(request.getGender())) {
			entity.setGender(request.getGender());
		}

		if (null != request.getStartDate() && !"".equals(request.getStartDate())) {
			String startDate = request.getStartDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate parse = LocalDate.parse(startDate, formatter);
			entity.setPlanStartDate(parse);
		}

		if (null != request.getEndDate() && !"".equals(request.getEndDate())) {
			String endDate = request.getEndDate();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate parse = LocalDate.parse(endDate, formatter);
			entity.setPlanEndDate(parse);
		}

		return planRepo.findAll(Example.of(entity));
	}

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		List<CitizenPlan> plans = planRepo.findAll();
		
		File f=new File("Plans.xls");
		excelGenerator.generate(response, plans,f);
		
		String subject="Test mail subject";
		String body="Test mail body";
		String to="bishwas855105@gmail.com";
		
		
		emailUtils.sendEmail(subject, body, to,f);
		f.delete();
		return true;
	}

	@Override
	public boolean exportPdf(HttpServletResponse response) throws Exception {
        List<CitizenPlan> plans = planRepo.findAll();
        File f=new File("Plans.pdf");
        pdfGenerator.generate(response, plans,f);
        
        String subject="Test mail subject";
		String body="Test mail body";
		String to="bishwas855105@gmail.com";
		
		emailUtils.sendEmail(subject, body, to,f);
		f.delete();
		return true;
	}

}
