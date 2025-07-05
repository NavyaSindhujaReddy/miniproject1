package com.spring.mini.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Academics")
public class Academics {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
   private String rollNo;
   private String hmcourseName;
   private String grCourseName;
   private int score;
   private int grrank;
   public Academics(long id, String hmcourseName, String grCourseName, int score, int grrank) {
		super();
		this.id = id;
		this.hmcourseName = hmcourseName;
		this.grCourseName = grCourseName;
		this.score = score;
		this.grrank = grrank;
	}
   public Academics() {
		super();
	}
public long getId() {
	return id;
}
public void setId(long id) {
	this.id = id;
}

public String getRollNo() {
	return rollNo;
}
public void setRollNo(String rollNo) {
	this.rollNo = rollNo;
}
public String getHmcourseName() {
	return hmcourseName;
}
public void setHmcourseName(String hmcourseName) {
	this.hmcourseName = hmcourseName;
}
public String getGrCourseName() {
	return grCourseName;
}
public void setGrCourseName(String grCourseName) {
	this.grCourseName = grCourseName;
}
public int getScore() {
	return score;
}
public void setScore(int score) {
	this.score = score;
}
public int getGrrank() {
	return grrank;
}
public void setGrrank(int grrank) {
	this.grrank = grrank;
}

}