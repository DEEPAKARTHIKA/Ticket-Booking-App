package com.skcet.LiveBeats.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


import com.skcet.LiveBeats.Model.User;

public interface UserService {
	
   
    
    

	
	boolean addUser(User user);

	boolean deleteUser(Long userId);

	boolean updateUser(Long userId, User user);



	Page<User> getAllUser(PageRequest pageRequest);




	List<User> getUser();
	
	List<User> getQuery();
}
