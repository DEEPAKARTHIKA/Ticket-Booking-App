package com.skcet.LiveBeats.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.skcet.LiveBeats.Model.User;
import com.skcet.LiveBeats.Repository.UserRepository;

import jakarta.transaction.Transactional;


	@Service
	@Transactional  
	public class UserServiceImpl implements UserService{
		@Autowired
		private UserRepository userRepository;
		
		@Override
		public boolean addUser(User user) {
			boolean eventExists=userRepository.existsByUserName(user.getUserName());
			if(!eventExists) {
				userRepository.save(user);
				return true;
			}
			else {
				return false;
			}
		}
		
		@Override
		public List<User> getUser(){
			return userRepository.findAll();
		}
		
		@Override
		public boolean updateUser(Long userId,User user) {
			Optional<User>existingOptional=userRepository.findByUserId(userId);
			if(existingOptional.isPresent()) {
			User userExists=existingOptional.get()	;
			userExists.setUserName(user.getUserName());
			userExists.setUserEmail(user.getUserEmail());
			userExists.setUserPassword(user.getUserPassword());
			
			userRepository.save(userExists);
					return true;
			}
		else {
			return false;
		}                       
		}
		@Override
		public boolean deleteUser(Long userId) {
			  
			Optional<User> existingUserOptional = userRepository.findByUserId(userId);
			if(existingUserOptional.isPresent()) {
				userRepository.deleteByUserId(userId);
				return true;
			} else {
				return false;
			}
		}

		@Override
		public Page<User> getAllUser(PageRequest pageRequest) {
			// TODO Auto-generated method stub
			return userRepository.findAll(pageRequest);
		}

		@Override
		public List<User> getQuery() {
			// TODO Auto-generated method stub
			return userRepository.findAllQuery();
		}

		
	}


