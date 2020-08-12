<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style>
.GFG
{
background-color:green;
border:2px;
color:white;
text-align:center;
displya:inline-block;
font-size:20px;
margin:20px 30px;
text-decoration:none;
cursor:pointer;
}
</style>
</head>
<body bgcolor="#CAFAFE">
<center>
<h2>LIST OF HOTELS</h2>
<table border="2" style="padding: 0px;">

<tr>
<th>ADDRESS</th>
<th>TOTAL ROOMS</th>
<th>AVALABLE ROOMS</th>
<th>COST OF ROOM </th>
</tr>

<c:forEach var="s" items="${list}">
  
      <tr>
      
      
      <td>
      <h3><c:out value="${s.getAddress()}"></c:out></h3>
      </td>
   
   
      <td>
      <h3><c:out value="${s.getTotalrooms()}"></c:out></h3>
      </td>
   
   <td>
      <h3><c:out value="${s.getAvailablerooms()}"></c:out></h3>
      </td>
      <td>
      <h3><c:out value="${s.getCostofroom()}"></c:out></h3>
      </td>
      
      
      </tr>
      </c:forEach>
      </table>
      </center>
</body>
</html>