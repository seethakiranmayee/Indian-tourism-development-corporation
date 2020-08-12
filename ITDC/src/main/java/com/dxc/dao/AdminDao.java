package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dxc.MongoBooking;
import com.dxc.MongoHotel;
import com.dxc.MongoOperations;
import com.dxc.pojos.Admin;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Customer;
import com.dxc.pojos.Hotel;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
@Repository
@Service
public class AdminDao 
{

	@Autowired
	MongoOperations monop;
	
	@Autowired
	MongoHotel monh;

    @Autowired
    MongoBooking monbook;
    
    public String adminSignUp(Admin a)
    {
    	monop.save(a);
    	System.out.println(a);
    	return "Admin Successfully Sign Up !!!";
    }
    
	public boolean adminlogin(Admin a) {

		List<Admin> admin = new ArrayList<>();
		admin = monop.findAll();
		System.out.println(admin.size());
		for (int i = 0; i < admin.size(); i++) {
			if (admin.get(i).getAdminname().equals(a.getAdminname())
					&& admin.get(i).getPassword().equals(a.getPassword())) {
				System.out.println("inside if case ");
				return true;
			}
		}

		return false;

	}

	public boolean addhotel(Hotel h) 
	{
		List<Hotel> hlist=new ArrayList<Hotel>();
		System.out.println("adding hotel");
		
		hlist=monh.findAll();
		if(hlist.isEmpty())
		{
			monh.save(h);
			return true;
		}
		else
		{
		for(Hotel h1:hlist)
		{
			
		if(h.getRecognitionno()==h1.getRecognitionno())
		{
			System.out.println("hotel already exits!!");
			System.out.println(hlist);
			System.out.println(h);	
		    return  false;
		}
		}
		}
			monh.save(h);
			return true;
		
	}
    
   public List<Hotel> getlistofhotels()
   {
	   List<Hotel> hlist =  new ArrayList<Hotel>();
	  hlist= monh.findAll(); 
       return hlist;
   }

   public List<Booking> getdailybookings()
   {
	   List<Booking> blist=new ArrayList<>();
	   blist=monbook.findAll();
	   return blist;
   }
   
   public List<Booking> displayCancel()
   {
	   List<Booking> b1=monbook.findBookingBystatus("requesting for cancel room");
	   return b1;
   }
   
   public String doneCancel()
   {
	   List<Booking> b1=monbook.findAll();
	   List<Hotel> h=monh.findAll();
	   for(Booking b:b1)
	   {
		   if(b.getStatus().equals("requesting for cancel room"))
		   {
			   b.setStatus("cancelled!!!");
			   monbook.save(b);
			   for(Hotel h1:h)
			   {
				   if(h1.getRecognitionno()==b.getRecognitionno())
				   {
					   
				   int finalrooms=h1.getAvailablerooms()+b.getNoofrooms();
				   h1.setAvailablerooms(finalrooms);
				   System.out.println(finalrooms);
				   monh.save(h1);
				   }
				   
			   }
			   }
			   
		   }
	   
	   
	   return "Successfully cancelled";
   }
   
}

