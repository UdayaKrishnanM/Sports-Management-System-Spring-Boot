<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Delete a Player</title>
</head>
<body>

	<h1>Delete Player</h1>
    <form action="/players/deletePlayer" method="post">
        Player ID: <input type="text" name="id"><br><br>
        <input type="submit" value="Submit">
    </form>

</body>
</html>