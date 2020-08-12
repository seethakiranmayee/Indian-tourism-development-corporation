
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
.GFG
{
background-color:yellow;
border:2px;
color:black;
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
<h2>${message}</h2>
  <form action="nomoney">
<table border="2" style="padding: 0px;">

<tr>

<th>BOOKING ID</th>
<th>HOTEL ID</th>
<th>MOBILE NUMBER</th>
<th>NO OF ROOMS</th>
<th>FROM DATE</th>
<th>TO DATE</th>
</tr>

<c:forEach var="s" items="${list}">
  
      <tr>
      
       <td>
      <h3><c:out value="${s.getBookid()}"></c:out></h3>
      </td>
      
     
      <td>
      <h3><c:out value="${s.getRecognitionno()}"></c:out></h3>
      </td>
      
      <td>
      <h3><c:out value="${s.getMobile()}"></c:out></h3>
      </td>
      
   
      <td>
      <h3><c:out value="${s.getNoofrooms()}"></c:out></h3>
      </td>
   
   
      <td>
      <h3><c:out value="${s.getFromdate()}"></c:out></h3>
      </td>
      <td>
      <h3><c:out value="${s.getTodate()}"></c:out></h3>
      </td>
           
      </tr>
      </c:forEach>
      </table>
    <br><br>
      <input type="submit" value="CANCEL">
      </form>
      </center>
</body>
</html>