package com.capgemini.xyz.test;

import org.junit.Before;
import org.junit.Test;

import com.capgemini.xyz.bean.Loan;
import com.capgemini.xyz.dao.LoanDao;
import com.capgemini.xyz.exception.Loanexception;

public class Mtest {
	
	 static LoanDao dao=null;
	 Loan=null;
	 
	@Test
	 @Before
	 public void intialise() {
		 System.out.println("in before class");
			dao = new LoanDao();
			//ln = new  Loan();
	 }
	 
	 
	 
		@Test
		public void testAddEnquiry() throws Loanexception {
			
			Loan.setCustId("Dutt");
			Loan.setlName("Sai");
			enquiryBean.setContactNo("9912880822");
	     	enquiryBean.setpDomain("BackEnd");
	    	enquiryBean.setpLocation("Bang");
			assertEquals(enquiryBean,enquiryBean);
		}
		
		@Test
		public void testViewEnquiry() throws ContactBookException {
			
			assertNotNull(dao.getEnquiryDetails(1001));
		}

}
