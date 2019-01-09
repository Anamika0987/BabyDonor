package com.capgemini.xyz.ui;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import com.capgemini.xyz.bean.Customer;
import com.capgemini.xyz.bean.Loan;
import com.capgemini.xyz.dao.ILoanDao;
import com.capgemini.xyz.service.ILoanService;
import com.capgemini.xyz.service.LoanService;

public class ExecutorMain {
	static Scanner scn = new Scanner(System.in);
	static ILoanService iloanservice ;
	static LoanService loanservice ; 


	

	public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
		Customer c = null;
		String CustomerId = null;
		int option = 0;
		int choice =0;
		int customerId=0;
		while (true) {
			System.out.println();
			System.out.println();
			System.out.println("   XYZ Finance Company welcomes you ");
			System.out.println("_______________________________\n");

			System.out.println("1. Register customer ");
			System.out.println("2. Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			

				
				option = scn.nextInt();
				switch (option) {
				
				case 1:
					Customer customer = new Customer();
					System.out.println(" enter customer details ");
					System.out.println(" enter customer name ");
					String custName = scn.next();
					customer.setCustName(custName);
					
					System.out.println("enter your address");
					String address = scn.next();
					customer.setAddress(address);
					
					System.out.println(" enter your email ");
					String Mail = scn.next();
					customer.setMail(Mail);
					
					long custId;
					iloanservice = new LoanService();
					if(iloanservice.validateCustomer(customer)) {
						custId = iloanservice.insertCust(customer);
						System.out.println("customer details successfully added with id :"+custId);
						
						System.out.println("do you wish to apply for loan ?(Yes or No)");
						String applyLoan = scn.next();
						switch(applyLoan) {
							case "Yes":
								Loan loan=new Loan();
								System.out.println(" enter loan amount:");
								double amount = scn.nextDouble();
								loan.setLoanAmount(amount);
								
	
								
								System.out.println("enter loan duration");
								int duration = scn.nextInt();
								loan.setDuration(duration);
								
								Loan retLoan = new Loan();
								
								System.out.println(retLoan.getLoanId()+" "+retLoan.getLoanAmount()+" "+retLoan.getDuration()+" ");
								
								double Emi;
								Emi = iloanservice.calculateEMI(loan.getLoanAmount(), loan.getDuration());
								System.out.println(" emi on loan is :"+Emi);
								
								break;
							case "No":
								System.exit(0);
						}
						break; 
					}
					else {
						System.out.println(" you have entered invalid details");
					}	
				case 2:
					System.exit(0);
				default:
					System.out.println(" you entered invalid option");
					break;	
				}
		}
	}




//	private static Loan iloanserviceapplyLoan(Loan loan) {
//		// TODO Auto-generated method stub
//		return null;
	}
