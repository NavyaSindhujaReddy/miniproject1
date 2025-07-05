package com.spring.mini.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.spring.mini.model.StudentLogin;
@Repository
public interface StudentloginRepo extends JpaRepository<StudentLogin,Long>{
	@Query("Select count(*) from StudentLogin sl where sl.userName=:username")
	int getUsers(String username);
	@Query("Select password from StudentLogin sl where sl.userName=:username")
	String getUserPassword(String username);
	@Query("Select sl from StudentLogin sl where sl.userName=:username")
	StudentLogin getUser(String username);
}
