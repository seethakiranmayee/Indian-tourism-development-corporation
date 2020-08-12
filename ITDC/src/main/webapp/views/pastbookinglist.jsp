<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="#CAFAFE">
<center>
<h2>LIST OF HOTELS</h2>
<table border="2" style="padding: 0px;">

<tr>

<th>BOOK ID</th>
<th>MOBILE</th>
<th>HOTEL RECOGNITION NO</th>
<th>NO OF ROOMS</th>
<th>FROM DATE</th>
<th>TO DATE</th>
<th>STATUS</th>
</tr>

<c:forEach var="s" items="${list}">
  
      <tr>
      
       <td>
      <h3><c:out value="${s.getBookid()}"></c:out></h3>
      </td>
      
 
      
      <td>
      <h3><c:out value="${s.getMobile()}"></c:out></h3>
      </td>
   
   
      <td>
      <h3><c:out value="${s.getRecognitionno()}"></c:out></h3>
      </td>
   
   
      <td>
      <h3><c:out value="${s.getNoofrooms() }"></c:out></h3>
      </td>
      
      <td>
      <h3><c:out value="${s.getFromdate()}"></c:out></h3>
      </td>
      
      
      <td>
      <h3><c:out value="${s.getTodate()}"></c:out></h3>
      </td>
      
      <td>
      <h3><c:out value="${s.getStatus()}"></c:out></h3>
      </td>
      
      </tr>
      </c:forEach>
      </table>
      </center>
</body>
</html>