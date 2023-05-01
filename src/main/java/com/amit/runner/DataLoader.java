package com.amit.runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.amit.entity.CitizenPlan;
import com.amit.repo.CitizenPlanRepository;

@Component
public class DataLoader implements ApplicationRunner {

	@Autowired
	CitizenPlanRepository crepo;

	@Override
	public void run(ApplicationArguments args) throws Exception {
		
		crepo.deleteAll();

		// Cash plan
		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("Steve");
		c1.setPlanName("Cash");
		c1.setGender("Male");
		c1.setPlanStatus("Approved");
		c1.setPlanStartDate(LocalDate.now());
		c1.setPlanEndDate(LocalDate.now().plusMonths(6));
		c1.setBenefitAmount(20000.00);

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Cathy");
		c2.setPlanName("Cash");
		c2.setPlanStatus("Approved");
		c2.setGender("FeMale");
		c2.setPlanStartDate(LocalDate.now());
		c2.setPlanEndDate(LocalDate.now().plusMonths(4));
		c2.setBenefitAmount(25000.00);

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Robert");
		c3.setPlanName("Cash");
		c3.setGender("Male");
		c3.setPlanStatus("Denied");
		c3.setDenialReason("NoJob");

		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("Scarelet");
		c4.setPlanName("Cash");
		c4.setGender("FeMale");
		c4.setPlanStatus("Denied");
		c3.setDenialReason("GovJob");

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Raju");
		c5.setPlanName("Cash");
		c5.setGender("Male");
		c5.setPlanStatus("Terminated");
		c5.setPlanStartDate(LocalDate.now());
		c5.setPlanEndDate(LocalDate.now().plusMonths(6));
		c5.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(2));
		c5.setTerminatedReason("getJob");

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Rani");
		c6.setPlanName("Cash");
		c6.setGender("FeMale");
		c6.setPlanStatus("Terminated");
		c6.setPlanStartDate(LocalDate.now());
		c6.setPlanEndDate(LocalDate.now().plusMonths(6));
		c6.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(3));
		c6.setTerminatedReason("FinanceReason");

		// Food plan
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Amit");
		c7.setPlanName("Food");
		c7.setGender("Male");
		c7.setPlanStatus("Approved");
		c7.setPlanStartDate(LocalDate.now());
		c7.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmount(23000.00);

		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Rohini");
		c8.setPlanName("Food");
		c8.setPlanStatus("Approved");
		c8.setGender("FeMale");
		c8.setPlanStartDate(LocalDate.now());
		c8.setPlanEndDate(LocalDate.now().plusMonths(4));
		c8.setBenefitAmount(26000.00);

		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("Saffu");
		c9.setPlanName("Food");
		c9.setGender("Male");
		c9.setPlanStatus("Denied");
		c9.setDenialReason("FakeData");

		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Sita");
		c10.setPlanName("Food");
		c10.setGender("FeMale");
		c10.setPlanStatus("Denied");
		c10.setDenialReason("NoIncome");

		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("Raju");
		c11.setPlanName("Food");
		c11.setGender("Male");
		c11.setPlanStatus("Terminated");
		c11.setPlanStartDate(LocalDate.now());
		c11.setPlanEndDate(LocalDate.now().plusMonths(6));
		c11.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(2));
		c11.setTerminatedReason("retired");

		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("Rani");
		c12.setPlanName("Cash");
		c12.setGender("FeMale");
		c12.setPlanStatus("Terminated");
		c12.setPlanStartDate(LocalDate.now());
		c12.setPlanEndDate(LocalDate.now().plusMonths(6));
		c12.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(3));
		c12.setTerminatedReason("finance");
		
		CitizenPlan c13 = new CitizenPlan();
		c13.setCitizenName("Tauhid");
		c13.setPlanName("Medical");
		c13.setGender("Male");
		c13.setPlanStatus("Approved");
		c13.setPlanStartDate(LocalDate.now());
		c13.setPlanEndDate(LocalDate.now().plusMonths(6));
		c7.setBenefitAmount(27000.00);
		
		CitizenPlan c14 = new CitizenPlan();
		c14.setCitizenName("Sujata");
		c14.setPlanName("Medical");
		c14.setGender("FeMale");
		c14.setPlanStatus("Approved");
		c14.setPlanStartDate(LocalDate.now());
		c14.setPlanEndDate(LocalDate.now().plusMonths(6));
		c14.setBenefitAmount(21000.00);
		
		CitizenPlan c15 = new CitizenPlan();
		c15.setCitizenName("Rohan");
		c15.setPlanName("Medical");
		c15.setGender("Male");
		c15.setPlanStatus("Denied");
		c15.setDenialReason("fakeJob");

		CitizenPlan c16 = new CitizenPlan();
		c16.setCitizenName("Soni");
		c16.setPlanName("Medical");
		c16.setGender("FeMale");
		c16.setPlanStatus("Denied");
		c16.setDenialReason("GovJob");
		
		CitizenPlan c17 = new CitizenPlan();
		c17.setCitizenName("Naveen");
		c17.setPlanName("Medical");
		c17.setGender("Male");
		c17.setPlanStatus("Terminated");
		c17.setPlanStartDate(LocalDate.now());
		c17.setPlanEndDate(LocalDate.now().plusMonths(6));
		c17.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(4));
		c17.setTerminatedReason("oldAge");

		CitizenPlan c18 = new CitizenPlan();
		c18.setCitizenName("Minakshi");
		c18.setPlanName("Medical");
		c18.setGender("FeMale");
		c18.setPlanStatus("Terminated");
		c18.setPlanStartDate(LocalDate.now());
		c18.setPlanEndDate(LocalDate.now().plusMonths(6));
		c18.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(1));
		c18.setTerminatedReason("child");
		
		CitizenPlan c19 = new CitizenPlan();
		c19.setCitizenName("Shuvam");
		c19.setPlanName("Employment");
		c19.setGender("Male");
		c19.setPlanStatus("Approved");
		c19.setPlanStartDate(LocalDate.now());
		c19.setPlanEndDate(LocalDate.now().plusMonths(6));
		c19.setBenefitAmount(35000.00);

		CitizenPlan c20 = new CitizenPlan();
		c20.setCitizenName("Renu");
		c20.setPlanName("Employment");
		c20.setPlanStatus("Approved");
		c20.setGender("FeMale");
		c20.setPlanStartDate(LocalDate.now());
		c20.setPlanEndDate(LocalDate.now().plusMonths(4));
		c20.setBenefitAmount(36000.00);

		CitizenPlan c21 = new CitizenPlan();
		c21.setCitizenName("Avhisek");
		c21.setPlanName("Employment");
		c21.setGender("Male");
		c21.setPlanStatus("Denied");
		c21.setDenialReason("fake");

		CitizenPlan c22 = new CitizenPlan();
		c22.setCitizenName("Geeta");
		c22.setPlanName("Employment");
		c22.setGender("FeMale");
		c22.setPlanStatus("Denied");
		c22.setDenialReason("notMarried");
		
		CitizenPlan c23 = new CitizenPlan();
		c23.setCitizenName("Sonu");
		c23.setPlanName("Employment");
		c23.setGender("Male");
		c23.setPlanStatus("Terminated");
		c23.setPlanStartDate(LocalDate.now());
		c23.setPlanEndDate(LocalDate.now().plusMonths(6));
		c23.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(4).minusDays(9));
		c23.setTerminatedReason("too late");

		CitizenPlan c24 = new CitizenPlan();
		c24.setCitizenName("Soni");
		c24.setPlanName("Employment");
		c24.setGender("FeMale");
		c24.setPlanStatus("Terminated");
		c24.setPlanStartDate(LocalDate.now());
		c24.setPlanEndDate(LocalDate.now().plusMonths(6));
		c24.setTerminatedDate(LocalDate.now().plusMonths(6).minusMonths(3).minusDays(10));
		c24.setTerminatedReason("widow");
		
		
		List<CitizenPlan> list = Arrays.asList(c1, c2, c3, c4, c5, c6,c7,c8,c9,c10,c11,c12,c13,c14,c15,c16,c17,c18,c19,c20,c21,c22,c23,c24);
		crepo.saveAll(list);

	}
}
