<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update a Player Details</title>
</head>
<body>
    <h1>Update Player</h1>
    <form action="/players/updatePlayer" method="post">
        <label for="id">Player ID:</label>
        <input type="text" id="id" name="id"><br><br>
        
        <label for="type">Select update type:</label>
        <select id="type" name="type">
            <option value="age">Age</option>
            <option value="department">Department</option>
        </select><br><br>
        
        <label for="value">Enter the input:</label>
        <input type="text" id="value" name="value"><br><br>
        
        <input type="submit" value="Submit">
</body>
</html>