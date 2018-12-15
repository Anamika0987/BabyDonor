package service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



import exception.TrainException;
import ticketBean.Passenger;
import ticketBean.Train;

public class PassengerServiceImpl implements IPassengerService{

	@Override
	public String Book_ticket(Passenger pr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String cancel_ticket(Passenger pr) {
	
		return null;
	}

	@Override
	public String add_Train(Passenger pr) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void validatePassenger(Passenger pr) throws TrainException {

		List<String> validationErrors=new ArrayList<String>();
		
		if(!(isValidPassengerName(pr.getPassengerName()))) {
			validationErrors.add("Train name should be in alphabets and 10 characters long");
		}
		if(!(isvalidSource(pr.getSource()))){
			validationErrors.add("Source should be greater than 5 characters ");
		}
		if(!(isvalidDestination(pr.getDestination()))) {
			validationErrors.add("Destination should be greater than 5 characters ");
		}
		if(!(isvalidPrice(pr.getMailId()))){
			validationErrors.add("Price should be positive");
		}
		if(!validationErrors.isEmpty())
			throw new TrainException(validationErrors+" ");
			
		
	}

	private boolean isvalidPrice(String mailId) {
		// TODO Auto-generated method stub
		return false;
	}

	private boolean isvalidDestination(String destination) {
		Pattern destPattern =Pattern .compile("^[A-Za-z]{5,}$");
		Matcher destMatcher=destPattern.matcher(destination);
		return destMatcher.matches();
	}

	private boolean isvalidSource(String source) {
		
		Pattern sourcePattern =Pattern .compile("^[A-Za-z]{5,}$");
		Matcher sourceMatcher=sourcePattern.matcher(source);
		return sourceMatcher.matches();
	}

	private boolean isValidPassengerName(String passengerName) {
		Pattern passengerNamePattern =Pattern .compile("^[A-Za-z]{5,}$");
		Matcher passengerNameMatcher=passengerNamePattern.matcher(passengerName);
		return passengerNameMatcher.matches();
		
	}
		
	}


