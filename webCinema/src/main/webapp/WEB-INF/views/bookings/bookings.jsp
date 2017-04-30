<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<h1>
	<spring:message code="bookings" />
</h1>

<a href="<c:url value="/bookings/new" />"><spring:message
		code="booking.new" /></a>

<br />
<br />
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

	<c:forEach items="${bookings}" var="booking">

		<tr id="${booking.id}">
			<td>${booking.id}</td>
			<td>${booking.filmName}</td>
			<fmt:formatDate value="${booking.date}" var="dateString"
				pattern="MM/dd/yyyy HH:mm" />
			<td>${dateString}</td>
			<td>${booking.seat}</td>
			<td>${booking.price}&nbsp;</td>
			<td><a href="<c:url value="/bookings/edit/${booking.id}" />">
					<spring:message code="edit" />
			</a> &nbsp; <a href="<c:url value="/bookings/delete/${booking.id}" />">
					<spring:message code="delete" />
			</a>&nbsp;<a
				href="<c:url value="/bookings/bookingTicket/${booking.id}" />">
					<spring:message code="booking.ticket" /></a></td>
		</tr>
	</c:forEach>
</table>

