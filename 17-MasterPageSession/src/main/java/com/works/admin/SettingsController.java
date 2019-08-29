package com.works.admin;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import restModel.API;
import restModel.Bilgiler;
import restModel.JsonData;
import restModel.Product;
import restModel.Services;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import util.Util;

@Controller
@RequestMapping("/admin")
public class SettingsController {

	@RequestMapping(value = "/settings", method = RequestMethod.GET)
	public String settings( HttpServletRequest req, Model model ) {
		model.addAttribute("ls", productResult());
		return Util.control(req, "settings");
	}
	
	List<Bilgiler> ls = new ArrayList<Bilgiler>();
	public List<Bilgiler> productResult() {
		Services servis = API.getClient().create(Services.class);
		Call<JsonData> dt = servis.fncProduct();
		/*
		// async
		dt.enqueue(new Callback<JsonData>() {
			
			@Override
			public void onResponse(Call<JsonData> call, Response<JsonData> response) {
				ls = response.body().getProducts().get(0).getBilgiler();
				for(Bilgiler item : ls ) {
					System.out.println(item.getProductName());
				}
			}
			
			@Override
			public void onFailure(Call<JsonData> call, Throwable t) {
				// TODO Auto-generated method stub
				
			}
		});
		*/
		try {
			ls = dt.execute().body().getProducts().get(0).getBilgiler();
		} catch (Exception e) {
			System.err.println("hata : " + e);
		}
		// sync
		return ls;
	}
	
}
