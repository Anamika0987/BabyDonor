package com.capgemini.xyz.bean;

public class Customer {
private long custId;
private String custName;
private String address;
private String mail;
public long getCustId() {
	return custId;
}
public void setCustId(long custId) {
	this.custId = custId;
}
public String getCustName() {
	return custName;
}
public void setCustName(String custName) {
	this.custName = custName;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
@Override
public String toString() {
	return "Customer [custId=" + custId + ", custName=" + custName + ", address=" + address + ", mail=" + mail
			+ ", getCustId()=" + getCustId() + ", getCustName()=" + getCustName() + ", getAddress()=" + getAddress()
			+ ", getMail()=" + getMail() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
			+ super.toString() + "]";
}


}
