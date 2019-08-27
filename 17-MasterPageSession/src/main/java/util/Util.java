package util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

public class Util {
	
	public static String link = "dashboard";
	
	public static String control(HttpServletRequest req, String page) {
		
		// cookie control
		if(req.getCookies() != null) {
			Cookie[] arr = req.getCookies();
			for (Cookie item : arr) {
				if(item.getName().equals("user_cookie")) {
					String aid = item.getValue();
					req.getSession().setAttribute("aid", aid);
					break;
				}
			}
		}
		
		boolean statu = req.getSession().getAttribute("aid") == null;
		if(statu) {
			return "redirect:/admin/";
		}else {
			if (page.contains("redirect:")) {
				link = page;
				return page;
			}else {
				link = page;
				return "admin/"+page;
			}
			
			
		}
	}
	
	public static String MD5(String md5) {
		   try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance("MD5");
		        byte[] array = md.digest(md5.getBytes());
		        StringBuffer sb = new StringBuffer();
		        for (int i = 0; i < array.length; ++i) {
		          sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1,3));
		       }
		        return sb.toString();
		    } catch (java.security.NoSuchAlgorithmException e) {
		}
		return null;
	}

}
