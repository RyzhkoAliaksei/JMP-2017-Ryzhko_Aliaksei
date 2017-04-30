<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<h1>
	<spring:message code="booked.tickets" />
</h1>


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
		<th><spring:message code="client.id" /></th>
		<th><spring:message code="firstName" /></th>
		<th><spring:message code="lastName" /></th>
	</tr>

	<c:forEach items="${bookings}" var="booking">

		<tr id="${booking.id}">
			<td>${booking.id}</td>
			<td>${booking.filmName}</td>
			<fmt:formatDate value="${booking.date}" var="dateString"
				pattern="MM/dd/yyyy HH:mm" />
			<td>${dateString}</td>
			<td>${booking.seat}</td>
			<td>${booking.price}</td>
			<td>${booking.client.id}</td>
			<td>${booking.client.firstName}</td>
			<td>${booking.client.lastName}&nbsp;</td>
			<td><a
				href="<c:url value="/bookings/returnTicket/${booking.id}" />"> <spring:message
						code="ticket.return" />
			</a></td>
		</tr>
	</c:forEach>
</table>

