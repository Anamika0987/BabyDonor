package com.cg.babycare.service;

import java.io.FileNotFoundException;
import java.sql.SQLException;

import com.cg.babycare.bean.BabyHealthCare;
import com.cg.babycare.bean.BabyProduct;
import com.cg.babycare.exception.BabyCareException;

public interface IBabyService 
{
	public String addBaby(BabyHealthCare baby) throws ClassNotFoundException, FileNotFoundException, BabyCareException, SQLException;
	
	public BabyHealthCare viewBabyDetails(String babyId);
	
	public String addProduct(BabyProduct babyProduct );
	
	public BabyProduct viewBabyProduct(String proName);
	
	
	
	//public BabySittingService viewDetails(String babyId);
	
}


