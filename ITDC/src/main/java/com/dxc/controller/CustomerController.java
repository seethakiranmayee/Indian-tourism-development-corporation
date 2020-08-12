package com.dxc.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Booking;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Hotel;
import com.dxc.service.CustomerService;

@Controller
public class CustomerController 
{
	String message="";
	Hotel h;
	@Autowired
	CustomerService service=new CustomerService();
	
	@RequestMapping("/registerpage")
	public String customerregister(@ModelAttribute Customer c,Model m,HttpSession session)
	{
		boolean b=service.customerregister(c);
			
		if(b)
		{
			
			message="CUSTOMER REGISTERED SUCCESSFULLY!!!";
			m.addAttribute("message",message);
			return "customerregisteredsuccessfully";
	
		}
		else
		{
			System.out.println("invalid page");
			message="PASSWORD AND CONFIRM PASSWORD AREN'T MATCHED";
			m.addAttribute("message",message);
			return "invalid";
		}
	}

	@RequestMapping("/customerlogin")
	public String customerlogin(@ModelAttribute Customer c,Model m,HttpSession session)
	{
		session.setAttribute("mobile", c.getMobile());
		session.setAttribute("custo", c);
		System.out.println("inside customer controller");
		boolean b=service.customerlogin(c);
		if(b)
		{
			message="successfully login!!!!";
		  m.addAttribute("message", message);
		  return "customersuccessfullylogin";
	   }
		else 
		{
			message="INVALID LOGIN!!!";
			m.addAttribute("message", message);
			return "invalid";
			
		}
	}
	
	@RequestMapping("/listofhotels")
	public String listofhotels(@ModelAttribute Hotel h,Model m,HttpSession session)
	{
		List<Hotel>list=service.listofhotels();
		session.setAttribute("hotellist", list);
		if(list.isEmpty()) 
		{
		   message="NO HOTELS FOUND!!!";
		   m.addAttribute("message", message);
		   return "nohotelfound";
		}
		else
		{
			m.addAttribute("list", list);
			return "listofhotels";
		}
	}
	
	@RequestMapping("/particularhoteldetails")
	public String detailsofhotel(@ModelAttribute Hotel h,Model m,HttpSession session)
	{
		List<Hotel>list=service.detailsofhotel(h);
		
		if(list.isEmpty()) 
		{
		   message="NO HOTELS FOUND!!!";
		   m.addAttribute("message", message);
		   return "nohotelfound";
		}
		else
		{
			m.addAttribute("list", list);
			return "detailsofhotel";
		}
	
	}
	
	@RequestMapping("/bookhotel")
	public String bookhotel(@ModelAttribute Booking b,Model m,HttpSession session)
	{
		 String mobile=(String) session.getAttribute("mobile");
	      double Amount;
		List<Hotel> list=(List<Hotel>) session.getAttribute("hotellist");
		
		for(int i=0;i<list.size();i++)
		{
		System.out.println("inside customer controller of book hotel");
		if(b.getRecognitionno()==list.get(i).getRecognitionno())
		{
			if(mobile.equals(b.getMobile()))
			{
				Amount=b.getNoofrooms()*list.get(i).getCostofroom();
				List<Booking>  b1=service.bookhotel(b, h,mobile);
				
					
		if(!(b1.isEmpty()))
		{
		System.out.println("inside if of book hotel");
		message="Successfully Booked!!!";
		m.addAttribute("message", message);
		m.addAttribute("list", b1);
		m.addAttribute("cost", Amount);
		return "successfullybooked";
		}
			
		else
		{
			message="NO AVAILABLE ROOMS!!!";
			m.addAttribute("message", message);
			return "view";
		}
			}
			else
			{
				message="INVALID CUSTOMER DETAILS";
				m.addAttribute("message", message);
				return "view";
			}
		}
		else
		{
			message="HOTEL IS NOT FOUND!!!";
			
		}
		
		}
		m.addAttribute("message", message);
		return "view";
		
	}
	
	@RequestMapping("/pastbookings")
	public String pastbookings(@ModelAttribute Booking b,Model m,HttpSession session)
	{
		Customer c=(Customer) session.getAttribute("custo");
		System.out.println(c.getMobile());
		List<Booking> list=service.pastbookings(c.getMobile());
		if(!(list.isEmpty())) 
		{
			m.addAttribute("list", list);
			return "pastbookinglist";
			
		}

		
		message="NO PAST BOOKINGS!!!";
		m.addAttribute("message", message);
		return "nohotelfound";
		
	}
	@RequestMapping("/requestcancelbooking")
	public String requestforcancellation(@RequestParam int bookid,Model m,HttpSession session)
	{
		List<Booking> blist=service.requestCustomer(bookid);
		System.out.println(blist);
		session.setAttribute("canlist", blist);
		if(!(blist.isEmpty()))
		{
		message="REQUEST SENT TO ADMIN FOR CANCELATION OF BOOKING";
		m.addAttribute("message", message);
		return "view";
		}
		else
		{
			message="INVALID BOOK ID";
			m.addAttribute("message", message);
			return "view";
		}
		
	}
	
}
