package com.capgemini.xyz.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;

import util.Dbconnection;

public class LoanDao implements ILoanDao {

	@Override
	public long insertCust(Customer cust) throws SQLException, ClassNotFoundException, IOException {
		Connection connection = Dbconnection.getConnection();
		PreparedStatement preparedStatement = null;
		PreparedStatement preparedStatement1 = null;
		ResultSet resultSet = null;
		long custId = 0;
		//System.out.println("1");
		preparedStatement = connection.prepareStatement("insert into customer values(Cust_seq.nextval,?,?,?)");
		preparedStatement.setString(1, cust.getCustName());
		preparedStatement.setString(2, cust.getAddress());
		preparedStatement.setString(3, cust.getMail());
	//System.out.println("2");
		preparedStatement.executeUpdate();
		//System.out.println("3");
		preparedStatement1 = connection.prepareStatement("select Cust_seq.currval from customer");
		
		resultSet = preparedStatement1.executeQuery();
		while(resultSet.next()) {
			custId = resultSet.getLong(1);
		}
		return custId;
	}

	@Override
	public Loan applyLoan(Loan loan) throws SQLException, ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
