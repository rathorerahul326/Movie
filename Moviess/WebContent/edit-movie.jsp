<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/style1.css">
<script type="text/javascript" src="js/script.js"></script>
</head>
<body>
<header  id="p1">
<br>

<p id="a1">&nbsp&nbspMovie Cruiser&nbsp&nbsp&nbsp<img src="images/logo.png" height=20 width=20><a href="ShowMovieItemListAdmin" id="a2">Movies</a></p>

</header>
<div id="dv1">
<p id="e1">Edit Movie</p>
<form name="signup"  action="EditMovieItem?id=${movieItemobj.id}" onsubmit=" return validation()" method="post">
<table id="t2">
<tr>
   <td><label for="label1">Title</label></td>
</tr>
<tr>
<td><input id="label1" type="text" name="fname" size="68px" value="${movieItemobj.title}"></td>
</tr>
</table>
<table id="t3">
<tr>
   <td><label for="label2">Gross ($)</label></td>
   <td><label for="label3">Active</label></td>
   <td><label for="label4">Date of Launch</label></td>
   <td><lable for="label5"">Genre</label></td>
</tr>

<tr>
    <td><input id="label2" type="text" name="fprice" size="8px" value="${movieItemobj.boxOffice}"></td>
     <td><input id="label3" type="radio" value="stockPresent" <c:if test="${movieItemobj.active==true}">checked</c:if> name="inStock" >Yes
    <input type="radio" value="stockabsent" <c:if test="${movieItemobj.active==false}">checked</c:if> name="inStock">No</td>
     <fmt:formatDate pattern="dd/MM/yyyy" value="${movieItemobj.dateOfLaunch}" var="dateinformat"/>
    <td><input id="label4" type="text" name="date" value="${dateinformat}"></td>
    <td>
      <select name="category">
      
      
         <option id="label5" value="Superhero" <c:if test="${movieItemobj.genre=='Superhero'}"> selected</c:if>> Superhero</option>
         
         <option id="label5" value="Science Fiction" <c:if test="${movieItemobj.genre=='Science Fiction'}">selected</c:if>>Science Fiction</option>
         <option id="label5" value="Superhero" <c:if test="${movieItemobj.genre=='Superhero'}">selected</c:if>>Superhero</option>
         <option id="label5" value="Romance" <c:if test="${movieItemobj.genre=='Romance'}">selected</c:if>>Romance</option>
         <option id="label5" value="Comedy" <c:if test="${movieItemobj.genre=='Comedy'}">selected</c:if>>Comedy</option>
         <option id="label5" value="Adventure" <c:if test="${movieItemobj.genre=='Adventure'}">selected</c:if>>Adventure</option>
         <option id="label5" value="Thriller" <c:if test="${movieItemobj.genre=='Thriller'}">selected</c:if>>Thriller</option>
      </select>
     </td>
</tr>
<tr>
    <td><input type="checkbox" value="java" name="freeDelievery" checked>Has Teaser</td>
</tr>
<tr>
<td><input type="submit"  value="Save" id="b1"/></td>
</tr>
</table>

</form>
</div>

<footer id="p3">

<p id="f1">Copyright@2019</p>
</footer>
</body>
</html>
