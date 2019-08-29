package com.works.admin;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Admin;
import model.Product;
import util.HibernateUtil;
import util.Util;

@Controller
@RequestMapping("/admin")
public class DashboardController {

	SessionFactory sf = HibernateUtil.getSessionFactory();
	
	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashBoard( HttpServletRequest req, Model model ) {
		model.addAttribute("ls", dataResult());
		currencyResult();
		return Util.control(req, "dashboard");
	}
	
	
	@RequestMapping(value = "/adminInsert", method = RequestMethod.POST)
	public String adminInsert(HttpServletRequest req, Admin adm) {
		
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		adm.setApass(Util.MD5(adm.getApass()));
		long start = System.currentTimeMillis();
		System.out.println("start : " + start );
		int id =  (int) sesi.save(adm);
		System.out.println("insert id : " + id);
		tr.commit(); // işlem başarılı kayıt yap
		long end = System.currentTimeMillis();
		System.out.println("end : " + end );
		long bettwen =  end - start;
		System.out.println("bettwen : " + bettwen );
		//tr.rollback(); // işlem hatası yukarıdakileri geri al
		
		return Util.control(req, "redirect:/admin/dashboard");
	}
	
	
	
	public List<Admin> dataResult() {
		Session sesi = sf.openSession();
		List<Admin> ls = sesi.createQuery("from Admin").getResultList();
		return ls;
	}
	
	// delete admin
	@RequestMapping(value = "/deleteAdmin/{aid}")
	public String deleteAdmin(@PathVariable int aid,HttpServletRequest req) {
		
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		Admin adm = sesi.load(Admin.class, aid);
		sesi.delete(adm);
		tr.commit();
		
		return Util.control(req, "redirect:/admin/dashboard");
	}
	
	@RequestMapping(value = "/updateAdmin/{aid}")
	public String updateAdmin(@PathVariable int aid,HttpServletRequest req) {
		Session sesi = sf.openSession();
		Transaction tr = sesi.beginTransaction();
		
		Admin adm = sesi.load(Admin.class, aid);
		adm.setAname("Aziz Sancar");
		
		sesi.update(adm);
		
		tr.commit();
		return Util.control(req, "redirect:/admin/dashboard");
	}
	
	
	public void currencyResult() {
		
		try {
			String url = "https://www.tcmb.gov.tr/kurlar/today.xml";
			Document doc = Jsoup.connect(url).timeout(30000).ignoreContentType(true).get();
			Elements list = doc.select("Currency");
			for(Element item : list) {
				String CurrencyName = item.getElementsByTag("CurrencyName").text();
				System.out.println(CurrencyName);
			}
			System.out.println(doc.toString());
		} catch (Exception e) {
			System.err.println("Curency Error : " + e);
		}
		
	}
	
	
	
	
	
	
}
