package com.dxc.pojos;

import org.springframework.data.annotation.Id; 
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hotel 
{
	@Id
	private int recognitionno;
    private String hotelname;
    private String address;
    private int totalrooms;
    private int availablerooms;
    private int costofroom;
    
   public Hotel()
   {
	
   }

   
public Hotel(int recognitionno, String hotelname, String address, int totalrooms, int availablerooms, int costofroom) {
	super();
	this.recognitionno = recognitionno;
	this.hotelname = hotelname;
	this.address = address;
	this.totalrooms = totalrooms;
	this.availablerooms = availablerooms;
	this.costofroom = costofroom;
}


public int getRecognitionno() {
	return recognitionno;
}

public void setRecognitionno(int recognitionno) {
	this.recognitionno = recognitionno;
}

public String getHotelname() {
	return hotelname;
}

public void setHotelname(String hotelname) {
	this.hotelname = hotelname;
}

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getTotalrooms() {
	return totalrooms;
}

public void setTotalrooms(int totalrooms) {
	this.totalrooms = totalrooms;
}

public int getAvailablerooms() {
	return availablerooms;
}

public void setAvailablerooms(int availablerooms) {
	this.availablerooms = availablerooms;
}

public int getCostofroom() {
	return costofroom;
}

public void setCostofroom(int costofroom) {
	this.costofroom = costofroom;
}
   
  
   
    
}
