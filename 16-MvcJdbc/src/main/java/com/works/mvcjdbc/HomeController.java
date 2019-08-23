package com.works.mvcjdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import util.DB;
import util.Product;

@Controller
public class HomeController {

	DB db = new DB();

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("ls", dataResult());
		return "home";
	}
	

	// /addProduct
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	public String addProduct( Product pro, Model model ) {
		if(pro.getPprice() == null) {
			model.addAttribute("error", "Lütfen ondalıklı değer giriniz.");
			return "redirect:/";
		}
		try {
			String query = "insert into product values(null, ?, ?, ?, ?)";
			PreparedStatement pre = db.connect(query);
			pre.setString(1, pro.getPtitle());
			pre.setString(2, pro.getPdesc());
			pre.setString(3, pro.getPphoto());
			pre.setDouble(4, pro.getPprice());
			pre.executeUpdate();
			
		} catch (Exception e) {
			System.err.println("insert error : " + e);
		}
		
		return "redirect:/";
	}
	
	
	
	// dataResult
	private List<Product> dataResult() {
		List<Product> ls = new ArrayList<Product>();
		try {
			String query = "select * from product";
			PreparedStatement pre = db.connect(query);
			ResultSet rs = pre.executeQuery();
			while(rs.next()) {
				Product pr = new Product();
				pr.setPid(rs.getInt("pid"));
				pr.setPtitle(rs.getString("ptitle"));
				pr.setPdesc(rs.getString("pdesc"));
				pr.setPphoto(rs.getString("pphoto"));
				pr.setPprice(rs.getDouble("pprice"));
				ls.add(pr);
			}
		} catch (Exception e) {
			System.err.println("Data Result Error : " + e);
		}
		return ls;
	}
	
	
	// delete item
	@RequestMapping(value = "/deleteItem/{pid}", method = RequestMethod.GET)
	public String deleteItem(@PathVariable int pid) {
		System.out.println("pid : " + pid);
		try {
			String query = "delete from product where pid = ?";
			PreparedStatement pre = db.connect(query);
			pre.setInt(1, pid);
			pre.executeUpdate();
		} catch (Exception e) {
			System.err.println("delete error : " + e);
		}
		return "redirect:/";
	}
	
	
	int pid = 0;
	// update first
	@RequestMapping(value = "/updateItem/{pid}", method = RequestMethod.GET)
	public String updateItem(Model model, @PathVariable int pid) {
		List<Product> ls = dataResult();
		this.pid = pid;
		for (Product item : ls) {
			if(item.getPid() == pid) {
				model.addAttribute("pr", item);
				break;
			}
		}
		
		model.addAttribute("ls", ls);
		return "home";
	}
	
	
	// updateProduct -> save
	@RequestMapping(value = "/updateProduct", method = RequestMethod.POST)
	public String updateProduct(Product pr) {
		try {
			String query = "update product set ptitle = ?, pdesc = ?, pprice = ?, pphoto = ? where pid = ?";
			PreparedStatement pre = db.connect(query);
			pre.setString(1, pr.getPtitle());
			pre.setString(2, pr.getPdesc());
			pre.setDouble(3, pr.getPprice());
			pre.setString(4, pr.getPphoto());
			pre.setInt(5, pid);
			pre.executeUpdate();
		} catch (Exception e) {
			System.err.println("update err : " + e);
		}
		return "redirect:/";
	}
	
	
	
	

}
