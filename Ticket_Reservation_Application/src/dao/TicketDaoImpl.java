package dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import DBconnection.Dbconn;
import exception.TrainException;
import ticketBean.Passenger;
import ticketBean.Train;

public class TicketDaoImpl implements ITicketReservationDao{

	@Override
	public String Book_ticket(String source,String Destination) throws ClassNotFoundException, SQLException, IOException {
		Connection connection=Dbconn.getConnection();
		Statement st=connection.createStatement();
		PreparedStatement preparedstatement=null;
	ResultSet resultSet=null;
		Passenger pr=new Passenger();
		
		
	
		preparedstatement = connection.prepareStatement("insert into passenger values(?,?,?,?,?,pnr_seq.nextval)");
	
	preparedstatement.setString(1,pr.getPassengerName());
	preparedstatement.setString(2,pr.getSource());
	preparedstatement.setString(3,pr.getMailId());
	preparedstatement.setString(4,pr.getPhonenumber());
	preparedstatement.setString(5,pr.getDestination());
		
		preparedstatement.executeUpdate();
	//query for selecting max(pnr) from passenger
		resultSet=st.executeQuery("select * from train where source =? and destinatio=?");
	
		if(resultSet.next())
		{
			//System.out.println(" PassengerName: "+resultSet.getString(1)+"Source : "+resultSet.getString(2)+"destination: "+resultSet.getString(3));
			Book_ticket1 bt=new Book_ticket1();
			resultSet.getString(1);
			resultSet.getString(2);
			resultSet.getDouble(3);
			//set the max(pnr) to bt object
			
		}
		return Destination;		
	}
	

	
		
	
//	@Override
//	public String add_Train(Train tre) {
//		Connection connection=Dbconn.getConnection();// TODO Auto-generated method stub
//		PreparedStatement preparedstatement=null;
//		ResultSet resultSet=null;
//		
//		String trainNumber=null;
//		double price=0;
//		int queryResult=0;
//		try
//		{
//			
//			
//			
//			Statement st = connection.createStatement();
//			
//			preparedstatement = connection.prepareStatement("insert into Train values(?,?,?,?,?)");
//			preparedstatement.setString(1,tre.getTrainNumber());
//			preparedstatement.setString(2,tre.getTrainName());
//			preparedstatement.setDouble(3,tre.getPrice());
//			preparedstatement.setString(4,tre.getSource());
//			preparedstatement.setString(5,tre.getDestination());
//			
//			preparedstatement.executeUpdate();
//			
//			resultSet=st.executeQuery("select * from Train");
//			
//			while(resultSet.next())
//			{
//				System.out.println("TrainNumber : "+resultSet.getString(1)+" TrainName: "+resultSet.getString(2)+"source: "+resultSet.getString(3));
//				trainNumber = resultSet.getString(1);
//				String trainName = resultSet.getString(2);
//				price = resultSet.getString(3);
//		
//				
//			}
//			
//		}
//		catch(SQLException e)
//		{
//			System.out.println(e);
//		}
//		return trainNumber;
//	}


	@Override
	public Train viewTrainDetails() throws TrainException {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String add_Train(Train tre) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
