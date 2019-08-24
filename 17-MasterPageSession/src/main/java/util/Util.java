package util;

import javax.servlet.http.HttpServletRequest;

public class Util {
	
	public static String link = "dashboard";
	
	public static String control(HttpServletRequest req, String page) {
		boolean statu = req.getSession().getAttribute("aid") == null;
		if(statu) {
			return "redirect:/admin/";
		}else {
			link = page;
			return "admin/"+page;
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
