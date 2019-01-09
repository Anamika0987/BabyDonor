package com.capgemini.xyz.bean;

public class Loan {
private long loanId;
private double loanAmount;
private long custId;
private int duration;
public long getLoanId() {
	return loanId;
}
public void setLoanId(long loanId) {
	this.loanId = loanId;
}
public double getLoanAmount() {
	return loanAmount;
}
public void setLoanAmount(double loanAmount) {
	this.loanAmount = loanAmount;
}
public long getCustId() {
	return custId;
}
public void setCustId(long custId) {
	this.custId = custId;
}
public int getDuration() {
	return duration;
}
public void setDuration(int duration) {
	this.duration = duration;
}
@Override
public String toString() {
	return "Loan [loanId=" + loanId + ", loanAmount=" + loanAmount + ", custId=" + custId + ", duration=" + duration
			+ ", getLoanId()=" + getLoanId() + ", getLoanAmount()=" + getLoanAmount() + ", getCustId()=" + getCustId()
			+ ", getDuration()=" + getDuration() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
			+ ", toString()=" + super.toString() + "]";
}


}
