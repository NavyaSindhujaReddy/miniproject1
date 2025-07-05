package com.spring.mini.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.spring.mini.model.Pdfs;
@Repository
public interface PDFRepo extends JpaRepository<Pdfs,Long>{
	@Query("SELECT s FROM Pdfs s WHERE s.rollNo = :rollNo")
	List<Pdfs> findByRollNo(String rollNo);
}
