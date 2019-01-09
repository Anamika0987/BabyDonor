package com.capgemini.xyz.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;
import com.capgemini.xyz.dao.ILoanDao;
import com.capgemini.xyz.dao.LoanDao;

public class LoanService implements ILoanService{
ILoanDao iloandao=new LoanDao();
	

	@Override
	public Loan applyLoan(Loan loan) throws ClassNotFoundException, SQLException, IOException {
		iloandao = new LoanDao();
		Loan returnLoan= new Loan();
		returnLoan = iloandao.applyLoan(loan); 
		return returnLoan ;
		
	}

	@Override
	public boolean validateCustomer(Customer customer) {
List <String> validationError  = new ArrayList<String>();
		
		if(!(isValidname(customer.getCustName())))
		{
			validationError.add("\n name should be of 25 digits ");
		}
		

		
		if(!(isValidAddress(customer.getAddress())))
		{
			validationError.add("\n Mobile Number should be of 40 digits ");
		}
		

		
		if(!(isValidmail(customer.getMail())))
		{
			validationError.add("\n Mail should be of 10 digits ");
		}
		return true;
		
		
		
	}

	private boolean isValidmail(String mail) {
		Pattern apattern = Pattern.compile("^((\"[\\w-\\s]+\")|([\\w-]+(?:\\.[\\w-]+)*)|(\"[\\w-\\s]+\")([\\w-]+(?:\\.[\\w-]+)*))(@((?:[\\w-]+\\.)*\\w[\\w-]{0,66})\\.([a-z]{2,6}(?:\\.[a-z]{2})?)$)|(@\\[?((25[0-5]\\.|2[0-4][0-9]\\.|1[0-9]{2}\\.|[0-9]{1,2}\\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\\]?$)");
		Matcher amatcher = apattern.matcher(mail);
		return amatcher.matches();
	}

	private boolean isValidAddress(String address) {
		Pattern apattern = Pattern.compile("^[A-Za-z]{1,}$");
		Matcher amatcher = apattern.matcher(address);
		return amatcher.matches();
	}

	private boolean isValidname(String custName) {
		Pattern apattern = Pattern.compile("^[A-Za-z]{1,}$");
		Matcher amatcher = apattern.matcher(custName);
		return amatcher.matches();
	}

	private boolean isValidContactNo(String contactNo) {
		Pattern apattern = Pattern.compile("^[6-9][0-9]{9}");
		Matcher amatcher = apattern.matcher(contactNo);
		return amatcher.matches();
	}

	@Override
	public long insertCust(Customer cust) throws ClassNotFoundException, SQLException, IOException {
		long custIdSeq;
		custIdSeq = iloandao.insertCust(cust);

		return custIdSeq;
	}

	@Override
	public double calculateEMI(double loanAmount, int duration) {
		// TODO Auto-generated method stub
		return 0;
	}

//
//	public double calculateEMI(double loanAmount, int duration) {
//	double calculatedEMI;
//	float rate = 9.5f;
//	calculatedEMI = (amt*rate*(1+rate)*duration)/((1+rate)*duration-1);
//	}

}
