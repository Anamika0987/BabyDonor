package com.cg.babycare.bean;

public class BabyProduct 
{
	
	    String proName;
	    String proId;
	    double proPrice;
	    int discount;
	    
	    
	    
		public String getProName() {
			return proName;
		}
		public void setProName(String proName) {
			this.proName = proName;
		}
		public String getProId() {
			return proId;
		}
		public void setProId(String proId) {
			this.proId = proId;
		}
		public double getProPrice() {
			return proPrice;
		}
		public void setProPrice(double proPrice) {
			this.proPrice = proPrice;
		}
		public int getDiscount() {
			return discount;
		}
		public void setDiscount(int discount) {
			this.discount = discount;
		}
		@Override
		public String toString() {
			return "BabyProduct [proName=" + proName + ", proId=" + proId + ", proPrice=" + proPrice + ", discount="
					+ discount + "]";
		}
	    
	    
	
}