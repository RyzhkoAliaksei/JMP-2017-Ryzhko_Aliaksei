<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<link rel="stylesheet" type="text/css"
	href="<c:url value="/resources/css/header.css"/>" />
<div class="navbar navbar-default" role="navigation">
	<div align="right">
		<c:set var="currentLocale">${pageContext.response.locale}</c:set>
		<c:set var="localeCode" value="${fn:toUpperCase(currentLocale)}" />

		<c:set var="availLanguages" value="EN,RU" />
		<c:if test="${!fn:contains(availLanguages, localeCode)}">
			<c:set var="localeCode" value="EN" />
		</c:if>

		<c:forEach var="lang" items="${availLanguages}">
			<c:set var="langHTML" value="${lang}" />

			<c:if test="${lang eq localeCode}">
				<c:set var="langHTML" value="<b><u>${lang}</u></b>" />
			</c:if>

			<a href="${currentPage}?lang=${lang}">${langHTML}</a> &nbsp;
	</c:forEach>
	</div>
</div>
