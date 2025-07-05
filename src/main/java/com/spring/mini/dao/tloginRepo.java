package com.spring.mini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.mini.model.TeachersLogin;

@Repository
public interface tloginRepo extends JpaRepository<TeachersLogin,Long>{
	@Query("SELECT t FROM TeachersLogin t WHERE t.username = :username")
	TeachersLogin findPassByUserName(String username);
}
