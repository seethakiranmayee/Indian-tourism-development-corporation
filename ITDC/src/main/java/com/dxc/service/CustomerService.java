package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dxc.dao.CustomerDao;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Hotel;

@Service
public class CustomerService 
{
	@Autowired
	CustomerDao dao=new CustomerDao();
	public boolean customerregister(Customer c)
	{
		return dao.customerregister(c);
	}
	
	public boolean customerlogin(Customer c)
	{
		return dao.customerlogin(c);
	}
	
	public List<Hotel> listofhotels()
	{
		return dao.listofhotels();
	}

	public List<Hotel> detailsofhotel(Hotel h)
	{
		return dao.detailsofhotel(h);
	}
	
	public List<Booking> bookhotel(Booking b,Hotel h,String mobile)
	{
		return dao.bookhotel(b,h,mobile);
	}
	
	public List<Booking> requestCustomer(int bookid)
	{
		return dao.requestCustomer(bookid);
	}
	public List<Booking> pastbookings(String mobile)
	{
		return dao.pastbookings(mobile);
	}
}
