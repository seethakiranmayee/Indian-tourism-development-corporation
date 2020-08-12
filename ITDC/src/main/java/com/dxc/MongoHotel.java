package com.dxc;
 
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository; 
import org.springframework.stereotype.Repository;

import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;


@Repository
public interface MongoHotel extends MongoRepository<Hotel,Integer> 
{
	public List<Hotel> findHotelByrecognitionno(int a);
	
}
