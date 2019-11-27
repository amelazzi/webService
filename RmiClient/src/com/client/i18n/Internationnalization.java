package com.client.i18n;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import javax.servlet.jsp.jstl.core.Config;

public class Internationnalization {
	
	private Internationnalization() {
		
	}
	
	public static void changeLocal(HttpServletRequest request, HttpServletResponse response, String local) {
		String locals[]=local.split("_");
		HttpSession session = request.getSession();
		Config.set( session, Config.FMT_LOCALE, new java.util.Locale(locals[0],locals[1]) );
		//request.getSession().setAttribute("javax.servlet.jsp.jstl.fmt.locale.session", "ko-KR");
	}
}
