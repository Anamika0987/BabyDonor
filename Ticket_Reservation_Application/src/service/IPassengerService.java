package service;

import exception.TrainException;
import ticketBean.Passenger;
import ticketBean.Train;

public interface IPassengerService {
	public String Book_ticket(Passenger pr);
	public String cancel_ticket(Passenger pr);
	public String add_Train(Passenger pr);
	//public Train viewTrainDetails() throws TrainException;
	
	public void validatePassenger(Passenger pr) throws TrainException;
}
