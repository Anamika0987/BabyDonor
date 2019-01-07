package client;

import java.util.Scanner;

import Service.DemandService;
import Service.IDemand;
import bean.DemandBean;

public class DemandMain {
	static Scanner scn = new Scanner(System.in);
	static IDemand idemand = null;
	static DemandService demandservice = null;
	
	public static void main(String[] args) {
		DemandBean db= null;
		String TransactionId=null;
		int option=0;
		while(true)
		{
			System.out.println();
			System.out.println();
			System.out.println("   XYZBANK ");
			System.out.println("_______________________________\n");

			System.out.println("1. Enter Demand Draft Details ");
			System.out.println("2. Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			try
			{
				option= scn.nextInt();
				switch (option) {
				case 1:
					while(db==null)
					{
						db=populatedb();
					}
					try {
						demandservice=new DemandService();
						TransactionId=demandservice.addDemandDraftDetails(db);
						System.out.println("Your Demand Draft request has been successfully registered along with the "+TransactionId);
					}catch (Exception e)
					{
						System.out.println("ERROR :" + e.getMessage());
					}
					
					break;
				case 2:
					System.out.println("Successfully Exit");
					System.exit(0);
					
				default:
					
					System.out.println("Wrong Input");
					System.exit(0);
					
				}
				
			}catch (Exception e) {
				System.out.println(e);
			}
			
		}
		
	}
	

	private static DemandBean populatedb() {
		DemandBean db= new DemandBean();
		System.out.println("Enter Book Details :");
		
		System.out.println("\nEnter Customer Name : ");
		db.setCustomerName(scn.next());
		
		System.out.println("In Favour Of : ");
		db.setInFavourOf(scn.next());
		
		System.out.println("Enter Phone No : ");
		db.setPhoneNumber(scn.next());
		
		System.out.println("Date Of Transaction : ");
		db.setDateOfTransaction(scn.next());
		
		try
		{
		System.out.println("DD Amount : ");
		db.setDdAmount(scn.nextDouble());
		}catch (Exception e) {
			System.out.println("Invalid Data");
			System.err.println(e);
			System.exit(0);
		}
		
		try
		{
		System.out.println("DD Commission :");
		db.setDdCommision(scn.nextDouble());
		}catch (Exception e) {
			System.out.println("Invalid Data");
			System.err.println(e);
			System.exit(0);
		}
		
		System.out.println("Date Description : ");
		db.setDdDescription(scn.next());
		
		demandservice = new DemandService();
		
		try
		{
			demandservice.validateLibraryAttribute(db);
			return db;
		}catch (Exception e)
		{
			System.out.println("Invalid Data");
			System.err.println(e);
			System.exit(0);
		}
		
		return null;

	}


	}



	