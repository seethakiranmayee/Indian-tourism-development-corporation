package com.dxc;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.dxc.pojos.Booking;

@Repository
@Service
public interface MongoBooking extends MongoRepository<Booking, String>
{

	public List<Booking> findBookingBybookid(int a);
	public List<Booking> findBookingBymobile(String b);
	public List<Booking> findBookingByrecognitionno(int b);
	public List<Booking> findBookingBystatus(String b);
	
	

}
