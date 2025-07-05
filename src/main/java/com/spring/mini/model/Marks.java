package com.spring.mini.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Marks {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	@Column(unique=true)
	private String rollno;
	private String branch;
	private String StudentName;
	private float tcgpa;
	private int hm;
	private int gm;
	private int jcm;
	private int iecm;
	private int iacm;
	private int iadm;
	private int dsm;
	private int sem;
	private int pbm;
	private int moom;
	private int icm;
	private int oacm;
	private int sutm;
	private int ocw;
	private int ocp;
	private int wcm;
	private int tfc;
	private int occ;
	private int cmm;
	private int ssa;
	private int oac;
	private float cgpamarks;
	private int coc;
	private int extra;
	private float subtotal;
	private int p1;
	private int p2;
	private int p3;
	private int p4;
	private int p5;
	private int p6;
	private float interviewMarks;
	private float Total;
	private int flagm;
	public int getCoc() {
		return coc;
	}
	public void setCoc(int coc) {
		this.coc = coc;
	}
	private int exc;
	public int getExc() {
		return exc;
	}
	public void setExc(int exc) {
		this.exc = exc;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getRollno() {
		return rollno;
	}
	public void setRollno(String rollno) {
		this.rollno = rollno;
	}
	public float getTcgpa() {
		return tcgpa;
	}
	public void setTcgpa(float tcgpa) {
		this.tcgpa = tcgpa;
	}
	public int getHm() {
		return hm;
	}
	public void setHm(int hm) {
		this.hm = hm;
	}
	public int getGm() {
		return gm;
	}
	public void setGm(int gm) {
		this.gm = gm;
	}
	public int getJcm() {
		return jcm;
	}
	public void setJcm(int jcm) {
		this.jcm = jcm;
	}
	public int getIecm() {
		return iecm;
	}
	public void setIecm(int iecm) {
		this.iecm = iecm;
	}
	public int getIacm() {
		return iacm;
	}
	public void setIacm(int iacm) {
		this.iacm = iacm;
	}
	public int getIadm() {
		return iadm;
	}
	public void setIadm(int iadm) {
		this.iadm = iadm;
	}
	public int getDsm() {
		return dsm;
	}
	public void setDsm(int dsm) {
		this.dsm = dsm;
	}
	public int getSem() {
		return sem;
	}
	public void setSem(int sem) {
		this.sem = sem;
	}
	public int getPbm() {
		return pbm;
	}
	public void setPbm(int pbm) {
		this.pbm = pbm;
	}
	public int getMoom() {
		return moom;
	}
	public void setMoom(int moom) {
		this.moom = moom;
	}
	public int getIcm() {
		return icm;
	}
	public void setIcm(int icm) {
		this.icm = icm;
	}
	public int getOacm() {
		return oacm;
	}
	public void setOacm(int oacm) {
		this.oacm = oacm;
	}
	public int getSutm() {
		return sutm;
	}
	public void setSutm(int sutm) {
		this.sutm = sutm;
	}
	public int getOcw() {
		return ocw;
	}
	public void setOcw(int ocw) {
		this.ocw = ocw;
	}
	public int getOcp() {
		return ocp;
	}
	public void setOcp(int ocp) {
		this.ocp = ocp;
	}
	public int getWcm() {
		return wcm;
	}
	public void setWcm(int wcm) {
		this.wcm = wcm;
	}
	public int getTfc() {
		return tfc;
	}
	public void setTfc(int tfc) {
		this.tfc = tfc;
	}
	public int getOcc() {
		return occ;
	}
	public void setOcc(int occ) {
		this.occ = occ;
	}
	public int getCmm() {
		return cmm;
	}
	public void setCmm(int cmm) {
		this.cmm = cmm;
	}
	public int getSsa() {
		return ssa;
	}
	public void setSsa(int ssa) {
		this.ssa = ssa;
	}
	public int getOac() {
		return oac;
	}
	public void setOac(int oac) {
		this.oac = oac;
	}
	
	public String getBranch() {
		return branch;
	}
	public void setBranch(String branch) {
		this.branch = branch;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public int getExtra() {
		return extra;
	}
	public void setExtra(int extra) {
		this.extra = extra;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public Marks(long id, String rollno, float tcgpa, int hm, int gm, int jcm, int iecm, int iacm, int iadm, int dsm,
			int sem, int pbm, int moom, int icm, int oacm, int sutm, int ocw, int ocp, int wcm, int tfc, int occ,
			int cmm, int ssa, int oac) {
		super();
		this.id = id;
		this.rollno = rollno;
		this.tcgpa = tcgpa;
		this.hm = hm;
		this.gm = gm;
		this.jcm = jcm;
		this.iecm = iecm;
		this.iacm = iacm;
		this.iadm = iadm;
		this.dsm = dsm;
		this.sem = sem;
		this.pbm = pbm;
		this.moom = moom;
		this.icm = icm;
		this.oacm = oacm;
		this.sutm = sutm;
		this.ocw = ocw;
		this.ocp = ocp;
		this.wcm = wcm;
		this.tfc = tfc;
		this.occ = occ;
		this.cmm = cmm;
		this.ssa = ssa;
		this.oac = oac;
	}
	public Marks() {
		super();
	}
	public float getCgpamarks() {
		return cgpamarks;
	}
	public void setCgpamarks(float cgpamarks) {
		this.cgpamarks = cgpamarks;
	}
	public int getP1() {
		return p1;
	}
	public void setP1(int p1) {
		this.p1 = p1;
	}
	public int getP2() {
		return p2;
	}
	public void setP2(int p2) {
		this.p2 = p2;
	}
	public int getP3() {
		return p3;
	}
	public void setP3(int p3) {
		this.p3 = p3;
	}
	public int getP4() {
		return p4;
	}
	public void setP4(int p4) {
		this.p4 = p4;
	}
	public int getP5() {
		return p5;
	}
	public void setP5(int p5) {
		this.p5 = p5;
	}
	public int getP6() {
		return p6;
	}
	public void setP6(int p6) {
		this.p6 = p6;
	}
	public float getInterviewMarks() {
		return interviewMarks;
	}
	public void setInterviewMarks(float interviewMarks) {
		this.interviewMarks = interviewMarks;
	}
	public float getTotal() {
		return Total;
	}
	public void setTotal(float total) {
		Total = total;
	}
	public int getFlagm() {
		return flagm;
	}
	public void setFlagm(int flagm) {
		this.flagm = flagm;
	}
}
