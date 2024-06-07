<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%--          <%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Box Cricket Registration</title>
</head>
<body>	
<h2>Box Cricket Registration</h2>
<br>
<form action="savestudent" method="post">
StudentName: <input type="text" name="studentName" value="${studentBean.studentName}"><span style="color:red">${studentNameError}</span><br><br>
Playing Type: 
			  BatsMen <input type="radio" name="playingType" value="batsmen"  ${studentBean.playingType == 'batsmen' ? 'checked' : ''}>
   			  Bowler <input type="radio" name="playingType" value="bowler" ${studentBean.playingType == 'bowler' ? 'checked' : ''}>
			  AllRounder <input type="radio" name="playingType" value="allRounder" ${studentBean.playingType == 'allRounder' ? 'checked' : ''}> <span style="color:red">${playingTypeError}</span>
<br><br>
Food: <select name="food" value="${studentBean.food}">
		<option value="-1">---Select Food---</option>
		<option value="Jain" ${studentBean.food == 'Jain' ? 'selected' : ''}>Jain</option>
		<option value="Regular" ${studentBean.food == 'Regular' ? 'selected' : ''}>Regular</option>
	 </select><span style="color:red">${foodError}</span>
<br><br>
CoolDrink: RedBull<input type = "checkbox" name="coolDrink" value="RedBull"  ${studentBean.coolDrink.contains('RedBull') ? 'checked' : ''}
>
		   Mountain Dew<input type = "checkbox" name="coolDrink" value="Mountain Dew" ${studentBean.coolDrink.contains('Mountain Dew') ? 'checked' : ''} >
		   Lemon Juice<input type = "checkbox" name="coolDrink" value="Lemon Juice" ${studentBean.coolDrink.contains('Lemon Juice') ? 'checked' : ''}>
		   Thums Up<input type = "checkbox" name="coolDrink" value="Thums Up" ${studentBean.coolDrink.contains('Thums Up') ? 'checked' : ''}><span style="color:red">${coolDrinkError}</span>
<br><br>

		<input type="submit" value="Register">
			  </form>
</body>
</html>