<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page import="java.util.*" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false" %>
<%@ page session="true" %>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String locale =(session.getAttribute("local")==null)? "fr_FR": session.getAttribute("local").toString();
	
	if(session.getAttribute("user")==null){
		//response.sendRedirect(request.getContextPath()+"/");
	}
%>
<c:set var="baseURL" value="${pageContext.request.contextPath}" />
<fmt:setLocale value="${locale}" scope="session"/>
<fmt:bundle basename="i18n.ApplicationBundle"/>