package Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import Dao.DemanddaoImpl;
import Dao.IDemanddao;
import bean.DemandBean;

public class DemandService implements IDemand{
	IDemanddao bd  = new DemanddaoImpl();

	@Override
	public String addDemandDraftDetails(DemandBean db) throws ClassNotFoundException, IOException, SQLException {
		String transactionseq;
		transactionseq = bd.addDemandDraftDetails(db);
		return transactionseq;
	}

	@Override
	public DemandBean getDemandDraftDetails(int transactionId) throws ClassNotFoundException, IOException, SQLException {
		DemandBean db = bd.getDemandDraftDetails(transactionId);
		return db;
	}
 
	public void validateLibraryAttribute(DemandBean db) throws Exception {

		List <String> validationError  = new ArrayList<String>();
		
		if(!(isValidCustomerName(db.getCustomerName())))
		{
			
			validationError.add("\n Name should be in alphabet and minimum 2 character. ");
		}
		
		if(!(isValidInFavourOf(db.getInFavourOf())))
		{
			
			validationError.add("\n In Favour name should be in alphabet and minimum 2 characters. ");
		}
		
		if(!(isValidPhoneNumber(db.getPhoneNumber())))
		{
			validationError.add("\n Phone Number should be 10 digit. ");
		}
		
		if(!(isValidDDAmount(db.getDdAmount())))
		{
			validationError.add("\n Price should be positive. ");
		}
		
	if(!(isValidDDCommission(db.getDdCommision())))
		{
		validationError.add("\n commission should be positive. ");
	}
		
		if(!(isValidDDDescription(db.getDdDescription())))
		{
			validationError.add("\n Price should be positive. ");
		}
		
		if(!(isValidDate(db.getDateOfTransaction())))
		{
			validationError.add("\n date format should be in dd/mm/yyyy. ");
		}
		
		
		if(!(validationError.isEmpty()))
		{
			throw new Exception(validationError+" ");
		}
		

	}

	private boolean isValidDate(String dateOfTransaction) {
		Pattern apattern = Pattern.compile("^[0-3]?[0-9]/[0-3]?[0-9]/(?:[0-9]{2})?[0-9]{2}$");
		Matcher amatcher = apattern.matcher(dateOfTransaction);
		return amatcher.matches();
		
	}

	private boolean isValidDDDescription(String ddDescription) {
		Pattern apattern = Pattern.compile("^[A-Za-z]{2,}$");
		Matcher amatcher = apattern.matcher(ddDescription);
		return amatcher.matches();
	}

	private boolean isValidDDCommission(double ddCommission) {
		
		return ddCommission > 0;
	}

	private boolean isValidDDAmount(double ddAmount) {
		
		return ddAmount > 0;
	}

	private boolean isValidPhoneNumber(String phoneNumber) {
		Pattern apattern = Pattern.compile("^[6-9][0-9]{9}");
		Matcher amatcher = apattern.matcher(phoneNumber);
		return amatcher.matches();
	}

	private boolean isValidInFavourOf(String inFavourOf) {
		Pattern apattern = Pattern.compile("^[A-Za-z]{2,}$");
		Matcher amatcher = apattern.matcher(inFavourOf);
		return amatcher.matches();
	}

	private boolean isValidCustomerName(String customerName) {
		Pattern apattern = Pattern.compile("^[A-Za-z]{2,}$");
		Matcher amatcher = apattern.matcher(customerName);
		return amatcher.matches();
	}

	public boolean isValidTransactionId(String transactionId)
	{

		Pattern pattern = Pattern.compile("[0-9]{5}");
		Matcher matcher = pattern.matcher(transactionId);
		if(matcher.matches())
		{
			return true;
		}
		else
			return false;
	}
	


		
	}


