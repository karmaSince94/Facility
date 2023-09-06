<%@page import="com.nuvizz.facility.dto.FacilityDTO"%>
<%@page import="java.util.List"%>
<%@page	import="com.nuvizz.facility.service.facility.FacilityServiceImpl"%>
<%@page import="org.hibernate.SessionFactory"%>
<%@page import="org.springframework.beans.factory.annotation.Autowired"%>
<%@page import="org.hibernate.Session"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View Facility Details</title>
</head>
<body>

		<a href="logout.do">LogOut</a>

	<h3 style="color: blue; font-size: 20px;">
		<spring:message code="label.welcome" />
		${user}
	</h3>
	<br>
	<h3 style="color: blue; font-size: 20px;">
		<spring:message code="label.welcome" />
		${token}
	</h3>
	<br>
	
	<form action="view.do" method="post" id="view"></form>
	<c:if test="${rName == 'Admin'}">
		<a href="registerFacilityNavigate.do">AddFacilityDetails</a>
	</c:if>
	<table border="1">
		<tr>
			
			<th>Facility Name:</th>
			<th>Facility Address 1:</th>
			<th>Facility Address 2:</th>
			<th>Facility Zip:</th>
			<th>Facility State:</th>
			<th>Facility Country:</th>
		</tr>
		<c:forEach items="${view}" var="element">
			<tr>
				
				<td>${element.f_name}</td>
				<td>${element.f_addr1}</td>
				<td>${element.f_addr2}</td>
				<td>${element.f_zip}</td>
				<td>${element.f_state}</td>
				<td>${element.f_country}</td>
				<c:if test="${rName == 'Admin'}">
					<td><a href="updateFacilityNavigate.do?id=<c:out value="${element.f_id}"/>">Update</a></td>
				</c:if>
				
			</tr>
		</c:forEach>

	</table>

	
</body>
</html>