<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update a Player Details</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script>
    

    function showInput() {
	
	
    var type = document.getElementById("type").value;
    var inputContainer = document.getElementById("inputContainer");
    if (type === "age") {
        inputContainer.innerHTML = '<label for="value">Enter the age:</label>' +
            '<input type="number" id="value" min="20" max="45" name="value" required>';
    } else if (type === "department") {
        // Show dropdown for department
        inputContainer.innerHTML = '<label for="value">Select the department:</label>' +
            '<select id="value" name="value" required>' +
            '<option value="Batsmen">Batsmen</option>' +
            '<option value="Bowler">Bowler</option>' +
            '<option value="WicketKeeper">WicketKeeper</option>' +
            '<option value="AllRounder">AllRounder</option>' +
            '</select>';
    }
}
    
    var message = "${message}";
    if (message.trim() !== "") {
        alert(message);
    }



function validateForm(event) {
    var id = document.getElementById("id").value;
    var type = document.getElementById("type").value;
    var value = document.getElementsByName("value")[0].value;

    if (isNaN(id)) {
        alert("ID must be a number");
        return false;
    }

    if (type === "age" && (value < 20 || value > 45)) {
        alert("Age must be between 20 and 45");
        return false;
    }

    return true;
}


</script>
</head>
<body>
    <h1>Update Player</h1>
    <form action="/players/updatePlayer" method="post" onsubmit="return validateForm()">
        <label for="id">Player ID:</label>
        <input type="text" id="id" name="id" required><br><br>
        
        <label for="type">Select update type:</label>
        <select id="type" name="type" onchange="showInput()" required>
            <option value="age">Age</option>
            <option value="department">Department</option>
        </select><br><br>
        
        <div id="inputContainer">
        	<label for="value">Enter the age:</label>
            <input type="number" id="value" min="20" max="45" name="value" required>
        </div><br><br>
        
        
        <input type="submit" value="Submit">
    </form>
    


    
    
    
</body>
</html>



<!-- 

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<title>Delete a Player</title>
<!-- 
<script>

	function validateForm(){
		var id = document.forms["deletePlayerForm"]["id"].value;
		
		if(isNaN(id)){
			alert("ID must be number");
			return false;
		}
		
		var idExists = checkIdExists(id);
		function checkIdExists(id){
			var exists = false;
			$.ajax({
				url: 'players/checkIdExists',
				type:'post',
				data:{id, id},
				async: false,
				success: function(data){
					exists = data.exists;
				},
				error: function(){
					alert('ID not Found');
				}
				
			});
			return exists;
		}
		return true;
	}

	$(document).ready(function(){
		$('#deletePlayerForm').submit(function(event){
			event.preventDefault();
			if(validateForm()){
				$(this).unbind('submit').submit();
			}
		});
	});
	
</script>



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
 -->