package com.capgemini.xyz.dao;

import java.io.IOException;
import java.sql.SQLException;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;

public interface ILoanDao {

	public long insertCust(Customer cust) throws SQLException, ClassNotFoundException, IOException;
	public Loan applyLoan(Loan loan) throws SQLException, ClassNotFoundException, IOException;

}