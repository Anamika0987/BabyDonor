package dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import exception.TrainException;
import ticketBean.Train;

public interface ITicketReservationDao {
	public String Book_ticket(String source,String destination) throws ClassNotFoundException, SQLException, IOException;

	public String add_Train(Train tre);
	public Train viewTrainDetails() throws TrainException;
	
}
