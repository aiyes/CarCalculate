<%@ page session="false" %>
<%	
	String url = request.getContextPath() + "/login.html";
	response.sendRedirect(response.encodeURL(url));
%>