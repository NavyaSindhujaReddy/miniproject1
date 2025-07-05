package com.spring.mini;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.mini.dao.AcadRepo;
import com.spring.mini.dao.CoCircularRepo;
import com.spring.mini.dao.ExtraCircularRepo;
import com.spring.mini.dao.MarksRepo;
import com.spring.mini.dao.PDFRepo;
import com.spring.mini.dao.StudentRepo;
import com.spring.mini.model.Academics;
import com.spring.mini.model.CoCircular;
import com.spring.mini.model.Extracircular;
import com.spring.mini.model.Marks;
import com.spring.mini.model.Pdfs;
import com.spring.mini.model.StudentInfo;
@Service
public class StudentService {
	@Autowired
	StudentRepo srepo;
	@Autowired
	AcadRepo arepo;
	@Autowired
	CoCircularRepo crepo;
	@Autowired
	ExtraCircularRepo erepo;
	@Autowired
	PDFRepo prepo;
	@Autowired
	MarksRepo mrepo;
	public String getStudentRollNumbers() {
		return srepo.getRollNo();
	}
	public List<Marks> getPreInterviewStudents() {
		return mrepo.getStuInt();
	}
	public StudentInfo getStudentByRollNo(String rollNo) {
		return srepo.findByRollNo(rollNo);
	}
	public List<Academics> getStudentAcadByRollNo(String rollNum) {
		return arepo.findByRollNo(rollNum);
	}
	public List<CoCircular> getStudentCoByRollNo(String rollNum) {
		return crepo.findByRollNo(rollNum);
	}
	public List<Extracircular> getStudentExtraByRollNo(String rollNum) {
		return erepo.findByRollNo(rollNum);
	}
	public List<Pdfs> getStudentPdfsByRollNo(String rollNum) {
		return prepo.findByRollNo(rollNum);
	}
}
