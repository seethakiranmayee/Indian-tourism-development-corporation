package com.dxc.pojos;

import java.util.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking 
{
	 @Id
	private int bookid;
    private int recognitionno;
    private String mobile;
    private int noofrooms;
    private String fromdate;
    private String todate;
    private String status;
    
    public Booking()
    {
    	
    }

	public Booking(int bookid, int recognitionno, String mobile, int noofrooms, String fromdate, String todate,
			String status) {
		super();
		this.bookid = bookid;
		this.recognitionno = recognitionno;
		this.mobile = mobile;
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

	public int getRecognitionno() {
		return recognitionno;
	}

	public void setRecognitionno(int recognitionno) {
		this.recognitionno = recognitionno;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
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
		return "Booking [bookid=" + bookid + ", recognitionno=" + recognitionno + ", mobile=" + mobile + ", noofrooms="
				+ noofrooms + ", fromdate=" + fromdate + ", todate=" + todate + ", status=" + status + "]";
	}

	
    
}
