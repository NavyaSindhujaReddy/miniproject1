package com.spring.mini.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spring.mini.model.StudentInfo;

@Repository
public interface StudentRepo extends JpaRepository<StudentInfo,Long> {
	@Query("SELECT DISTINCT s.rollNo FROM StudentInfo s")
	String getRollNo();
	@Query("SELECT s FROM StudentInfo s WHERE s.rollNo = :rollNo")
	StudentInfo findByRollNo(String rollNo);
	@Query("SELECT s FROM StudentInfo s WHERE s.department = :branch AND s.submit= 1")
	List<StudentInfo> getStudentByDept(String branch);
	@Query("SELECT s FROM StudentInfo s WHERE s.submit= 1 AND s.flag1=1")
	List<StudentInfo> findStudent();
	@Query("SELECT s from StudentInfo s WHERE s.interview=:interview")
	List<StudentInfo> getStudentByInterview(int interview);
	@Query("SELECT s from StudentInfo s WHERE s.rollNo=:rollno")
	StudentInfo getStudent(String rollno);
}
