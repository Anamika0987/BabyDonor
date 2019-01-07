package Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import bean.DemandBean;
import util.DBConnection;

public class DemanddaoImpl implements IDemanddao {

	@Override
	public String addDemandDraftDetails(DemandBean db) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DBConnection.getConnection();
		Statement statement = connection.createStatement();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
String transactionId = null;
		
		try
		{
			preparedStatement = connection.prepareStatement("insert into demand_draft values(transaction_Id_Seq.nextval,?,?,?,?,?,?,?)");
			
			preparedStatement.setString(1, db.getCustomerName());
			preparedStatement.setString(2, db.getInFavourOf());
			preparedStatement.setString(3, db.getPhoneNumber());
			preparedStatement.setString(4, db.getDateOfTransaction());
			preparedStatement.setDouble(5, db.getDdAmount());
			preparedStatement.setDouble(6, db.getDdCommision());
			preparedStatement.setString(7, db.getDdDescription());
			
			preparedStatement.executeUpdate();
			
			resultSet = statement.executeQuery("Select * from demand_draft order by transaction_id");
		

			//resultSet = statement.executeQuery("Select * from Library");
			
			while(resultSet.next())
			{
				transactionId = resultSet.getString(1);
								
			}
			return transactionId;
			
		}catch (Exception e)
		{
			System.out.println(e);
		}
	
		return transactionId;

	}
	
	@Override
	public DemandBean getDemandDraftDetails(int transactionId) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = DBConnection.getConnection();
		Statement statement = connection.createStatement();
		DemandBean db = new DemandBean();

		ResultSet resultSet = null;
		
		resultSet = statement.executeQuery("Select * from demand_draft order by transaction_id");
		
		try
		{
		while(resultSet.next())
		{
			db.setTransactionId(resultSet.getString(1));
			db.setCustomerName(resultSet.getString(2));
			db.setInFavourOf(resultSet.getString(3));
			db.setPhoneNumber(resultSet.getString(4));
			db.setDateOfTransaction(resultSet.getString(5));
			db.setDdAmount(resultSet.getDouble(6));
			db.setDdCommision(resultSet.getDouble(7));
			db.setInFavourOf(resultSet.getString(8));
			
			
		}
		}catch (Exception e)
		{
			System.out.println(e);
		}
		

		
		return db;
	}

}
