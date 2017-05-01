<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

Menu
<ul class="nav nav-pills nav-stacked">
	<li><a href="<c:url value="/bookings" />"> <spring:message
				code="bookings" /></a></li>
	<li><a href="<c:url value="/bookings//bookedTickets" />"> <spring:message
				code="ticket.return" /></a></li>
</ul>

