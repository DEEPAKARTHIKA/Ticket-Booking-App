package com.skcet.LiveBeats.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.skcet.LiveBeats.Model.User;


public interface UserRepository extends JpaRepository<User, Long> {
	boolean existsByUserName(String userName);
	Optional<User> findByUserId(Long userId);
	void deleteByUserId(Long userId);
	
	
	
	@Query(value="select * from user",nativeQuery=true)
	List<User> findAllQuery();
}
