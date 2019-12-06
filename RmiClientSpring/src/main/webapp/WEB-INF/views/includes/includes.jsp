<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ page session="true" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String locale =(session.getAttribute("local")==null)? "fr_FR": session.getAttribute("local").toString();
	
	if(session.getAttribute("login")==null){
		//response.sendRedirect("index.jsp");
		//return;
		//request.getRequestDispatcher( "index.jsp" ).forward( request, response );
	}
	
	Date today = null;
	Date createdAt = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	today = sdf.parse((new Date()).toString());
	int diff=today.getDay()-createdAt.getDay(); 

%>
<c:set var="baseURL" value="${pageContext.request.contextPath}" />
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:bundle basename="i18n.ApplicationBundle"/>