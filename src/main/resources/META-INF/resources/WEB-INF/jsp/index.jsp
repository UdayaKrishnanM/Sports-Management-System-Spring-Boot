<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sports Management System</title>
</head>
<body>

<h1>Welcome to the Player Management System</h1>
    <div>
        <form action="addPlayer" method="get">
            <button type="submit">Add a Player</button>
        </form>
    </div>
    <div>
        <form action="listPlayers" method="get">
            <button type="submit">Show All Players</button>
        </form>
    </div>
	<div>
        <form action="pickTopPlayers" method="get">
            <button type="submit">Pick Top Players</button>
        </form>
    </div>
    <div>
        <form action="deletePlayer" method="get">
            <button type="submit">Delete a Player</button>
        </form>
    </div>

    <div>
        <form action="updatePlayer" method="get">
            <button type="submit">Update a Player</button>
        </form>
    </div>

<!-- 
     <h1>Player Management System</h1>
    <ul>
        <li><a href="addPlayer.jsp">Add a Player</a></li>
        <li><a href="listPlayers.jsp">List All Players</a></li>
        <li><a href="pickTopPlayers.jsp">Pick Top Players</a></li>
        <li><a href="deletePlayer.jsp">Delete a Player</a></li>
        <li><a href="updatePlayer.jsp">Update a Player</a></li>
    </ul>

 -->    
</body>
</html>