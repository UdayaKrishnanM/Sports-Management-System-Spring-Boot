<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Delete a Player</title>
<script >
document.addEventListener("DOMContentLoaded", function() {
    var message = "${message}";
    if (message.trim() !== "") {
        alert(message);
    }
    
    document.querySelector("form").addEventListener("submit", function(event) {
        var confirmDelete = confirm('Are you sure you want to delete this player?');
        if (!confirmDelete) {
            event.preventDefault(); // Prevent form submission if user cancels
        }
    });
});
	
</script>
</head>


<body>

	<h1>Delete Player</h1>
    <form action="/players/deletePlayer" method="post" onsubmit="return confirmDelete()">
        <label for="id>">Player ID: </label>
        <input type="text" name="id" required><br><br>
        <input type="submit" value="Submit">
    </form>


    
   	<c:if test="${not empty error}">
		<p style="color: red;">${error}</p>
	</c:if>

</body>
</html>