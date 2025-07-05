package com.spring.mini.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.spring.mini.model.Extracircular;

@Repository
public interface ExtraCircularRepo extends JpaRepository<Extracircular,Long>{
	@Query("SELECT s FROM Extracircular s WHERE s.rollNo = :rollNo")
	List<Extracircular> findByRollNo(String rollNo);
}
