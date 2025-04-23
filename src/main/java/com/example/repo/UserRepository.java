package com.example.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

	Optional<User> findByUserEmailIDAndUserPassword(String userEmailID, String userPassword);
	@Query("SELECT COUNT(id) FROM User ")
	public long countUsers();
	List<User> findByOrderByFullNameAsc();
	List<User> findByFullNameStartingWith(String a);
	
	

	
    
}
