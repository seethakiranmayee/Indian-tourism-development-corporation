package com.dxc.pojos;

import org.springframework.data.annotation.Id;

public class CancelBooking 
{ 
	    @Id
	   private int  bookid;
	   private String firstname;
	   private String mobile;
	   private int recognitionno;
	   private int noofrooms;
	   private String fromdate;
	   private String todate;
	   private String status;
	   
	   public CancelBooking()
	   {
		   
	   }

	   
	    
	public CancelBooking(int bookid, String firstname, String mobile, int recognitionno, int noofrooms, String fromdate,
			String todate, String status) {
		super();
		this.bookid = bookid;
		this.firstname = firstname;
		this.mobile = mobile;
		this.recognitionno = recognitionno;
		this.noofrooms = noofrooms;
		this.fromdate = fromdate;
		this.todate = todate;
		this.status = status;
	}

    

	public int getBookid() {
		return bookid;
	}

	public void setBookid(int bookid) {
		this.bookid = bookid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getRecognitionno() {
		return recognitionno;
	}

	public void setRecognitionno(int recognitionno) {
		this.recognitionno = recognitionno;
	}

	public int getNoofrooms() {
		return noofrooms;
	}

	public void setNoofrooms(int noofrooms) {
		this.noofrooms = noofrooms;
	}

	public String getFromdate() {
		return fromdate;
	}

	public void setFromdate(String fromdate) {
		this.fromdate = fromdate;
	}

	public String getTodate() {
		return todate;
	}

	public void setTodate(String todate) {
		this.todate = todate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}



	@Override
	public String toString() {
		return "CancelBooking [bookid=" + bookid + ", firstname=" + firstname + ", mobile=" + mobile
				+ ", recognitionno=" + recognitionno + ", noofrooms=" + noofrooms + ", fromdate=" + fromdate
				+ ", todate=" + todate + ", status=" + status + "]";
	}

	   
	   
}
