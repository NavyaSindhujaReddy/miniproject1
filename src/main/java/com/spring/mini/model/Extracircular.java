package com.spring.mini.model;
import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Extracircular {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String rollNo;
	private String SUTEvent;
	private String SUTPart;
	private String OCWEvent;
	private String OCWPrize;
	private String OCWPart;
	private String OCPEvent;
	private String WCEvent;
	private String WCPrize;
	private String WCPart;
	private String TFCOccassion;
	private String TFCLevel;
	private String OtherCOccassion;
	private String OtherLevel;
	private String CMAbout;
	private String SSAAbout;
	private String OtherAC;
	private String Place;
	private Date date;
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
	public String getSUTEvent() {
		return SUTEvent;
	}
	public void setSUTEvent(String sUTEvent) {
		SUTEvent = sUTEvent;
	}
	public String getSUTPart() {
		return SUTPart;
	}
	public void setSUTPart(String sUTPart) {
		SUTPart = sUTPart;
	}
	public String getOCWEvent() {
		return OCWEvent;
	}
	public void setOCWEvent(String oCWEvent) {
		OCWEvent = oCWEvent;
	}
	public String getOCWPrize() {
		return OCWPrize;
	}
	public void setOCWPrize(String oCWPrize) {
		OCWPrize = oCWPrize;
	}
	public String getOCWPart() {
		return OCWPart;
	}
	public void setOCWPart(String oCWPart) {
		OCWPart = oCWPart;
	}
	public String getOCPEvent() {
		return OCPEvent;
	}
	public void setOCPEvent(String oCPEvent) {
		OCPEvent = oCPEvent;
	}
	public String getWCEvent() {
		return WCEvent;
	}
	public void setWCEvent(String wCEvent) {
		WCEvent = wCEvent;
	}
	public String getWCPrize() {
		return WCPrize;
	}
	public void setWCPrize(String wCPrize) {
		WCPrize = wCPrize;
	}
	public String getWCPart() {
		return WCPart;
	}
	public void setWCPart(String wCPart) {
		WCPart = wCPart;
	}
	public String getTFCOccassion() {
		return TFCOccassion;
	}
	public void setTFCOccassion(String tFCOccassion) {
		TFCOccassion = tFCOccassion;
	}
	public String getTFCLevel() {
		return TFCLevel;
	}
	public void setTFCLevel(String tFCLevel) {
		TFCLevel = tFCLevel;
	}
	public String getOtherCOccassion() {
		return OtherCOccassion;
	}
	public void setOtherCOccassion(String otherCOccassion) {
		OtherCOccassion = otherCOccassion;
	}
	public String getOtherLevel() {
		return OtherLevel;
	}
	public void setOtherLevel(String otherLevel) {
		OtherLevel = otherLevel;
	}
	public String getCMAbout() {
		return CMAbout;
	}
	public void setCMAbout(String cMAbout) {
		CMAbout = cMAbout;
	}
	public String getSSAAbout() {
		return SSAAbout;
	}
	public void setSSAAbout(String sSAAbout) {
		SSAAbout = sSAAbout;
	}
	public String getOtherAC() {
		return OtherAC;
	}
	public void setOtherAC(String otherAC) {
		OtherAC = otherAC;
	}
	public String getPlace() {
		return Place;
	}
	public void setPlace(String place) {
		Place = place;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
