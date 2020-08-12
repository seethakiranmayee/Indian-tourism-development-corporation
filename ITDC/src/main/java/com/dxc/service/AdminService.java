package com.dxc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dxc.dao.AdminDao;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Hotel;

@Service
public class AdminService 
{
	@Autowired
	AdminDao dao;

	
	 public String adminSignUp(Admin a)
	 {
		 return dao.adminSignUp(a);
	 }
	public  boolean adminlogin(Admin a) 
	{
		  return dao.adminlogin(a);
	}
	
	public boolean addhotel(Hotel h)
	{
		return dao.addhotel(h);
	}

	public List<Hotel> getlistofhotels()
	{
		return dao.getlistofhotels();
	}
	
	public List<Booking> getdailybookings()
	{
		return dao.getdailybookings();
	}
	
	public List<Booking> displayCancel()
	{
		return dao.displayCancel();
	}
	public String doneCancel()
	{
		return dao.doneCancel();
	}
}  
