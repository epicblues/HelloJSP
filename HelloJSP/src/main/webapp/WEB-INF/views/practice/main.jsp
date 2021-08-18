<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:include page="/WEB-INF/views/includes/header.jsp">
	<jsp:param value="Practice Area" name="message"/>
</jsp:include>
<%if (session.getAttribute("weaponType") == null) { %>
<form action="practice?a=sessiontest" method="post">
<label for="weapon_type">무기 종류</label>
<input name="weapon_type" type="text" id="weapon_type"/><br/>
<input type="hidden" type="date" name="register_date" value="<%= new Date()%>" />
<input type="submit" value="세션 등록"/>
</form>
<%} else { %>
<h3>WEAPON - TYPE : <%= (String)session.getAttribute("weaponType") %></h3>
<h3>REGISTERED - DATE : <%=(String)session.getAttribute("registerDate") %></h3>
<%} %>
<%@ include file="/WEB-INF/views/includes/footer.jsp" %>