package com.spring.mini.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.spring.mini.model.Marks;
@Repository
public interface MarksRepo extends JpaRepository<Marks,Long>{
	@Query("SELECT DISTINCT m FROM Marks m ORDER BY m.subtotal")
	List<Marks> getStuInt();
	@Query("SELECT m FROM Marks m WHERE m.rollno=:roll")
	Marks getStudentMarksByRollNo(String roll);
	@Query("SELECT m FROM Marks m WHERE m.Total = (SELECT MAX(m2.Total) FROM Marks m2 WHERE m2.flagm=1)")
	List<Marks> getBOSD();
}
