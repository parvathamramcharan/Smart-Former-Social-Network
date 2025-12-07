package com.smartfarmers.backend.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.smartfarmers.backend.entity.Post;



@Repository
public interface PostRepository  extends JpaRepository<Post,Integer>{
		//It is DAO layer(Data Access Object) , it consists of entity manager and data source will are automatically created by IoC Container
		//JpaRepository is an interface 
		//this JpaRepository will contact with data base using entity and
		// sends back to service layer(business logic layer)
		
		
		
		
		// no need to add anything as JpaRepository will give us magic methods like
		//save(), findById(), deleteById().......
}
