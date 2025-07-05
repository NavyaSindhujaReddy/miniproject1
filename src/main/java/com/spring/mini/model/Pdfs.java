package com.spring.mini.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity
public class Pdfs {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String rollNo;
	@Lob
	@Column(name="acadfile",columnDefinition = "LONGBLOB")
	private byte[] AcadFile;
	@Lob
	@Column(name="cofile",columnDefinition = "LONGBLOB")
	private byte[] CoFile;
	@Lob
	@Column(name="extrafile",columnDefinition = "LONGBLOB")
	private byte[] ExtraFile;
	@Lob
	@Column(name="signature",columnDefinition = "MEDIUMBLOB")
	private byte[] sign;
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
	public byte[] getAcadFile() {
		return AcadFile;
	}
	public void setAcadFile(byte[] acadFile) {
		AcadFile = acadFile;
	}
	public byte[] getCoFile() {
		return CoFile;
	}
	public void setCoFile(byte[] coFile) {
		CoFile = coFile;
	}
	public byte[] getExtraFile() {
		return ExtraFile;
	}
	public void setExtraFile(byte[] extraFile) {
		ExtraFile = extraFile;
	}
	public byte[] getSign() {
		return sign;
	}
	public void setSign(byte[] sign) {
		this.sign = sign;
	}
}
