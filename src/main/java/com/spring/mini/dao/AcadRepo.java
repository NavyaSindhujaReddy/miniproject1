package com.spring.mini.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.mini.model.Academics;
@Repository
public interface AcadRepo extends JpaRepository<Academics,Long> {
	@Query("SELECT s FROM Academics s WHERE s.rollNo = :rollNo")
	List<Academics> findByRollNo(String rollNo);
}
