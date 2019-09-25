<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style2.css">
</head>
<body>
<header  id="p1">
<br>

<p id="a1">&nbsp&nbspMovie Cruiser&nbsp&nbsp&nbsp<img src="images/logo.png" height=20 width=20><a href="ShowFavorites" id="a2">Favorites</a> <a href="ShowMovieItemListCustomer" id="a3" >Movies</a>
</p>

</header>
<div>
<c:if test="${addFavoritesStatus==true}">
<h1>ItemAddedToCartSuccessfully</h1></c:if>
<p id="m1">Movies</p>
<table id="t1">
<tr>
  <th id="t11">Title</th>
  <th id="t12">Box Office</th>
  <th id="t13">Genre</th>
  <th id="t14">Has Teaser</th>
  <th id="t15">Action</th>
</tr>
<c:forEach items="${movieItemListobj}" var="list" >
<tr>
  <td id="t11">${list.title}</td>
  <td id="t12">${list.boxOffice}</td>
  <td id="t13">${list.genre}</td>
 <c:if test="${list.teaser==true}">
  <td id="t14">Yes</td>
  </c:if>
   <c:if test="${list.teaser==false}">
  <td id="t14">No</td>
  </c:if>
  <td id="t15"><a href="AddToFavorites?id=${list.id}">Add to Favorite</a></td>
</tr>
</c:forEach>
  </table>
</div>

<footer id="p3">
  
  <p id="f1">Copyright &copy 2019</p>
</footer>
</body>
</html>
