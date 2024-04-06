<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<title>Add a Player</title>
<script>

    function validateForm() {
        var name = document.forms["addPlayerForm"]["name"].value;
        var age = document.forms["addPlayerForm"]["age"].value;
        var id = document.forms["addPlayerForm"]["id"].value;
		var t20Rank = document.forms["addPlayerForm"]["t20_rank"].value;
		var odiRank = document.forms["addPlayerForm"]["odi_rank"].value;
		var testRank = document.forms["addPlayerForm"]["test_rank"].value;
        // Validate name (letters only)
        if (isNaN(id)) {
            alert("ID must be number");
            return false;
        }
        
        if(!/^[a-zA-Z]+$/.test(name)){
            alert("Name must contain only letters");
            return false;
        }

        // Validate age (between 20 and 45)
        if (age < 20 || age > 45) {
            alert("Age must be between 20 and 45");
            return false;
        }
        
        if(isNaN(t20Rank) || isNaN(odiRank) || isNaN(testRank)){
        	alert("Rank must be number");
        	return false;
        }

        
        var rankExist = checkRanksExist(t20Rank, odiRank, testRank);
       	if(!rankExist){
        	alert(rankExist);
        	return false;
       	}
        

        // Validate id (should not be available in DB - not implemented here)
        // Add server-side validation for ID existence in the database
        var idExists = checkIdExists(id);
        function checkIdExists(id){
            var exists = false;
            $.ajax({
                url: '/players/checkIdExists',
                type: 'post',
                data: {id: id},
                async: false,
                success: function(data) {
                    exists = data.exists;
                },
                error: function() {
                    alert('Error occurred while checking ID existence');
                }
            });
            return exists;
        }
        return true;
    }

	   
    function checkRanksExist(t20Rank, odiRank, testRank){
        	var available = null;
        	$.ajax({
        		url: '/players/checkRanksExist',
        		type: 'post',
        		data:{
        			t20Rank:t20Rank,
        			odiRank: odiRank,
        			testRank: testRank
        		},
        		async: false,
        		success: function(data){
        			if(data.exists){
	        			available = "Rank already exists;
        			}
        		},
        		error: function(){
        			alert('Error occured while checking rank availability');
        		}
        	
        	});
        	return msg;
    }    

</script>
</head>
<body>
	
<h1>Add a Player</h1>
    <form action="/players/addPlayer" name="addPlayerForm" method="post" onsubmit="return validateForm()">
		<label for="id">ID:</label>
        <input type="text" id="id" name="id" required><br><br>

        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>
                
		<label for="department">Select the department:</label>
        <select id="department" name="department" required>
            <option value="Batsmen">Batsmen</option>
            <option value="Bowler">Bowler</option>
            <option value="WicketKeeper">WicketKeeper</option>
            <option value="AllRounder">AllRounder</option>
        </select>
        <br><br>
        
        
        
        <label for="t20_rank">T20 Rank:</label>
        <input type="number" id="t20_rank" name="ranks.t20_rank" required><br><br>
        
        <label for="odi_rank">ODI Rank:</label>
        <input type="number" id="odi_rank" name="ranks.odi_rank" required><br><br>
        
        <label for="test_rank">Test Rank:</label>
        <input type="number" id="test_rank" name="ranks.test_rank" required><br><br>
        
        <input type="submit" value="Submit">
    </form>
    
	<c:if test="${not empty error}">
		<p style="color: red;">${error}</p>
	</c:if>
	
</body>
</html>