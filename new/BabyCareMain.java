package com.cg.babycare.pl;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.babycare.bean.BabyHealthCare;
import com.cg.babycare.bean.BabyProduct;
import com.cg.babycare.exception.BabyCareException;
import com.cg.babycare.service.BabyServiceImpl;
import com.cg.babycare.service.IBabyService;

public class BabyCareMain 
{
	static Scanner sc = new Scanner(System.in);
	static IBabyService babyService = null;
	static BabyServiceImpl babyServiceImpl = null;
	
	public static void main(String[] args) throws ClassNotFoundException, FileNotFoundException, SQLException {
		
		BabyProduct babyProduct = null;
		BabyHealthCare babyHealthCare = null;
		
	

		String babyId = null;
		int option = 0;

		while (true) 
		{

			// show menu
			System.out.println();
			System.out.println();
			

			System.out.println("1.Baby Products ");
			System.out.println("2.Baby HealthCare");
			System.out.println("3.Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			// accept option

			try 
			{
				option = sc.nextInt();

				switch (option) 
				{

				case 1:
					/*System.out.println("Buyer or seller");
                     String option1= sc.next();
                          if(option1=="Buyer")
                       {
                        	  
                       
                    	System.out.println("List of Products"); 
                    	System.out.println(""); 
                    	System.out.println(""); 
                    	System.out.println(""); 
                    	System.out.println(""); 
                    	
                       }*/
                     
                     
                    break;
                    
				
				case 2: 
					
					while (babyHealthCare == null) 
					{   
						
						babyHealthCare = populateBabyHealthCare();
						// System.out.println(donorBean);
					}

					try 
					{
						babyService = new BabyServiceImpl();
						babyId = babyService.addBaby(babyHealthCare);

						System.out
								.println("Baby details  has been successfully registered ");
						System.out.println("Baby ID Is: " + babyId);

					} 
					catch (BabyCareException babyCareException) 
					{
						
						System.err.println("ERROR : "+ babyCareException.getMessage());
					} 
					finally 
					{
						babyId = null;
						babyService = null;
						babyHealthCare = null;
					}

					break;
				case 3:

					System.out.print("Exit Trust Application");
					System.exit(0);
					break;
				default:
					System.out.println("Enter a valid option[1-4]");
				}// end of switch
			}

			catch (InputMismatchException e) 
			{
				sc.nextLine();
				System.err.println("Please enter a numeric value, try again");
					
			}	
		
		}
	}
					
		private static BabyHealthCare populateBabyHealthCare() {
						// TODO Auto-generated method stub
						
						BabyHealthCare babyHealthCare = new BabyHealthCare();
						System.out.println("\n Enter Details");
						
						
						System.out.println("Baby Name: ");
						babyHealthCare.setBabyName(sc.next());
						
						System.out.println("Baby Age:");
						babyHealthCare.setBabyAge(sc.next());

						System.out.println("Baby Gender: ");
						babyHealthCare.setBabyGender(sc.next());

						System.out.println("Father's Name: ");
						babyHealthCare.setFatherName(sc.next());

						System.out.println("Mother's Name: ");
						babyHealthCare.setMotherName(sc.next());

						System.out.println("Address: ");
						babyHealthCare.setAddress(sc.next());
						

						System.out.println("Contact: ");
						babyHealthCare.setContact(sc.next());
						

						
						
						

						while (true) 
						{ System.out.println("Enter the Health Issue baby is facing:");
						  System.out.println("");
						  System.out.println("");
					      System.out.println("1.Fever ");
					      System.out.println("2.Coughing");
						  System.out.println("3.Colic");
						  System.out.println("4.Skin Problems");
						  System.out.println("5.Ear Infections");
						  System.out.println("6.Regular Checkup");
						  System.out.println("________________________________");
						  System.out.println("Select an option:");
						  try 
						{   int option1=0;
						option1 = sc.nextInt();
						switch (option1) 
						{ case 1: 
							System.out.println("Doctor Name: Mohan ");
							System.out.println("Doctor Address: Chennai");
							System.out.println("Contact No.: 9874563210");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							
							break;
							
						case 2:
							System.out.println("Doctor Name: Sohini");
							System.out.println("Doctor Address: Pune");
							System.out.println("Contact No.: 7859632410");	
							System.out.println("");
							System.out.println("");
							System.out.println("");
						    
							break;
						case 3:
							System.out.println("Doctor Name: Shubhi");
							System.out.println("Doctor Address: Mumbai");
							System.out.println("Contact No.: 9852631470");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							
							break;
							
						case 4: 
							System.out.println("Doctor Name: Narayni");
							System.out.println("Doctor Address: Bangalore");
							System.out.println("Contact No.:7586932401");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							
							break;
							
						case 5:
							System.out.println("Doctor Name: Jaya");
							System.out.println("Doctor Address: Bangalore");
							System.out.println("Contact No.:7586556921");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							
							break;
							
						case 6:
							System.out.println("Doctor Name: Anamika");
							System.out.println("Doctor Address: Andaman Nicobar");
							System.out.println("Contact No.:7587586921");
							System.out.println("");
							System.out.println("");
							System.out.println("");
							
							break;
							
						default:
							System.out.println("Enter a valid option[1-6]");
							System.out.println("");
							System.out.println("");
							System.out.println("");
						
						}
						
						}
						catch (InputMismatchException e) 
						{
							sc.nextLine();
							System.err.println("Please enter a numeric value, try again");
						}
						
						/*System.out.println("Enter donation amount: ");
						try {
							baby.setDonationAmount(sc.nextFloat());
						}
						catch (InputMismatchException ime) {
							// TODO: handle exception
							sc.nextLine();
							System.out.println("Please enter a numeric value for donation amount, try again ");
						}*/
						babyServiceImpl = new BabyServiceImpl(); 
						try 
						{
							babyServiceImpl.validateBaby1(babyHealthCare);
							return babyHealthCare;
							
						}
						catch (BabyCareException babyCareException) 
						{
							System.err.println("invalid data");
							System.err.println(babyCareException.getMessage()+"\n Try again..");
							System.exit(0);
						}
						return null;
					}
					
		}
}




		