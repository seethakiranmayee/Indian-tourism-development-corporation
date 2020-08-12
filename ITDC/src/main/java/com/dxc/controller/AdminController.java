package com.dxc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.dao.AdminDao;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Hotel;
import com.dxc.service.AdminService;
import com.dxc.service.CustomerService;

@Controller

public class AdminController 
{
	@Autowired
    AdminService service=new AdminService();
	
	
@Autowired
CustomerService service1=new CustomerService();
	
	
	String message = "";
	@RequestMapping("/home")
  public String home()
  {
	  return "home";
  }
	@RequestMapping("/signup")
	public String signup(@ModelAttribute Admin a,Model m)
	{
		String s=service.adminSignUp(a);
		m.addAttribute("message", s);
		System.out.println("from controller"+s);
		return "signupmessage";
	}
	
	@RequestMapping("/adminlogin")
	public String adminlogin(@ModelAttribute Admin a,Model m)
	{
		System.out.println();
		
		boolean b=service.adminlogin(a);
		if(b)
		{
			message="ADMIN LOGIN SUCCESSFULLY!!!";
			m.addAttribute("message",message);
			return "adminmenu";
		}
		else
		{
			message="INVALID LOGIN!!!!";
			m.addAttribute("message", message);
			return "invalid";
		}
	}
	
	@RequestMapping("/addhotel")
	public String addhotel(@ModelAttribute Hotel h,Model m)
	{
		System.out.println(h);
		boolean b=service.addhotel(h);
		if(b)
		{
		message="Hotel added successfully!!!";
		m.addAttribute("message", message);
		return "hoteladdedsuccessfully";
		}
		else
		{
			message="Hotel Already Exits!!!";
			m.addAttribute("message", message);
			return "hotelexits";
		}
	}
	
	@RequestMapping("/gethotels")
	public String getlistofhotels(Model m)
	{
		List<Hotel> list=service.getlistofhotels();
		if(list.isEmpty()) 
		{
		   message="NO HOTELS FOUND!!!";
		   m.addAttribute("message", message);
		   return "nohotelfound";
		}
		else
		{
			m.addAttribute("list", list);
			return "hotellist";
		}
	}
	
	@RequestMapping("/getdailybookings")
	public String getdailybookings(@ModelAttribute Customer c,@ModelAttribute Booking b,Model m,HttpSession session)
	{
		String name=c.getFirstname();
		String mobile=c.getMobile();
		System.out.println("daily bookings in admin controller");
		List<Booking> list=service.getdailybookings();
		session.setAttribute("list",list );
		if(list.isEmpty()) 
		{
		   message="NO BOOKINGS FOUND!!!";
		   m.addAttribute("message", message);
		   return "nohotelfound";
		}
		else
		{
			message="DAILY BOOKINGS DETAILS";
			m.addAttribute("message", message);
			m.addAttribute("list", list);
			m.addAttribute("name", name);
			m.addAttribute("mobile",mobile);
			return "dailybooklist";
		}
		
	}
	
	
	@RequestMapping("/displaycancelbooking")
	public String approveCancel(HttpSession session,Model m)
	{
		List<Booking> blist=service.displayCancel();
		if(!(blist.isEmpty()))
		{
           message="BOOKING DETAILS";
           m.addAttribute("message", message);
			m.addAttribute("list", blist);
			return "cancelbooking";
			
		}
		else
		{
			message="NO REQUEST SENT FROM CUSTOMER";
			m.addAttribute("message", message);
			return "view";
		}
        		  	
	}
	@RequestMapping("/nomoney")
	public String requestforcancellation(Model m,HttpSession session)
	{
		
		String b1=service.doneCancel();
		m.addAttribute("message", b1);
		return "view";
	}
}
