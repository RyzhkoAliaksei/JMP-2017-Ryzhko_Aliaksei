<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<table id="clientsTable" border="1" cellpadding="10" cellspacing="0"
	class="table table-striped table-bordered">

	<tr>
		<th><spring:message code="booking.id" /></th>
		<th><spring:message code="booking.filmName" /></th>
		<th><spring:message code="booking.date" /></th>
		<th><spring:message code="booking.seat" /></th>
		<th><spring:message code="booking.price" /></th>
		<th></th>
	</tr>
	<tr id="${booking.id}">
		<td>${booking.id}</td>
		<td>${booking.filmName}</td>
		<fmt:formatDate value="${booking.date}" var="dateString"
			pattern="MM/dd/yyyy HH:mm" />
		<td>${dateString}</td>
		<td>${booking.seat}</td>
		<td>${booking.price}&nbsp;</td>
	</tr>
</table>

<form:form action="${action}" commandName="booking"
	modelAttribute="booking" method="POST">

	<br />
	<form:label path="client.id">
		<spring:message code="client.id" />:</form:label>
	<form:input type="number" path="client.id" />
	<br />
	<form:label path="client.firstName">
		<spring:message code="firstName" />:</form:label>
	<form:input path="client.firstName" />
	<br />
	<form:label path="client.lastName">
		<spring:message code="lastName" />:</form:label>
	<form:input path="client.lastName" />
	<br />

	<br />

	<input type="submit" value="<spring:message code="save" />" />
	<input type="reset" value="<spring:message code="cancel" />"
		onclick="window.history.back();" />

</form:form>