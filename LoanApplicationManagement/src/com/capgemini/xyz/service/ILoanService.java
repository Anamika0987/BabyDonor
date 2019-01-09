package com.capgemini.xyz.service;

import java.io.IOException;
import java.sql.SQLException;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;

public interface ILoanService {
	public Loan applyLoan(Loan loan) throws ClassNotFoundException, SQLException, IOException;
	public boolean validateCustomer(Customer customer);
	 public long insertCust(Customer cust) throws ClassNotFoundException, SQLException, IOException;
	public double calculateEMI(double loanAmount, int duration);
}
