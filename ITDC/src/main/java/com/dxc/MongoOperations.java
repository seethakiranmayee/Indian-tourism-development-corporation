package com.dxc;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dxc.pojos.Admin;
import com.dxc.pojos.Hotel;

@Repository
public interface MongoOperations extends MongoRepository<Admin,String>
{
   
}



