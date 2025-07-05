package com.spring.mini.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentLogin {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		@Column(unique=true)
		private String userName;
		private String name;
		private String Branch;
		private String Mail;
		private String password;
		private String contactNo;
		private Float sem1;
		private Float sem2;
		private Float sem3;
		private Float sem4;
		private Float sem5;
		private Float sem6;
		private Float sem7;
		private Float CGPA;
		private int HistoryOfBacklogs;
		private int flagl;
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public StudentLogin(long id, String userName, String password) {
			super();
			this.id = id;
			this.userName = userName;
			this.password = password;
		}
		public StudentLogin() {
			super();
		}
		public int getFlagl() {
			return flagl;
		}
		public void setFlagl(int flagl) {
			this.flagl = flagl;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getBranch() {
			return Branch;
		}
		public void setBranch(String branch) {
			Branch = branch;
		}
		public String getMail() {
			return Mail;
		}
		public void setMail(String mail) {
			Mail = mail;
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
		public Float getCGPA() {
			return CGPA;
		}
		public void setCGPA(Float cGPA) {
			CGPA = cGPA;
		}
		public int getHistoryOfBacklogs() {
			return HistoryOfBacklogs;
		}
		public void setHistoryOfBacklogs(int historyOfBacklogs) {
			HistoryOfBacklogs = historyOfBacklogs;
		}
		public String getContactNo() {
			return contactNo;
		}
		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}
}
