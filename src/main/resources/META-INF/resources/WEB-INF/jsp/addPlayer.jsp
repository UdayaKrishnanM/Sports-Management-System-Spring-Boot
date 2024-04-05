<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Player</title>
</head>
<body>
	
<h1>Add a Player</h1>
    <form action="/players/addPlayer" method="post">
		<label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>
        
        <label for="department">Department:</label>
        <input type="text" id="department" name="department" required><br><br>
        
        <label for="odiRank">ODI Rank:</label>
        <input type="number" id="odiRank" name="odiRank" required><br><br>
        
        <label for="t20Rank">T20 Rank:</label>
        <input type="number" id="t20Rank" name="t20Rank" required><br><br>
        
        <label for="testRank">Test Rank:</label>
        <input type="number" id="testRank" name="testRank" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
</body>
</html>