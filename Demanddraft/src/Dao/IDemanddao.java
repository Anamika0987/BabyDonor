package Dao;

import java.io.IOException;
import java.sql.SQLException;

import bean.DemandBean;

public interface IDemanddao {

	String addDemandDraftDetails(DemandBean db) throws ClassNotFoundException, IOException, SQLException;

	DemandBean getDemandDraftDetails(int transactionId) throws ClassNotFoundException, IOException, SQLException;

}
