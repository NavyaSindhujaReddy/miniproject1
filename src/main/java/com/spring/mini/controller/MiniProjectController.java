package com.spring.mini.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import com.spring.mini.StudentService;
import com.spring.mini.dao.AcadRepo;
import com.spring.mini.dao.CoCircularRepo;
import com.spring.mini.dao.ExtraCircularRepo;
import com.spring.mini.dao.MarksRepo;
import com.spring.mini.dao.PDFRepo;
import com.spring.mini.dao.StudentRepo;
import com.spring.mini.dao.StudentloginRepo;
import com.spring.mini.dao.tloginRepo;
import com.spring.mini.model.Academics;
import com.spring.mini.model.CoCircular;
import com.spring.mini.model.Extracircular;
import com.spring.mini.model.Marks;
import com.spring.mini.model.Pdfs;
import com.spring.mini.model.StudentInfo;
import com.spring.mini.model.StudentLogin;
import com.spring.mini.model.TeachersLogin;
import io.micrometer.common.util.StringUtils;
@Controller
public class MiniProjectController {
	@Autowired
	StudentService service;
	@RequestMapping("/")
	public String home() {
		return "home";
	}
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	@RequestMapping("/academics")
	public String academics() {
		return "academics";
	}
	@RequestMapping("/contact")
	public String contact() {
		return "contact";
	}
	@RequestMapping("/cocircular")
	public String cocircular() {
		return "cocircular";
	}
	@RequestMapping("/extracircular")
	public String extracircular() {
		return "extracircular";
	}
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
	@Autowired
	tloginRepo trepo;
	@Autowired
	StudentloginRepo slrepo;
	@RequestMapping("/Studentinfo")
	public ModelAndView studentInfo(HttpServletRequest request) {
		String user=request.getParameter("user");
		StudentLogin s=slrepo.getUser(user);
		ModelAndView mv=new ModelAndView();
		mv.addObject("s",s);
		mv.setViewName("Studentinfo");
		return mv;
	}
	@RequestMapping("/storeinfo")
	public ModelAndView storeInfo(HttpServletRequest request, @RequestParam("stu") MultipartFile file) throws IOException {
		String rollNo = request.getParameter("roll");
		StudentInfo s=srepo.getStudent(rollNo);
		StudentLogin sl=slrepo.getUser(rollNo);
		if(s==null)
		{
			StudentInfo si = new StudentInfo();
			si.setName(sl.getName());
		    si.setDepartment(sl.getBranch());
		    si.setRollNo(sl.getUserName());
		    si.setContactNo(sl.getPassword());
		    si.setEmailId(sl.getMail());
		    si.setFlag(0);
		    si.setFlag1(0);
		    si.setP1f(0);
		    si.setP2f(0);
		    si.setP3f(0);
		    si.setP4f(0);
		    si.setP5f(0);
		    si.setP6f(0);
		    long fileSize = file.getSize();
		    if (file!=null&&fileSize > 0)
		        	si.setStuimage(file.getBytes());
		    si.setAboutStudent(request.getParameter("txt"));
		    si.setSem1(sl.getSem1());
		    si.setSem2(sl.getSem2());
		    si.setSem3(sl.getSem3());
		    si.setSem4(sl.getSem4());
		    si.setSem5(sl.getSem5());
		    si.setSem6(sl.getSem6());
		    si.setSem7(sl.getSem7());
		    si.setCgpa(sl.getCGPA());
		    si.setInterview(0);
			srepo.save(si);
		}
		else
		{
			s.setName(sl.getName());
		    s.setDepartment(sl.getBranch());
		    s.setRollNo(sl.getUserName());
		    s.setContactNo(sl.getPassword());
		    s.setEmailId(sl.getMail());
			s.setFlag(0);
			s.setFlag1(0);
			s.setP1f(0);
			s.setP2f(0);
			s.setP3f(0);
			s.setP4f(0);
			s.setP5f(0);
			s.setP6f(0);
			long fileSize1 = file.getSize();
			if (file!=null&&fileSize1 > 0)
				s.setStuimage(file.getBytes());
			 s.setAboutStudent(request.getParameter("txt"));
			 s.setSem1(sl.getSem1());
			 s.setSem2(sl.getSem2());
			 s.setSem3(sl.getSem3());
			 s.setSem4(sl.getSem4());
			 s.setSem5(sl.getSem5());
			 s.setSem6(sl.getSem6());
			 s.setSem7(sl.getSem7());
			 s.setCgpa(sl.getCGPA());
			s.setInterview(0);
			srepo.save(s);
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",rollNo);
		mv.setViewName("academics");
		return mv;
	}
	@RequestMapping("/storeacademics")
	public ModelAndView storeAcademics(HttpServletRequest request, @RequestParam("acadfile") MultipartFile file)
			throws IOException {
		String rollNo=request.getParameter("user");
		int count1 = 0;
		int count2 = 0;
		String c1Param = request.getParameter("c1");
		String c2Param = request.getParameter("c2");

		if (StringUtils.isNotBlank(c1Param)) {
			count1 = Integer.parseInt(c1Param);
		}
		if (StringUtils.isNotBlank(c2Param)) {
			count2 = Integer.parseInt(c2Param);
		}
		int count = Math.max(count1, count2);
		for (int i = 1; i <= count; i++) {
			Academics ac = new Academics();
			ac.setRollNo(rollNo);
			ac.setHmcourseName(request.getParameter("hornorcrs" + i));
			String heecrsParam = request.getParameter("heecrs" + i);
			String heescrParam = request.getParameter("heescr" + i);
			String heernkParam = request.getParameter("heernk" + i);
			if (StringUtils.isNotBlank(heecrsParam) && StringUtils.isNotBlank(heescrParam)
					&& StringUtils.isNotBlank(heernkParam)) {
				ac.setGrCourseName(heecrsParam);
				ac.setScore(Integer.parseInt(heescrParam));
				ac.setGrrank(Integer.parseInt(heernkParam));
			}

			arepo.save(ac);
		}
		Pdfs pd = new Pdfs();
		pd.setRollNo(rollNo);
		long fileSize = file.getSize();
		if (fileSize > 0)
			pd.setAcadFile(file.getBytes());
		prepo.save(pd);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",rollNo);
		mv.setViewName("cocircular");
		return mv;
	}
	@RequestMapping("/storecocircular")
	public ModelAndView storeCo_Circular(HttpServletRequest request, @RequestParam("cofile") MultipartFile file)
			throws IOException {
		String rollNo=request.getParameter("roll");
		if ("Yes".equals(request.getParameter("cca1")) || "Yes".equals(request.getParameter("cca2"))
				|| "Yes".equals(request.getParameter("cca3")) || "Yes".equals(request.getParameter("cca4"))
				|| "Yes".equals(request.getParameter("cca5")) || "Yes".equals(request.getParameter("cca6"))
				|| "Yes".equals(request.getParameter("cca7")) || "Yes".equals(request.getParameter("cca8"))
				|| "Yes".equals(request.getParameter("cca9")) || "Yes".equals(request.getParameter("cca10"))) {
			int count = 0;
			for (int i = 1; i <= 10; i++) {
				int count1 = Integer.parseInt(request.getParameter("a" + i));
				count = Math.max(count, count1);
			}
			for (int i = 1; i <= count; i++) {
				CoCircular cc = new CoCircular();
				cc.setRollNo(rollNo);
				cc.setJCName(request.getParameter("jrname" + i));
				cc.setTAAP(request.getParameter("titauth" + i));
				cc.setIecEventName(request.getParameter("iecname" + i));
				cc.setIecPlace(request.getParameter("iecplace" + i));
				cc.setIecPrize(request.getParameter("iecprize" + i));
				cc.setIecDetails(request.getParameter("iecdetails" + i));
				cc.setIacEventName(request.getParameter("iacname" + i));
				cc.setIacPrize(request.getParameter("iacprize" + i));
				cc.setIacDetails(request.getParameter("iacdetails" + i));
				cc.setIadEventName(request.getParameter("iadname" + i));
				cc.setIadPrize(request.getParameter("iadprize" + i));
				cc.setIadDetails(request.getParameter("iaddetails" + i));
				cc.setDseminarTopic(request.getParameter("stop" + i));
				cc.setSemsterCR(request.getParameter("sem" + i));
				cc.setPBMember(request.getParameter("mdes" + i));
				cc.setMoocs(request.getParameter("modes" + i));
				cc.setIC(request.getParameter("icdes" + i));
				cc.setIcDur(request.getParameter("icdur" + i));
				cc.setOtherAC(request.getParameter("acdes" + i));
				crepo.save(cc);
			}
		}
		Pdfs pd = new Pdfs();
		pd.setRollNo(rollNo);
		long fileSize = file.getSize();
		if (fileSize > 0)
			pd.setCoFile(file.getBytes());
		prepo.save(pd);
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",rollNo);
		mv.setViewName("extracircular");
		return mv;
	}
	/*@RequestMapping("/storeextracircular")
	public ModelAndView storeExtraCircular(HttpServletRequest request, @RequestParam("extrafile") MultipartFile file1,
			@RequestParam("sigfile") MultipartFile file,@RequestParam(name = "action") String action) throws Exception {
		String rollNo=request.getParameter("roll");
		int count = 0;
		for (int i = 1; i <= 9; i++) {
			int count1 = Integer.parseInt(request.getParameter("b" + i));
			count = Math.max(count, count1);
		}
		for (int i = 1; i <= count; i++) {
			Extracircular ec = new Extracircular();
			ec.setRollNo(rollNo);
			System.out.println(request.getParameter("ocpr"+i));
			ec.setSUTEvent(request.getParameter("sutev" + i));
			ec.setSUTPart(request.getParameter("evtyp" + i));
			ec.setOCWEvent(request.getParameter("ocev" + i));
			ec.setOCWPrize(request.getParameter("ocpr" + i));
			ec.setOCWPart(request.getParameter("ocpty" + i));
			ec.setOCPEvent(request.getParameter("ocpev" + i));
			ec.setWCEvent(request.getParameter("icev" + i));
			ec.setWCPrize(request.getParameter("icpr" + i));
			ec.setWCPart(request.getParameter("icpty" + i));
			ec.setTFCOccassion(request.getParameter("teev" + i));
			ec.setTFCLevel(request.getParameter("tele" + i));
			ec.setOtherCOccassion(request.getParameter("acev" + i));
			ec.setOtherLevel(request.getParameter("acle" + i));
			ec.setCMAbout(request.getParameter("cm" + i));
			ec.setSSAAbout(request.getParameter("ssa" + i));
			ec.setOtherAC(request.getParameter("aac" + i));
			erepo.save(ec);
		}
		Extracircular ec = new Extracircular();
		ec.setRollNo(rollNo);
		ec.setPlace(request.getParameter("place"));
		String dateString = request.getParameter("date");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
		Date date = dateFormat.parse(dateString);
		ec.setDate(date);
		erepo.save(ec);
		Pdfs pd = new Pdfs();
		pd.setRollNo(rollNo);
		long fileSize = file.getSize();
		if (fileSize > 0)
			pd.setSign(file.getBytes());
		long fileSize1 = file1.getSize();
		if (fileSize1 > 0)
			pd.setExtraFile(file1.getBytes());
		prepo.save(pd);
		StudentInfo si1=srepo.findByRollNo(rollNo);
		StudentLogin sl1=slrepo.getUser(rollNo);
		if ("submit".equals(action)) {
			si1.setSubmit(1);
			sl1.setFlagl(1);
        }
		else if ("save".equals(action)) {
			sl1.setFlagl(1);
        	si1.setSave(1);
        }
		srepo.save(si1);
		slrepo.save(sl1);
		ModelAndView mv = new ModelAndView();
		StudentLogin sl=slrepo.getUser(rollNo);
		StudentInfo si=srepo.findByRollNo(rollNo);
		mv.addObject("si",si);
		mv.addObject("sl",sl);
		mv.addObject("user",rollNo);
		mv.setViewName("register");
		return mv;
	}*/

	@RequestMapping("/storeextracircular")
	public ModelAndView storeExtraCircular(HttpServletRequest request,
										   @RequestParam("extrafile") MultipartFile file1,
										   @RequestParam("sigfile") MultipartFile file,
										   @RequestParam(name = "action") String action) throws Exception {

		String rollNo = request.getParameter("roll");

		int b1 = Integer.parseInt(request.getParameter("b1"));
		int b2 = Integer.parseInt(request.getParameter("b2"));
		int b3 = Integer.parseInt(request.getParameter("b3"));
		int b4 = Integer.parseInt(request.getParameter("b4"));
		int b5 = Integer.parseInt(request.getParameter("b5"));
		int b6 = Integer.parseInt(request.getParameter("b6"));
		int b7 = Integer.parseInt(request.getParameter("b7"));
		int b8 = Integer.parseInt(request.getParameter("b8"));
		int b9 = Integer.parseInt(request.getParameter("b9"));

		// a. SUT Events
		for (int i = 1; i <= b1; i++) {
			String ev = request.getParameter("sutev" + i);
			String part = request.getParameter("evtyp" + i);
			if (ev != null && !ev.trim().isEmpty()) {
				Extracircular ec = new Extracircular();
				ec.setRollNo(rollNo);
				ec.setSUTEvent(ev);
				ec.setSUTPart(part);
				erepo.save(ec);
			}
		}

		// b. Outside College - Won
		for (int i = 1; i <= b2; i++) {
			String ev = request.getParameter("ocev" + i);
			String prize = request.getParameter("ocpr" + i);
			String part = request.getParameter("ocpty" + i);
			if (ev != null && !ev.trim().isEmpty()) {
				Extracircular ec = new Extracircular();
				ec.setRollNo(rollNo);
				ec.setOCWEvent(ev);
				ec.setOCWPrize(prize);
				ec.setOCWPart(part);
				erepo.save(ec);
			}
		}

		// b. Outside College - Participation
		for (int i = 1; i <= b3; i++) {
			String ev = request.getParameter("ocpev" + i);
			if (ev != null && !ev.trim().isEmpty()) {
				Extracircular ec = new Extracircular();
				ec.setRollNo(rollNo);
				ec.setOCPEvent(ev);
				erepo.save(ec);
			}
		}

		// c. Within College
		for (int i = 1; i <= b4; i++) {
			String ev = request.getParameter("icev" + i);
			String prize = request.getParameter("icpr" + i);
			String part = request.getParameter("icpty" + i);
			if (ev != null && !ev.trim().isEmpty()) {
				Extracircular ec = new Extracircular();
				ec.setRollNo(rollNo);
				ec.setWCEvent(ev);
				ec.setWCPrize(prize);
				ec.setWCPart(part);
				erepo.save(ec);
			}
		}

		// d. Tech Fest Coordinator
		for (int i = 1; i <= b5; i++) {
			String occ = request.getParameter("teev" + i);
			String level = request.getParameter("tele" + i);
			if (occ != null && !occ.trim().isEmpty()) {
				Extracircular ec = new Extracircular();
				ec.setRollNo(rollNo);
				ec.setTFCOccassion(occ);
				ec.setTFCLevel(level);
				erepo.save(ec);
			}
		}

		// e. Other Coordinator
		for (int i = 1; i <= b6; i++) {
			String occ = request.getParameter("acev" + i);
			String level = request.getParameter("acle" + i);
			if (occ != null && !occ.trim().isEmpty()) {
				Extracircular ec = new Extracircular();
				ec.setRollNo(rollNo);
				ec.setOtherCOccassion(occ);
				ec.setOtherLevel(level);
				erepo.save(ec);
			}
		}

		// f. Committee Member
		for (int i = 1; i <= b7; i++) {
			String about = request.getParameter("cm" + i);
			if (about != null && !about.trim().isEmpty()) {
				Extracircular ec = new Extracircular();
				ec.setRollNo(rollNo);
				ec.setCMAbout(about);
				erepo.save(ec);
			}
		}

		// g. Social Service Activity
		for (int i = 1; i <= b8; i++) {
			String about = request.getParameter("ssa" + i);
			if (about != null && !about.trim().isEmpty()) {
				Extracircular ec = new Extracircular();
				ec.setRollNo(rollNo);
				ec.setSSAAbout(about);
				erepo.save(ec);
			}
		}

		// h. Awards/Contributions
		for (int i = 1; i <= b9; i++) {
			String about = request.getParameter("aac" + i);
			if (about != null && !about.trim().isEmpty()) {
				Extracircular ec = new Extracircular();
				ec.setRollNo(rollNo);
				ec.setOtherAC(about);
				erepo.save(ec);
			}
		}

		// Save declaration (place + date)
		Extracircular ec = new Extracircular();
		ec.setRollNo(rollNo);
		ec.setPlace(request.getParameter("place"));

		String dateString = request.getParameter("date");
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.ENGLISH);
		Date date = dateFormat.parse(dateString);
		ec.setDate(date);
		erepo.save(ec);

		// Save file data
		Pdfs pd = new Pdfs();
		pd.setRollNo(rollNo);
		if (file.getSize() > 0)
			pd.setSign(file.getBytes());
		if (file1.getSize() > 0)
			pd.setExtraFile(file1.getBytes());
		prepo.save(pd);

		// Update login and student info
		StudentInfo si1 = srepo.findByRollNo(rollNo);
		StudentLogin sl1 = slrepo.getUser(rollNo);
		if ("submit".equals(action)) {
			si1.setSubmit(1);
			sl1.setFlagl(1);
		} else if ("save".equals(action)) {
			si1.setSave(1);
			sl1.setFlagl(1);
		}
		srepo.save(si1);
		slrepo.save(sl1);

		// Prepare return view
		ModelAndView mv = new ModelAndView();
		mv.addObject("si", si1);
		mv.addObject("sl", sl1);
		mv.addObject("user", rollNo);
		mv.setViewName("register");

		return mv;
	}

	@RequestMapping("/storemarks")
	 public ModelAndView storeMarks(HttpServletRequest request,@RequestParam("cgpa") float cgp)throws IOException{
        Marks m=new Marks();
        StudentInfo si=srepo.findByRollNo(request.getParameter("roll"));
		m.setRollno(request.getParameter("roll")); 
		String tcgpa=request.getParameter("tcgpa");
		String rollNo=request.getParameter("roll");
		if(tcgpa!=null)
		{
			m.setTcgpa(Float.parseFloat(tcgpa));
		}
		m.setHm(notnull(request.getParameter("hmarks")));
		m.setGm(notnull(request.getParameter("gmarks")));
		m.setJcm(notnull(request.getParameter("jcmarks")));
		m.setIecm(notnull(request.getParameter("iecmarks")));
		m.setIacm(notnull(request.getParameter("iacmarks")));
       	m.setIadm(notnull(request.getParameter("iadmarks")));
		m.setDsm(notnull(request.getParameter("dsmarks")));
		m.setSem(notnull(request.getParameter("semmarks")));
		m.setPbm(notnull(request.getParameter("pbmarks")));
		m.setMoom(notnull(request.getParameter("moomarks")));
		m.setIcm(notnull(request.getParameter("icmarks")));
		m.setOacm(notnull(request.getParameter("oacmmarks")));
		m.setSutm(notnull(request.getParameter("sutmarks")));
		m.setOcw(notnull(request.getParameter("ocwmarks")));
		m.setOcp(notnull(request.getParameter("ocpmarks")));
		m.setWcm(notnull(request.getParameter("wcmarks")));
		m.setTfc(notnull(request.getParameter("tfcmarks")));
		m.setOcc(notnull(request.getParameter("occmarks")));
		m.setCmm(notnull(request.getParameter("cmmarks")));
		m.setSsa(notnull(request.getParameter("ssamarks")));
		m.setOac(notnull(request.getParameter("oacmarks"))); 
		if (m.getTcgpa() != 0) {
	        m.setCgpamarks((cgp / m.getTcgpa())*55);
	    }
		m.setBranch(request.getParameter("branch"));
		m.setStudentName(request.getParameter("studentname"));
		m.setCoc(m.getJcm()+m.getIecm()+m.getIacm()+m.getIadm()+m.getDsm()+m.getSem()+m.getPbm()+m.getMoom()+m.getIcm()+m.getOacm());
		m.setExtra(m.getSutm()+m.getOcw()+m.getOcp()+m.getWcm()+m.getTfc()+m.getOcc()+m.getCmm()+m.getSsa()+m.getOac());
		m.setSubtotal(m.getExtra()+m.getCoc()+m.getHm()+m.getGm()+m.getCgpamarks());
		si.setFlag(1);
		mrepo.save(m);
		srepo.save(si);
		ModelAndView mv=new ModelAndView();
		List<StudentInfo> rollNumbers = srepo.findAll();
		List<Marks> preRoll=service.getPreInterviewStudents();
		List<StudentInfo> roll= srepo.getStudentByDept("CAI");
		List<StudentInfo> roll1= srepo.getStudentByDept("AIM");
		List<Marks> bos=mrepo.getBOSD();
		mv.addObject("roll",roll);
		mv.addObject("roll1",roll1);
		mv.setViewName("stuinfdisp");
		mv.addObject("user",rollNo);
		List<StudentInfo> roll3= srepo.getStudentByInterview(1);
		mv.addObject("bos",bos);
		mv.addObject("name",rollNo);
		mv.addObject("roll3",roll3);
		mv.addObject("rollNumbers", rollNumbers);
		mv.addObject("preRoll",preRoll);
		return mv;
    }
	private int notnull(String s) {
	    return s != null ? Integer.parseInt(s) : 0;
	}
	@RequestMapping("/giveremarks")
	public ModelAndView remarks(HttpServletRequest request, Model model, @RequestParam("roll") String rollNum) {
		StudentInfo sti = service.getStudentByRollNo(rollNum);
		ModelAndView mv = new ModelAndView();
		byte[] imageBytes = sti.getStuimage();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		model.addAttribute("base64Image", base64Image);
		mv.addObject("sti", sti);
		List<Academics> acad = service.getStudentAcadByRollNo(rollNum);
		mv.addObject("acad", acad);
		List<CoCircular> co = service.getStudentCoByRollNo(rollNum);
		mv.addObject("co", co);
		List<Extracircular> ex = service.getStudentExtraByRollNo(rollNum);
		mv.addObject("ex", ex);
		List<Pdfs> p = service.getStudentPdfsByRollNo(rollNum);
		for (Pdfs pdf : p) {
			byte[] acadBytes = pdf.getAcadFile();
			if (acadBytes != null) {
				String acadFile = Base64.getEncoder().encodeToString(acadBytes);
				if (acadFile != "")
					model.addAttribute("acadFile", acadFile);
			}
			byte[] coBytes = pdf.getCoFile();
			if (coBytes != null) {
				String coFile = Base64.getEncoder().encodeToString(coBytes);
				if (coFile != "")
					model.addAttribute("coFile", coFile);
			}
			byte[] extraBytes = pdf.getExtraFile();
			if (extraBytes != null) {
				String extraFile = Base64.getEncoder().encodeToString(extraBytes);
				if (extraFile != "")
					model.addAttribute("extraFile", extraFile);
			}
			byte[] signBytes = pdf.getSign();
			if (signBytes != null) {
				String signFile = Base64.getEncoder().encodeToString(signBytes);
				if (signFile != "")
					model.addAttribute("signFile", signFile);
			}
		}
		String user=request.getParameter("user");
		mv.addObject("user",user);
		mv.addObject("roll",rollNum);
		mv.setViewName("remarks");
		return mv;
	}
	@RequestMapping("/teacherlogin")
	public ModelAndView login1(HttpServletRequest request){
		ModelAndView mv = new ModelAndView();
		if ("LoshmaG".equals(request.getParameter("username")))
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			TeachersLogin t=trepo.findPassByUserName(name);
			String pass1=t.getPassword();
			if (pass.equals(pass1))
			{
				List<StudentInfo> rollNumbers = srepo.findStudent();
				List<Marks> preRoll=service.getPreInterviewStudents();
				List<StudentInfo> roll= srepo.getStudentByDept("CAI");
				List<StudentInfo> roll1= srepo.getStudentByDept("AIM");
				List<Marks> bos=mrepo.getBOSD();
				mv.addObject("roll",roll);
				mv.addObject("roll1",roll1);
				mv.setViewName("stuinfdisp");
				mv.addObject("user",name);
				List<StudentInfo> roll3= srepo.getStudentByInterview(1);
				mv.addObject("bos",bos);
				mv.addObject("roll3",roll3);
				mv.addObject("rollNumbers", rollNumbers);
				mv.addObject("preRoll",preRoll);
				return mv;
			}
			else
			{
				mv.addObject("errorMessage", "Incorrect Password!");
				mv.setViewName("login");
				return mv;
			}
		}
		else if("hod_cse".equals(request.getParameter("username")))
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			TeachersLogin t=trepo.findPassByUserName(name);
			String pass1=t.getPassword();
			if(pass.equals(pass1))
			{
				List<StudentInfo> roll= srepo.getStudentByDept("CSE");
				List<StudentInfo> roll1= srepo.getStudentByDept("CST");
				mv.addObject("roll",roll);
				mv.addObject("user",name);
				mv.addObject("roll1",roll1);
				mv.setViewName("hodremarks");
				return mv;
			}
			else
			{
				mv.addObject("errorMessage", "Incorrect Password!");
				mv.setViewName("login");
				return mv;
			}
		}
		else if("hod_ece".equals(request.getParameter("username")))
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			TeachersLogin t=trepo.findPassByUserName(name);
			String pass1=t.getPassword();
			if (pass.equals(pass1))
			{
				List<StudentInfo> roll= srepo.getStudentByDept("ECE");
				List<StudentInfo> roll1= srepo.getStudentByDept("ECT");
				mv.setViewName("hodremarks");
				mv.addObject("roll",roll);
				mv.addObject("user",name);
				mv.addObject("roll1",roll1);
				return mv;
			}
			else
			{
				mv.addObject("errorMessage", "Incorrect Password!");
				mv.setViewName("login");
				return mv;
			}
		}
		else if("hod_civil".equals(request.getParameter("username")))
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			TeachersLogin t=trepo.findPassByUserName(name);
			String pass1=t.getPassword();
			if (pass.equals(pass1))
			{
				List<StudentInfo> roll= srepo.getStudentByDept("CIVIL");
				mv.setViewName("hodremarks");
				mv.addObject("user",name);
				mv.addObject("roll",roll);
				return mv;
			}
			else
			{
				mv.addObject("errorMessage", "Incorrect Password!");
				mv.setViewName("login");
				return mv;
			}
		}
		else if("hod_eee".equals(request.getParameter("username")))
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			TeachersLogin t=trepo.findPassByUserName(name);
			String pass1=t.getPassword();
			if (pass.equals(pass1))
			{
				List<StudentInfo> roll= srepo.getStudentByDept("EEE");
				mv.setViewName("hodremarks");
				mv.addObject("roll",roll);
				mv.addObject("user",name);
				return mv;
			}
			else
			{
				mv.addObject("errorMessage", "Incorrect Password!");
				mv.setViewName("login");
				return mv;
			}
		}
		else if("hod_mech".equals(request.getParameter("username")))
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			TeachersLogin t=trepo.findPassByUserName(name);
			String pass1=t.getPassword();
			if (pass.equals(pass1))
			{
				List<StudentInfo> roll= srepo.getStudentByDept("MECH");
				mv.addObject("roll",roll);
				mv.setViewName("hodremarks");
				mv.addObject("user",name);
				return mv;
			}
			else
			{
				mv.addObject("errorMessage", "Invalid Password!");
				mv.setViewName("login");
				return mv;
			}
		}
		else if("Dean_SVEC".equals(request.getParameter("username")))
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			TeachersLogin t=trepo.findPassByUserName(name);
			String pass1=t.getPassword();
			if (pass.equals(pass1))
			{
				List<StudentInfo> roll= srepo.getStudentByInterview(1);
				mv.addObject("name",name);
				mv.addObject("roll",roll);
				mv.setViewName("interview");
				return mv;
			}
			else
			{
				mv.addObject("errorMessage", "Invalid Password!");
				mv.setViewName("login");
				return mv;
			}
		}
		else if("Principal_SVEC".equals(request.getParameter("username")))
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			TeachersLogin t=trepo.findPassByUserName(name);
			String pass1=t.getPassword();
			if (pass.equals(pass1))
			{
				List<StudentInfo> roll= srepo.getStudentByInterview(1);
				mv.addObject("roll",roll);
				mv.addObject("name",name);
				mv.setViewName("interview");
				return mv;
			}
			else
			{
				mv.addObject("errorMessage", "Invalid Password!");
				mv.setViewName("login");
				return mv;
			}
		}
		else if("TechDirector_SVEC".equals(request.getParameter("username")))
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			TeachersLogin t=trepo.findPassByUserName(name);
			String pass1=t.getPassword();
			if (pass.equals(pass1))
			{
				List<StudentInfo> roll= srepo.getStudentByInterview(1);
				mv.addObject("roll",roll);
				mv.addObject("name",name);
				mv.setViewName("interview");
				return mv;
			}
			else
			{
				mv.addObject("errorMessage", "Invalid Password!");
				mv.setViewName("login");
				return mv;
			}
		}
		else if("BSHHOD_SVEC".equals(request.getParameter("username")))
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			TeachersLogin t=trepo.findPassByUserName(name);
			String pass1=t.getPassword();
			if (pass.equals(pass1))
			{
				List<StudentInfo> roll= srepo.getStudentByInterview(1);
				mv.addObject("roll",roll);
				mv.addObject("name",name);
				mv.setViewName("interview");
				return mv;
			}
			else
			{
				mv.addObject("errorMessage", "Invalid Password!");
				mv.setViewName("login");
				return mv;
			}
		}
		else if("Panel6_SVEC".equals(request.getParameter("username")))
		{
			String name=request.getParameter("username");
			String pass=request.getParameter("password");
			TeachersLogin t=trepo.findPassByUserName(name);
			String pass1=t.getPassword();
			if (pass.equals(pass1))
			{
				List<StudentInfo> roll= srepo.getStudentByInterview(1);
				mv.addObject("roll",roll);
				mv.addObject("name",name);
				mv.setViewName("interview");
				return mv;
			}
			else
			{
				mv.addObject("errorMessage", "Invalid Password!");
				mv.setViewName("login");
				return mv;
			}
		}
		mv.addObject("errorMessage","User Not Found!");
		mv.setViewName("login");
		return mv;
	}
	@GetMapping("/getDetails")
	public ModelAndView getDetails(HttpServletRequest request, Model model, @RequestParam("roll") String rollNum) {
		StudentInfo sti = service.getStudentByRollNo(rollNum);
		ModelAndView mv = new ModelAndView();
		byte[] imageBytes = sti.getStuimage();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		model.addAttribute("base64Image", base64Image);
		mv.addObject("sti", sti);
		List<Academics> acad = service.getStudentAcadByRollNo(rollNum);
		mv.addObject("acad", acad);
		List<CoCircular> co = service.getStudentCoByRollNo(rollNum);
		mv.addObject("co", co);
		List<Extracircular> ex = service.getStudentExtraByRollNo(rollNum);
		mv.addObject("ex", ex);
		List<Pdfs> p = service.getStudentPdfsByRollNo(rollNum);
		for (Pdfs pdf : p) {
			byte[] acadBytes = pdf.getAcadFile();
			if (acadBytes != null) {
				String acadFile = Base64.getEncoder().encodeToString(acadBytes);
				if (acadFile != "")
					model.addAttribute("acadFile", acadFile);
			}
			byte[] coBytes = pdf.getCoFile();
			if (coBytes != null) {
				String coFile = Base64.getEncoder().encodeToString(coBytes);
				if (coFile != "")
					model.addAttribute("coFile", coFile);
			}
			byte[] extraBytes = pdf.getExtraFile();
			if (extraBytes != null) {
				String extraFile = Base64.getEncoder().encodeToString(extraBytes);
				if (extraFile != "")
					model.addAttribute("extraFile", extraFile);
			}
			byte[] signBytes = pdf.getSign();
			if (signBytes != null) {
				String signFile = Base64.getEncoder().encodeToString(signBytes);
				if (signFile != "")
					model.addAttribute("signFile", signFile);
			}
		}
		mv.setViewName("studetails");
		return mv;
	}
	@RequestMapping("/studentlogin")
	public ModelAndView login2(HttpServletRequest request,@RequestParam("susername") String username,@RequestParam("spassword") String password){
		String sp1=slrepo.getUserPassword(username);
		ModelAndView mv = new ModelAndView();
		if(sp1==null)
		{
			mv.addObject("emsg","User Not Found");
		}
		else
		{
			if(sp1.equals(password))
			{
				StudentLogin sl=slrepo.getUser(username);
				StudentInfo si=srepo.findByRollNo(username);
				mv.addObject("si",si);
				mv.addObject("sl",sl);
				mv.addObject("user",username);
				mv.setViewName("register");
				return mv;
			}
			else
			{
				mv.addObject("emsg","Password doesn't Match");
			}
		}
		mv.setViewName("login");
		return mv;
	}
	@RequestMapping("/storeremarks")
	public ModelAndView storeRemarks(HttpServletRequest request) throws ParseException
	{
		StudentInfo si=srepo.findByRollNo(request.getParameter("roll"));
		System.out.println(request.getParameter("roll"));
		String user=request.getParameter("user");
		ModelAndView mv=new ModelAndView();
		if ("LoshmaG".equals(request.getParameter("user")))
		{
			si.setHodremark(request.getParameter("remarkshod"));
			si.setSignhod(request.getParameter("signhod"));
			String dateString = request.getParameter("datehod");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
			Date date = dateFormat.parse(dateString);
			si.setDate(date);
			si.setFlag1(1);
			List<StudentInfo> rollNumbers = srepo.findAll();
			List<Marks> preRoll=service.getPreInterviewStudents();
			List<StudentInfo> roll= srepo.getStudentByDept("CAI");
			List<StudentInfo> roll1= srepo.getStudentByDept("AIM");
			List<Marks> bos=mrepo.getBOSD();
			mv.addObject("roll",roll);
			mv.addObject("roll1",roll1);
			mv.addObject("user",user);
			List<StudentInfo> roll3= srepo.getStudentByInterview(1);
			mv.addObject("bos",bos);
		    mv.addObject("user",user);
			mv.addObject("roll3",roll3);
			mv.addObject("rollNumbers", rollNumbers);
			mv.addObject("preRoll",preRoll);
			mv.setViewName("stuinfdisp");
		}
		else if("hod_cse".equals(request.getParameter("user")))
		{
			si.setHodremark(request.getParameter("remarkshod"));
			si.setSignhod(request.getParameter("signhod"));
			String dateString = request.getParameter("datehod");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
			Date date = dateFormat.parse(dateString);
			si.setDate(date);
			si.setFlag1(1);
            List<StudentInfo> roll= srepo.getStudentByDept("CSE");
			List<StudentInfo> roll1= srepo.getStudentByDept("CST");
			mv.addObject("roll",roll);
			 mv.addObject("user",user);
			mv.addObject("roll1",roll1);
			mv.setViewName("hodremarks");
		}
		else if("hod_ece".equals(request.getParameter("user")))
		{
			si.setHodremark(request.getParameter("remarkshod"));
			si.setSignhod(request.getParameter("signhod"));
			String dateString = request.getParameter("datehod");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
			Date date = dateFormat.parse(dateString);
			si.setDate(date);
			si.setFlag1(1);
				List<StudentInfo> roll= srepo.getStudentByDept("ECE");
				List<StudentInfo> roll1= srepo.getStudentByDept("ECT");
				mv.addObject("roll",roll);
				mv.addObject("roll1",roll1);
				 mv.addObject("user",user);
				mv.setViewName("hodremarks");
		}
		else if("hod_civil".equals(request.getParameter("user")))
		{
			si.setHodremark(request.getParameter("remarkshod"));
			si.setSignhod(request.getParameter("signhod"));
			String dateString = request.getParameter("datehod");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
			Date date = dateFormat.parse(dateString);
			si.setDate(date);
			si.setFlag1(1);
				List<StudentInfo> roll= srepo.getStudentByDept("CIVIL");
				mv.addObject("roll",roll);
				 mv.addObject("user",user);
				mv.setViewName("hodremarks");
		}
		else if("hod_eee".equals(request.getParameter("user")))
		{
			si.setHodremark(request.getParameter("remarkshod"));
			si.setSignhod(request.getParameter("signhod"));
			String dateString = request.getParameter("datehod");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
			Date date = dateFormat.parse(dateString);
			si.setDate(date);
			si.setFlag1(1);
				List<StudentInfo> roll= srepo.getStudentByDept("EEE");
				mv.addObject("roll",roll);
				 mv.addObject("user",user);
				mv.setViewName("hodremarks");
		}
		else if("hod_mech".equals(request.getParameter("user")))
		{
			si.setHodremark(request.getParameter("remarkshod"));
			si.setSignhod(request.getParameter("signhod"));
			String dateString = request.getParameter("datehod");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
			Date date = dateFormat.parse(dateString);
			si.setDate(date);
			si.setFlag1(1);
				List<StudentInfo> roll= srepo.getStudentByDept("MECH");
				mv.addObject("roll",roll);
				 mv.addObject("user",user);
				mv.setViewName("hodremarks");
		}
		srepo.save(si);
		return mv;
	}
	@RequestMapping("/changepassword")
	public ModelAndView changePassword(HttpServletRequest request)
	{
		ModelAndView mv=new ModelAndView();
		String user=request.getParameter("user");
		mv.addObject("user",user);
		mv.setViewName("changepassword");
		return mv;
	}
	@RequestMapping("/storepassword")
	public ModelAndView storePassword(HttpServletRequest request)
	{
		StudentLogin s=slrepo.getUser(request.getParameter("user"));
		String user=request.getParameter("user");
		ModelAndView mv=new ModelAndView();
		if(s!=null) {
		    if(request.getParameter("oldp").equals(s.getPassword()))
		    {
			     if(request.getParameter("newp").equals(request.getParameter("confp")))
			     {
			    	String newp=request.getParameter("newp");
				    s.setPassword(newp);
				    slrepo.save(s);
				    mv.addObject("msg","Password has been changed!!");
			     }
			     else
			     {
				    mv.addObject("msg","New Password doesn't match");
			     }
		     }
		     else
		     {
			     mv.addObject("msg","Old Password doesn't match");
		     }
		}
		else
		{
			mv.addObject("msg","User must login with their Roll No");
		}
		StudentLogin sl=slrepo.getUser(user);
		StudentInfo si=srepo.getStudent(user);
		mv.addObject("si",si);
		mv.addObject("sl",sl);
		mv.addObject("user",user);
		mv.setViewName("register");
		return mv;
	}
	@RequestMapping("/editinfo")
	public ModelAndView editInfo(HttpServletRequest request,Model model)
	{
		String user=request.getParameter("user");
		StudentInfo si=srepo.findByRollNo(user);
		StudentLogin sl=slrepo.getUser(user);
		ModelAndView mv=new ModelAndView();
		byte[] imageBytes = si.getStuimage();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		model.addAttribute("base64Image", base64Image);
		mv.addObject("si",si);
		mv.addObject("s",sl);
		mv.setViewName("studentinfoe");
		return mv;
	}
	@RequestMapping("/changeinfo")
	public ModelAndView changeInfo(HttpServletRequest request,@RequestParam("stu") MultipartFile file,Model model1) throws IOException
	{
		String rollno=request.getParameter("roll");
		StudentInfo si =srepo.findByRollNo(rollno);
		StudentLogin sl=slrepo.getUser(rollno);
		if(si!=null) {
			si.setName(sl.getName());
		    si.setDepartment(sl.getBranch());
		    si.setRollNo(sl.getUserName());
		    si.setContactNo(sl.getPassword());
		    si.setEmailId(sl.getMail());
		   long fileSize = file.getSize();
		   if (fileSize > 0)
		    	si.setStuimage(file.getBytes());
		   si.setAboutStudent(request.getParameter("txt"));
		   si.setSem1(sl.getSem1());
		    si.setSem2(sl.getSem2());
		    si.setSem3(sl.getSem3());
		    si.setSem4(sl.getSem4());
		    si.setSem5(sl.getSem5());
		    si.setSem6(sl.getSem6());
		    si.setSem7(sl.getSem7());
		    si.setCgpa(sl.getCGPA());
		   srepo.save(si);
		}
		ModelAndView mv=new ModelAndView();
		List<Academics> a=arepo.findByRollNo(rollno);
		List<Pdfs> p=service.getStudentPdfsByRollNo(rollno);
		System.out.println(p.size());
		for(Pdfs pdf : p) {
			byte[] acadBytes = pdf.getAcadFile();
			if (acadBytes!=null) {
				String acadFile=Base64.getEncoder().encodeToString(acadBytes);
				if (acadFile!= "")
					model1.addAttribute("acadFile", acadFile);
			}
		}
		mv.addObject("a",a);
		mv.addObject("rollno",rollno);
		mv.setViewName("academicse");
		return mv;
	}
	@RequestMapping("/changeacademics")
	public ModelAndView changeAcademics(HttpServletRequest request,@RequestParam("acadfile") MultipartFile file,Model model1) throws IOException
	{
		String rollno=request.getParameter("roll");
		List<Academics> a=arepo.findByRollNo(rollno);
		for(int i=0;i<a.size();i++)
		{
			int rnk=0,scr=0;
			String hm=request.getParameter("hm"+String.valueOf(a.get(i).getId()));
			String gr=request.getParameter("gr"+String.valueOf(a.get(i).getId()));
			if(StringUtils.isNotBlank(request.getParameter("scr"+String.valueOf(a.get(i).getId())))) {
				scr=Integer.parseInt(request.getParameter("scr"+String.valueOf(a.get(i).getId())));
			}
			if(StringUtils.isNotBlank(request.getParameter("rnk"+String.valueOf(a.get(i).getId())))) {
				rnk=Integer.parseInt(request.getParameter("rnk"+String.valueOf(a.get(i).getId())));
			}
			if(hm!=""||hm!=null||gr!=null||gr!=""||scr!=0||rnk!=0) {
				a.get(i).setHmcourseName(hm);
				a.get(i).setGrCourseName(gr);
				a.get(i).setGrrank(rnk);
				a.get(i).setScore(scr);
				arepo.save(a.get(i));
			}
		}
		int count1 = 0;
		int count2 = 0;
		String c1Param = request.getParameter("c1");
		String c2Param = request.getParameter("c2");
		if (StringUtils.isNotBlank(c1Param)) {
			count1 = Integer.parseInt(c1Param);
		}
		if (StringUtils.isNotBlank(c2Param)) {
			count2 = Integer.parseInt(c2Param);
		}
		int count = Math.max(count1, count2);
		for (int i = 1; i <= count; i++) {
			Academics ac = new Academics();
			ac.setRollNo(rollno);
			String hnrcrs=request.getParameter("hornorcrs" + i);
			String heecrsParam = request.getParameter("heecrs" + i);
			String heescrParam = request.getParameter("heescr" + i);
			String heernkParam = request.getParameter("heernk" + i);
			if(hnrcrs!=""||heecrsParam!=""||hnrcrs!=null||heecrsParam!=null||heescrParam!=""||heernkParam!="")
			{
				ac.setHmcourseName(hnrcrs);
				if (StringUtils.isNotBlank(heecrsParam) && StringUtils.isNotBlank(heescrParam)
						&& StringUtils.isNotBlank(heernkParam)) {
					ac.setGrCourseName(heecrsParam);
					ac.setScore(Integer.parseInt(heescrParam));
					ac.setGrrank(Integer.parseInt(heernkParam));
				}
			}
			arepo.save(ac);
		}
		List<Pdfs> p=service.getStudentPdfsByRollNo(rollno);
		for(int i=0;i<p.size();i++)
		{
			if(p.get(i).getAcadFile()!=null)
			{
				long fileSize = file.getSize();
				if (fileSize > 0) {
					p.get(i).setAcadFile(file.getBytes());
					prepo.save(p.get(i));
				}
			}
		}
		List<CoCircular> co=crepo.findByRollNo(rollno);
		List<Pdfs> p1=service.getStudentPdfsByRollNo(rollno);
		for(Pdfs pdf:p1) {
			byte[] cobytes = pdf.getCoFile();
			if (cobytes!=null) {
				String coFile=Base64.getEncoder().encodeToString(cobytes);
				if (coFile!= "")
					model1.addAttribute("coFile", coFile);
			}
		}
		ModelAndView mv=new ModelAndView();
		mv.addObject("co",co);
		mv.addObject("rollno",rollno);
		mv.setViewName("cocirculare");
		return mv;
	}
	@RequestMapping("/changecocircular")
	public ModelAndView changeCocircular(HttpServletRequest request,@RequestParam("cofile") MultipartFile file,Model model1) throws IOException
	{
		String rollno=request.getParameter("roll");
		List<CoCircular> c=crepo.findByRollNo(rollno);
		for(int i=0;i<c.size();i++)
		{
			String jc=request.getParameter("jc"+String.valueOf(c.get(i).getId()));
			String taap=request.getParameter("taap"+String.valueOf(c.get(i).getId()));
			String iecn=request.getParameter("iecn"+String.valueOf(c.get(i).getId()));
			String iecpl=request.getParameter("iecpl"+String.valueOf(c.get(i).getId()));
			String iecpr=request.getParameter("iecpr"+String.valueOf(c.get(i).getId()));
			String iecde=request.getParameter("iecde"+String.valueOf(c.get(i).getId()));
			String iacn=request.getParameter("iacn"+String.valueOf(c.get(i).getId()));
			String iacpr=request.getParameter("iacpr"+String.valueOf(c.get(i).getId()));
			String iacde=request.getParameter("iacde"+String.valueOf(c.get(i).getId()));
			String iadn=request.getParameter("iadn"+String.valueOf(c.get(i).getId()));
			String iadpr=request.getParameter("iadpr"+String.valueOf(c.get(i).getId()));
			String iadde=request.getParameter("iadde"+String.valueOf(c.get(i).getId()));
			String dst=request.getParameter("dst"+String.valueOf(c.get(i).getId()));
			String secr=request.getParameter("secr"+String.valueOf(c.get(i).getId()));
			String pbm=request.getParameter("pbm"+String.valueOf(c.get(i).getId()));
			String mooc=request.getParameter("mooc"+String.valueOf(c.get(i).getId()));
			String ic=request.getParameter("ic"+String.valueOf(c.get(i).getId()));
			String icd=request.getParameter("icd"+String.valueOf(c.get(i).getId()));
			String ac=request.getParameter("ac"+String.valueOf(c.get(i).getId()));
			if(jc!=""||taap!=""||iecn!=""||iecpl!=""||iecpr!=""||iecde!=""||iacn!=""||iacpr!=""||iacde!=""||iadn!=""||iadpr!=""||iadde!=""||dst!=""||secr!=""||pbm!=""||mooc!=""||ic!=""||icd!=""||ac!="") {
				c.get(i).setJCName(jc);
				c.get(i).setTAAP(taap);
				c.get(i).setIecEventName(iecn);
				c.get(i).setIecPlace(iecpl);
				c.get(i).setIecPrize(iecpr);
				c.get(i).setIecDetails(iecde);
				c.get(i).setIacEventName(iacn);
				c.get(i).setIacPrize(iacpr);
				c.get(i).setIacDetails(iacde);
				c.get(i).setIadEventName(iadn);
				c.get(i).setIadPrize(iadpr);
				c.get(i).setIadDetails(iadde);
				c.get(i).setDseminarTopic(dst);
				c.get(i).setSemsterCR(secr);
				c.get(i).setPBMember(pbm);
				c.get(i).setMoocs(mooc);
				c.get(i).setIC(ic);
				c.get(i).setIcDur(icd);
				c.get(i).setOtherAC(ac);
				crepo.save(c.get(i));
			}
		}
		if ("Yes".equals(request.getParameter("cca1")) || "Yes".equals(request.getParameter("cca2"))
				|| "Yes".equals(request.getParameter("cca3")) || "Yes".equals(request.getParameter("cca4"))
				|| "Yes".equals(request.getParameter("cca5")) || "Yes".equals(request.getParameter("cca6"))
				|| "Yes".equals(request.getParameter("cca7")) || "Yes".equals(request.getParameter("cca8"))
				|| "Yes".equals(request.getParameter("cca9")) || "Yes".equals(request.getParameter("cca10"))) {
			int count = 0;
			for (int i = 1; i <= 10; i++) {
				int count1 = Integer.parseInt(request.getParameter("a" + i));
				count = Math.max(count, count1);
			}
			for (int i = 1; i <= count; i++) {
				CoCircular cc = new CoCircular();
				cc.setRollNo(rollno);
				cc.setJCName(request.getParameter("jrname" + i));
				cc.setTAAP(request.getParameter("titauth" + i));
				cc.setIecEventName(request.getParameter("iecname" + i));
				cc.setIecPlace(request.getParameter("iecplace" + i));
				cc.setIecPrize(request.getParameter("iecprize" + i));
				cc.setIecDetails(request.getParameter("iecdetails" + i));
				cc.setIacEventName(request.getParameter("iacname" + i));
				cc.setIacPrize(request.getParameter("iacprize" + i));
				cc.setIacDetails(request.getParameter("iacdetails" + i));
				cc.setIadEventName(request.getParameter("iadname" + i));
				cc.setIadPrize(request.getParameter("iadprize" + i));
				cc.setIadDetails(request.getParameter("iaddetails" + i));
				cc.setDseminarTopic(request.getParameter("stop" + i));
				cc.setSemsterCR(request.getParameter("sem" + i));
				cc.setPBMember(request.getParameter("mdes" + i));
				cc.setMoocs(request.getParameter("modes" + i));
				cc.setIC(request.getParameter("icdes" + i));
				cc.setIcDur(request.getParameter("icdur" + i));
				cc.setOtherAC(request.getParameter("acdes" + i));
				crepo.save(cc);
			}
		}
		List<Pdfs> p=service.getStudentPdfsByRollNo(rollno);
		for(int i=0;i<p.size();i++)
		{
			if(p.get(i).getCoFile()!=null)
			{
				long fileSize = file.getSize();
				if (fileSize > 0) {
					p.get(i).setCoFile(file.getBytes());
					prepo.save(p.get(i));
				}
			}
		}
		List<Extracircular> ex=erepo.findByRollNo(rollno);
		List<Pdfs> p1=service.getStudentPdfsByRollNo(rollno);
		for(Pdfs pdf : p1) {
			byte[] exbytes = pdf.getExtraFile();
			if (exbytes!=null) {
				String exFile=Base64.getEncoder().encodeToString(exbytes);
				if (exFile!= "")
					model1.addAttribute("exFile", exFile);
			}
			byte[] signbytes = pdf.getSign();
			if (signbytes!=null) {
				String signFile=Base64.getEncoder().encodeToString(signbytes);
				if (signFile!= "")
					model1.addAttribute("sign", signFile);
			}
		}
		ModelAndView mv=new ModelAndView();
		mv.addObject("ex",ex);
		mv.addObject("rollno",rollno);
		mv.setViewName("extracirculare");
		return mv;
	}
	@RequestMapping("/changeextracircular")
	public ModelAndView changeExtracircular(HttpServletRequest request,@RequestParam("extrafile") MultipartFile file,@RequestParam("sigfile") MultipartFile file1,@RequestParam(name = "action") String action) throws IOException, ParseException
	{
		String rollno=request.getParameter("roll");
		List<Extracircular> ex=erepo.findByRollNo(rollno);
		int placeDate=0;
		int c=0;
		for(int i=0;i<ex.size();i++)
		{
			String suteve=request.getParameter("suteve"+String.valueOf(ex.get(i).getId()));
			String evty=request.getParameter("evtyp"+String.valueOf(ex.get(i).getId()));
			String ocweve=request.getParameter("ocweve"+String.valueOf(ex.get(i).getId()));
			String ocwpr=request.getParameter("ocwpr"+String.valueOf(ex.get(i).getId()));
			String ocwpa=request.getParameter("ocwpa"+String.valueOf(ex.get(i).getId()));
			String ocpeve=request.getParameter("ocpeve"+String.valueOf(ex.get(i).getId()));
			String wceve=request.getParameter("wceve"+String.valueOf(ex.get(i).getId()));
			String wcpr=request.getParameter("wcpr"+String.valueOf(ex.get(i).getId()));
			String wcpa=request.getParameter("wcpa"+String.valueOf(ex.get(i).getId()));
			String tfco=request.getParameter("tfco"+String.valueOf(ex.get(i).getId()));
			String tfcl=request.getParameter("tfcl"+String.valueOf(ex.get(i).getId()));
			String oco=request.getParameter("oco"+String.valueOf(ex.get(i).getId()));
			String ol=request.getParameter("ol"+String.valueOf(ex.get(i).getId()));
			String cma=request.getParameter("cma"+String.valueOf(ex.get(i).getId()));
			String ssaa=request.getParameter("ssaa"+String.valueOf(ex.get(i).getId()));
			String ac=request.getParameter("ac"+String.valueOf(ex.get(i).getId()));
			String place=request.getParameter("place");
			String dateString = request.getParameter("date");
			SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy",Locale.ENGLISH);
			System.out.println(ocwpr);
			Date date=dateFormat.parse(dateString);
			if(suteve!=""&&suteve != null||evty!=""&&evty!=null||ocweve!=""&&ocweve!=null||ocwpr!=""&&ocwpr!=null||ocwpa!=""&&ocwpa!=null||ocpeve!=""&&ocpeve!=null||wceve!=""&&wceve!=null||wcpr!=""&&wcpr!=null||wcpa!=""&&wcpa!=null||tfco!=""&&tfco!=null||tfcl!=""&&tfcl!=null||oco!=""&&oco!=null||ol!=""&&ol!=null||cma!=""&&cma!=null||ssaa!=""&&ssaa!=null||ac!=""&&ac!=null||place!=""&&place!=null)
			{
				ex.get(i).setSUTEvent(suteve);
				ex.get(i).setSUTPart(evty);
				ex.get(i).setOCWEvent(ocweve);
				ex.get(i).setOCWPrize(ocwpr);
				ex.get(i).setOCWPart(ocwpa);
				ex.get(i).setOCPEvent(ocpeve);
				ex.get(i).setWCEvent(wceve);
				ex.get(i).setWCPrize(wcpr);
				ex.get(i).setWCPart(wcpa);
				ex.get(i).setTFCOccassion(tfco);
				ex.get(i).setTFCLevel(tfcl);
				ex.get(i).setOtherCOccassion(oco);
				ex.get(i).setOtherLevel(ol);
				ex.get(i).setCMAbout(cma);
				ex.get(i).setSSAAbout(ssaa);
				ex.get(i).setOtherAC(ac);
				if(c==0&&(dateString!=""||dateString!=null)&&(place!=""||place!=null)) {
					ex.get(i).setPlace(place);
					ex.get(i).setDate(date);
					c++;
				}
			}
		}
		c=0;
		int count = 0;
		for (int i = 1; i <= 9; i++) {
			int count1 = Integer.parseInt(request.getParameter("b" + i));
			count = Math.max(count, count1);
		}
		for (int i = 1; i <= count; i++) {
			Extracircular ec = new Extracircular();
			ec.setRollNo(rollno);
			ec.setSUTEvent(request.getParameter("sutev" + i));
			ec.setSUTPart(request.getParameter("evtyp" + i));
			ec.setOCWEvent(request.getParameter("ocev" + i));
			ec.setOCWPrize(request.getParameter("ocpr" + i));
			ec.setOCWPart(request.getParameter("ocpty" + i));
			ec.setOCPEvent(request.getParameter("ocpev" + i));
			ec.setWCEvent(request.getParameter("icev" + i));
			ec.setWCPrize(request.getParameter("icpr" + i));
			ec.setWCPart(request.getParameter("icpty" + i));
			ec.setTFCOccassion(request.getParameter("teev" + i));
			ec.setTFCLevel(request.getParameter("tele" + i));
			ec.setOtherCOccassion(request.getParameter("acev" + i));
			ec.setOtherLevel(request.getParameter("acle" + i));
			ec.setCMAbout(request.getParameter("cm" + i));
			ec.setSSAAbout(request.getParameter("ssa" + i));
			ec.setOtherAC(request.getParameter("aac" + i));
			erepo.save(ec);
		}
		List<Pdfs> p=service.getStudentPdfsByRollNo(rollno);
		for(int i=0;i<p.size();i++)
		{
			if(p.get(i).getExtraFile()!=null)
			{
				long fileSize = file.getSize();
				if (fileSize > 0) {
					p.get(i).setExtraFile(file.getBytes());
					prepo.save(p.get(i));
				}
			}
			if(p.get(i).getSign()!=null)
			{
				long fileSize1=file1.getSize();
				if (fileSize1 > 0) {
					p.get(i).setSign(file1.getBytes());
					prepo.save(p.get(i));
				}

			}
		}
		System.out.println(rollno);
		StudentInfo si=srepo.findByRollNo(rollno);
		StudentLogin sl=slrepo.getUser(rollno);
		if ("submit".equals(action)) {
			si.setSubmit(1);
        }
		else if ("save".equals(action)) {
        	si.setSave(1);
        }
		srepo.save(si);
		ModelAndView mv=new ModelAndView();
		mv.addObject("sl",sl);
		mv.addObject("si",si);
		mv.addObject("user",rollno);
		mv.setViewName("Register");
		return mv;
	}
	@RequestMapping("/stuInterview")
	public ModelAndView sendToPanel(HttpServletRequest request,@RequestParam(name = "selectedStudents", required = false) List<String> selectedStudents)
	{
		if (selectedStudents != null) {
            for (String sturollno : selectedStudents) {
            	StudentInfo sint=srepo.findByRollNo(sturollno);
            	sint.setInterview(1);
            	srepo.save(sint);
            }
        }
		String user="LoshmaG";
		ModelAndView mv=new ModelAndView();
		List<StudentInfo> rollNumbers = srepo.findAll();
		List<Marks> preRoll=service.getPreInterviewStudents();
		List<StudentInfo> roll= srepo.getStudentByDept("CAI");
		List<StudentInfo> roll1= srepo.getStudentByDept("AIM");
		List<StudentInfo> roll3= srepo.getStudentByInterview(1);
		mv.addObject("roll",roll);
		mv.addObject("roll1",roll1);
		mv.addObject("rollNumbers", rollNumbers);
		mv.addObject("roll3",roll3);
		mv.addObject("user",user);
		mv.addObject("preRoll",preRoll);
		mv.setViewName("stuinfdisp");
		return mv;
	}
	@GetMapping("/getDetailsint")
	public ModelAndView getDetailsInt(HttpServletRequest request, Model model, @RequestParam("roll") String rollNum) {
		StudentInfo sti = service.getStudentByRollNo(rollNum);
		ModelAndView mv = new ModelAndView();
		byte[] imageBytes = sti.getStuimage();
		String base64Image = Base64.getEncoder().encodeToString(imageBytes);
		model.addAttribute("base64Image", base64Image);
		mv.addObject("sti", sti);
		List<Academics> acad = service.getStudentAcadByRollNo(rollNum);
		mv.addObject("acad", acad);
		List<CoCircular> co = service.getStudentCoByRollNo(rollNum);
		mv.addObject("co", co);
		List<Extracircular> ex = service.getStudentExtraByRollNo(rollNum);
		mv.addObject("ex", ex);
		List<Pdfs> p = service.getStudentPdfsByRollNo(rollNum);
		Marks m=mrepo.getStudentMarksByRollNo(rollNum);
		for (Pdfs pdf : p) {
			byte[] acadBytes = pdf.getAcadFile();
			if (acadBytes != null) {
				String acadFile = Base64.getEncoder().encodeToString(acadBytes);
				if (acadFile != "")
					model.addAttribute("acadFile", acadFile);
			}
			byte[] coBytes = pdf.getCoFile();
			if (coBytes != null) {
				String coFile = Base64.getEncoder().encodeToString(coBytes);
				if (coFile != "")
					model.addAttribute("coFile", coFile);
			}
			byte[] extraBytes = pdf.getExtraFile();
			if (extraBytes != null) {
				String extraFile = Base64.getEncoder().encodeToString(extraBytes);
				if (extraFile != "")
					model.addAttribute("extraFile", extraFile);
			}
			byte[] signBytes = pdf.getSign();
			if (signBytes != null) {
				String signFile = Base64.getEncoder().encodeToString(signBytes);
				if (signFile !="")
					model.addAttribute("signFile", signFile);
			}
		}
		String user=request.getParameter("user");
		mv.addObject("user",user);
		mv.addObject("m",m);
		mv.setViewName("interviewmarks");
		return mv;
	}
	@RequestMapping("/storeintmarks")
	public ModelAndView storeIntMarks(HttpServletRequest request)throws IOException{
		String roll=request.getParameter("roll");
		Marks m=mrepo.getStudentMarksByRollNo(roll);
		String user=request.getParameter("user");
		int marks=Integer.parseInt(request.getParameter("intmarks"));
		StudentInfo s=srepo.findByRollNo(roll);
		ModelAndView mv=new ModelAndView();
		if(user.equals("Dean_SVEC"))
		{
			m.setP1(marks);
			s.setP1f(1);
			List<StudentInfo> roll1= srepo.getStudentByInterview(1);
			mv.addObject("name",user);
			mv.addObject("roll",roll1);
			mv.setViewName("interview");
		}
		else if(user.equals("Principal_SVEC"))
		{
			m.setP2(marks);
			s.setP2f(1);
			List<StudentInfo> roll1= srepo.getStudentByInterview(1);
			mv.addObject("roll",roll1);
			mv.addObject("name",user);
			mv.setViewName("interview");
		}
		else if(user.equals("TechDirector_SVEC"))
		{
			m.setP3(marks);
			s.setP3f(1);
			List<StudentInfo> roll1= srepo.getStudentByInterview(1);
			mv.addObject("roll",roll1);
			mv.addObject("name",user);
			mv.setViewName("interview");
		}
		else if(user.equals("BSHHOD_SVEC"))
		{
			m.setP4(marks);
			s.setP4f(1);
			List<StudentInfo> roll1= srepo.getStudentByInterview(1);
			mv.addObject("roll",roll1);
			mv.addObject("name",user);
			mv.setViewName("interview");
		}
		else if(user.equals("LoshmaG"))
		{
			m.setP5(marks);
			s.setP5f(1);
			List<StudentInfo> rollNumbers = srepo.findAll();
			List<Marks> preRoll=service.getPreInterviewStudents();
			List<StudentInfo> roll1= srepo.getStudentByDept("CAI");
			List<StudentInfo> roll2= srepo.getStudentByDept("AIM");
			List<Marks> bos=mrepo.getBOSD();
			mv.addObject("roll",roll1);
			mv.addObject("roll1",roll2);
			mv.setViewName("stuinfdisp");
			mv.addObject("user",user);
			List<StudentInfo> roll3= srepo.getStudentByInterview(1);
			mv.addObject("bos",bos);
			mv.addObject("name",user);
			mv.addObject("roll3",roll3);
			mv.addObject("rollNumbers", rollNumbers);
			mv.addObject("preRoll",preRoll);
		}
		else if(user.equals("Panel6_SVEC"))
		{
			m.setP6(marks);
			s.setP6f(1);
			List<StudentInfo> roll1= srepo.getStudentByInterview(1);
			mv.addObject("roll",roll1);
			mv.addObject("name",user);
			mv.setViewName("interview");
		}
		mrepo.save(m);
		srepo.save(s);
		if(s.getP1f()==1&&s.getP2f()==1&&s.getP3f()==1&&s.getP4f()==1&&s.getP5f()==1&&s.getP6f()==1)
		{
			float mi=(m.getP1()+m.getP2()+m.getP3()+m.getP4()+m.getP5()+m.getP6())/6;
			m.setInterviewMarks(mi);
			m.setTotal(m.getSubtotal()+mi);
			m.setFlagm(1);
		}	
		mrepo.save(m);
		return mv;
	}
}