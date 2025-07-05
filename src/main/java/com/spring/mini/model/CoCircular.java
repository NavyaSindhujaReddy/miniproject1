package com.spring.mini.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="CoCircular")
public class CoCircular {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String rollNo;
	private String JCName;
	private String TAAP;
	private String IecEventName;
	private String IecPlace;
	private String IecPrize;
	private String IecDetails;
	private String IacEventName;
	private String IacPrize;
	private String IacDetails;
	private String IadEventName;
	private String IadPrize;
	private String IadDetails;
	private String DseminarTopic;
	private String SemsterCR;
	private String PBMember;
	private String Moocs;
	private String IC;
	private String IcDur;
	private String OtherAC;
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
	public String getJCName() {
		return JCName;
	}
	public void setJCName(String jCName) {
		JCName = jCName;
	}
	public String getTAAP() {
		return TAAP;
	}
	public void setTAAP(String tAAP) {
		TAAP = tAAP;
	}
	public String getIecEventName() {
		return IecEventName;
	}
	public void setIecEventName(String iecEventName) {
		IecEventName = iecEventName;
	}
	public String getIecPlace() {
		return IecPlace;
	}
	public void setIecPlace(String iecPlace) {
		IecPlace = iecPlace;
	}
	public String getIecPrize() {
		return IecPrize;
	}
	public void setIecPrize(String iecPrize) {
		IecPrize = iecPrize;
	}
	public String getIecDetails() {
		return IecDetails;
	}
	public void setIecDetails(String iecDetails) {
		IecDetails = iecDetails;
	}
	public String getIacEventName() {
		return IacEventName;
	}
	public void setIacEventName(String iacEventName) {
		IacEventName = iacEventName;
	}
	public String getIacPrize() {
		return IacPrize;
	}
	public void setIacPrize(String iacPrize) {
		IacPrize = iacPrize;
	}
	public String getIacDetails() {
		return IacDetails;
	}
	public void setIacDetails(String iacDetails) {
		IacDetails = iacDetails;
	}
	public String getIadEventName() {
		return IadEventName;
	}
	public void setIadEventName(String iadEventName) {
		IadEventName = iadEventName;
	}
	public String getIadPrize() {
		return IadPrize;
	}
	public void setIadPrize(String iadPrize) {
		IadPrize = iadPrize;
	}
	public String getIadDetails() {
		return IadDetails;
	}
	public void setIadDetails(String iadDetails) {
		IadDetails = iadDetails;
	}
	public String getDseminarTopic() {
		return DseminarTopic;
	}
	public void setDseminarTopic(String dseminarTopic) {
		DseminarTopic = dseminarTopic;
	}
	public String getSemsterCR() {
		return SemsterCR;
	}
	public void setSemsterCR(String semsterCR) {
		SemsterCR = semsterCR;
	}
	public String getPBMember() {
		return PBMember;
	}
	public void setPBMember(String pBMember) {
		PBMember = pBMember;
	}
	public String getMoocs() {
		return Moocs;
	}
	public void setMoocs(String moocs) {
		Moocs = moocs;
	}
	public String getIC() {
		return IC;
	}
	public void setIC(String iC) {
		IC = iC;
	}
	public String getIcDur() {
		return IcDur;
	}
	public void setIcDur(String icDur) {
		IcDur = icDur;
	}
	public String getOtherAC() {
		return OtherAC;
	}
	public void setOtherAC(String otherAC) {
		OtherAC = otherAC;
	}	
}
