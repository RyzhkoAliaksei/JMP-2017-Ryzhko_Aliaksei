<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

	<h1>
		<spring:message code="booking.new" />
	</h1>

	<form:form action="${action}" commandName="booking" modelAttribute="booking"
		method="POST">

		<br />
		<form:label path="filmName">
			<spring:message code="booking.filmName" />:</form:label>
		<form:input type="text" path="filmName" />
		<br />
<form:label path="seat">
			<spring:message code="booking.seat" />:</form:label>
		<form:input type="number" path="seat" />
		<br />
<form:label path="price">
			<spring:message code="booking.price" />:</form:label>
		<form:input type="number" path="price" />
		<br />
<form:label path="date">
			<spring:message code="booking.date" />:</form:label>
		<form:input path="date" placeholder="05/01/2017 12:00" />
		<br />

		<input type="submit" value="<spring:message code="save" />" />
		<input type="reset" value="<spring:message code="cancel" />"
			onclick="window.history.back();" />

	</form:form>