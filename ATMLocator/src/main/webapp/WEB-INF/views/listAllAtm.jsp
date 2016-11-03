<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
</head>
<body>

	<c:url value="/logout" var="logoutUrl" />
<form id="logout" action="${logoutUrl}" method="post" >
  <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
</form>
<c:if test="${pageContext.request.userPrincipal.name != null}">
	<a href="javascript:document.getElementById('logout').submit()">Logout</a>
</c:if>

<b>Listing All the ATMs - Note: This is a secured page </b>
<br>
<br>
<br>

<c:if test="${not empty atms}">
		
		<table> 
		    <tr>
			 <td><b> House Number <b></td>
			  <td><b> Street <b></td>
			   <td> <b> City <b></td>
			   <td><b> Latitude <b></td>
			   <td><b> Longitude <b></td>
			   <td><b> Type <b></td>
			</tr>
			
			<c:forEach var="atm" items="${atms}">
				 <tr>
				 <td>
				  ${atm.address.housenumber}
				  </td>
				  <td>
				  ${atm.address.street}
				  </td>
				  <td>
					${atm.address.city}
				  </td>
				  <td>
					${atm.address.geoLocation.lat}
				  </td>
				  <td>
					${atm.address.geoLocation.lng}
				  </td>
				  <td>
					${atm.type}
				  </td>
				  </tr>
			</c:forEach>
	</table>
	</c:if>
</body>
</html>