package com.cg.babycare.dao;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.cg.babycare.bean.BabyHealthCare;
import com.cg.babycare.bean.BabyProduct;
import com.cg.babycare.exception.BabyCareException;
import com.cg.babycare.util.BabyCareDBConnection;

public class BabyDaoImpl implements IBabyDao
{

	@Override
	public String addBaby(BabyHealthCare baby) throws BabyCareException, ClassNotFoundException, FileNotFoundException, SQLException
	{
		Connection connection =BabyCareDBConnection.getConnection();	
		PreparedStatement prepareStatement= null;
		ResultSet rs= null;
		//ResultSet rs1= null;
		
		
		String babyId= null;
		int queryResult=0;
		
		    
		
		try
		{   Statement st= connection.createStatement();
			prepareStatement= connection.prepareStatement("Insert into Baby_Details1 values(Baby_Id.nextval,?,?,?,?,?,?,?)");
			
			prepareStatement.setString(1, baby.getBabyName());
			prepareStatement.setString(2, baby.getBabyAge());
			prepareStatement.setString(3, baby.getBabyGender());
			prepareStatement.setString(4, baby.getFatherName());
			prepareStatement.setString(5, baby.getMotherName());
			prepareStatement.setString(6, baby.getAddress());
			prepareStatement.setString(7, baby.getContact());
			
			prepareStatement.executeUpdate();
			rs = st.executeQuery("SELECT * FROM Baby_Details1 order by Baby_Id");

			while(rs.next())
			    {
				
				System.out.println("Baby ID: "+rs.getString(1));
				System.out.println("Baby Name: "+rs.getString(2));
				System.out.println("Baby Age: "+rs.getString(3));
				System.out.println("Baby Gender: "+rs.getString(4));
				System.out.println("Father Name: "+rs.getString(5));
				System.out.println("Mother Name: "+rs.getString(6));
				System.out.println("Address: "+rs.getString(7));
				System.out.println("Contact: "+rs.getString(8));
				
				
				babyId= rs.getString(1);
						
			  }
			
		}
		
		catch(SQLException sql)
		
		{
			System.out.println(sql);
		}
		
		
		return babyId;
		
	}

	

	@Override
	public BabyHealthCare viewBabyDetails(String babyId) throws BabyCareException, ClassNotFoundException, FileNotFoundException, SQLException 
	{
		
			
			Connection connection=BabyCareDBConnection.getConnection();
			
			
			PreparedStatement preparedStatement=null;
			ResultSet resultset = null;
			BabyHealthCare baby=null;
			
			try
			{
				//preparedStatement= connection.prepareStatement(QueryMapper.VIEW_DONAR_DETAILS_QUERY);
				preparedStatement.setString(1,babyId);
				resultset=preparedStatement.executeQuery();
				
				if(resultset.next())
				{
					baby = new BabyHealthCare();
					baby.setBabyName(resultset.getString(1));
					baby.setBabyAge(resultset.getString(2));
					baby.setBabyGender(resultset.getString(3));
					baby.setFatherName(resultset.getString(4));
					baby.setMotherName(resultset.getString(5));
					baby.setAddress(resultset.getString(6));
					baby.setContact(resultset.getString(7));
					
					
				}
			}
				
				
			
			
				catch (SQLException e) 
				{
					
					throw new BabyCareException("Error in closing db connection");

				}
			
			return baby;
		}

	

	@Override
	public String addProduct(BabyProduct babyProduct) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BabyProduct viewBabyProduct(String proName) {
		// TODO Auto-generated method stub
		return null;
	}

	
   
}
