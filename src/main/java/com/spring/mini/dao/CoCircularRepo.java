package com.spring.mini.dao;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.spring.mini.model.CoCircular;

@Repository
public interface CoCircularRepo extends JpaRepository<CoCircular,Long>{
	@Query("SELECT s FROM CoCircular s WHERE s.rollNo = :rollNo")
	List<CoCircular> findByRollNo(String rollNo);
}
