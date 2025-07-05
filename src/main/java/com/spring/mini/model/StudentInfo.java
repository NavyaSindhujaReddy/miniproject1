package com.spring.mini.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
@Entity
@Table(name="StudentInfo")
public class StudentInfo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable=false)
	private String name;
	@Column(nullable=false)
	private String department;
	@Column(nullable=false)
	private String rollNo;
	@Column(nullable=false)
	private String contactNo;
	@Column(nullable=false)
	private String emailId;
	@Lob
	@Column(name="stuimage",columnDefinition = "MEDIUMBLOB")
	private byte[] stuimage;
	@Column(nullable=false)
	private String aboutStudent;
	@Column(nullable=false)
	private Float sem1;
	@Column(nullable=false)
	private Float sem2;
	@Column(nullable=false)
	private Float sem3;
	@Column(nullable=false)
	private Float sem4;
	@Column(nullable=false)
	private Float sem5;
	@Column(nullable=false)
	private Float sem6;
	@Column(nullable=false)
	private Float sem7;
	@Column
	private Float cgpa;
	@Column
	private String hodremark;
	private int flag;
	private int flag1;
	private int p1f;
	private int p2f;
	private int p3f;
	private int p4f;
	private int p5f;
	private int p6f;
	private int save;
	private int submit;
	private int interview;
	private String signhod;
	private Date date;
	public StudentInfo() {
		super();
		
	}
	public StudentInfo(long id, String name, String department, String rollNo, String contactNo, String emailId,
			byte[] stuimage, String aboutStudent, Float sem1, Float sem2, Float sem3, Float sem4, Float sem5,
			Float sem6, Float sem7, Float cgpa) {
		super();
		this.id = id;
		this.name = name;
		this.department = department;
		this.rollNo = rollNo;
		this.contactNo = contactNo;
		this.emailId = emailId;
		this.stuimage = stuimage;
		this.aboutStudent = aboutStudent;
		this.sem1 = sem1;
		this.sem2 = sem2;
		this.sem3 = sem3;
		this.sem4 = sem4;
		this.sem5 = sem5;
		this.sem6 = sem6;
		this.sem7 = sem7;
		this.cgpa = cgpa;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getRollNo() {
		return rollNo;
	}
	public void setRollNo(String rollNo) {
		this.rollNo = rollNo;
	}
	public String getContactNo() {
		return contactNo;
	}
	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public byte[] getStuimage() {
		return stuimage;
	}
	public void setStuimage(byte[] stuimage) {
		this.stuimage = stuimage;
	}
	public String getAboutStudent() {
		return aboutStudent;
	}
	public void setAboutStudent(String aboutStudent) {
		this.aboutStudent = aboutStudent;
	}
	public Float getSem1() {
		return sem1;
	}
	public void setSem1(Float sem1) {
		this.sem1 = sem1;
	}
	public Float getSem2() {
		return sem2;
	}
	public void setSem2(Float sem2) {
		this.sem2 = sem2;
	}
	public Float getSem3() {
		return sem3;
	}
	public void setSem3(Float sem3) {
		this.sem3 = sem3;
	}
	public Float getSem4() {
		return sem4;
	}
	public void setSem4(Float sem4) {
		this.sem4 = sem4;
	}
	public Float getSem5() {
		return sem5;
	}
	public void setSem5(Float sem5) {
		this.sem5 = sem5;
	}
	public Float getSem6() {
		return sem6;
	}
	public void setSem6(Float sem6) {
		this.sem6 = sem6;
	}
	public Float getSem7() {
		return sem7;
	}
	public void setSem7(Float sem7) {
		this.sem7 = sem7;
	}
	public Float getCgpa() {
		return cgpa;
	}
	public void setCgpa(Float cgpa) {
		this.cgpa = cgpa;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public String getHodremark() {
		return hodremark;
	}
	public void setHodremark(String hodremark) {
		this.hodremark = hodremark;
	}
	public int getFlag1() {
		return flag1;
	}
	public void setFlag1(int flag1) {
		this.flag1 = flag1;
	}
	public int getSave() {
		return save;
	}
	public void setSave(int save) {
		this.save = save;
	}
	public int getSubmit() {
		return submit;
	}
	public void setSubmit(int submit) {
		this.submit = submit;
	}
	public int getInterview() {
		return interview;
	}
	public void setInterview(int interview) {
		this.interview = interview;
	}
	public int getP1f() {
		return p1f;
	}
	public void setP1f(int p1f) {
		this.p1f = p1f;
	}
	public int getP2f() {
		return p2f;
	}
	public void setP2f(int p2f) {
		this.p2f = p2f;
	}
	public int getP3f() {
		return p3f;
	}
	public void setP3f(int p3f) {
		this.p3f = p3f;
	}
	public int getP4f() {
		return p4f;
	}
	public void setP4f(int p4f) {
		this.p4f = p4f;
	}
	public int getP5f() {
		return p5f;
	}
	public void setP5f(int p5f) {
		this.p5f = p5f;
	}
	public int getP6f() {
		return p6f;
	}
	public void setP6f(int p6f) {
		this.p6f = p6f;
	}
	public String getSignhod() {
		return signhod;
	}
	public void setSignhod(String signhod) {
		this.signhod = signhod;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}