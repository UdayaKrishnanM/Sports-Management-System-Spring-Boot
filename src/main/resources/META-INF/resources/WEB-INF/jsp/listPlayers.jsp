<%@page import = "com.sportsmanagement.model.Player"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

</head>
<body>


<%

	List<Player> dataList = (List<Player>)request.getAttribute("players");
	for(int c = 0; c<dataList.size(); c++){
		out.print("ID: " +dataList.get(c).getId() + "<br><br>");
		out.print("Name: " +dataList.get(c).getName() + "<br><br>");
	}
%>
<!-- 	
	<h1>In show players</h1>
    <table border="1" id="playersTable">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Department</th>
                <th>T20 Rank</th>
                <th>ODI Rank</th>
                <th>Test Rank</th>
            </tr>
			<c:forEach items="${players}" var="e">
				<tr>
					<td>${e.id}</td>
					<td>${e.name}</td>
					<td>${e.age}</td>					
					<td>${e.department}</td>
				</tr>
			
			</c:forEach>	

    </table>
    
    ////
        <tbody id="playerBody">
        </tbody>

</table>
    <script>
        $(document).ready(function() {
            $.get("/getAllPlayers", function(players) {
                var tableBody = $("#playersBody");
                tableBody.empty();
                players.forEach(function(player) {
                    var row = "<tr>" +
                              "<td>" + player.id + "</td>" +
                              "<td>" + player.name + "</td>" +
                              "<td>" + player.age + "</td>" +
                              "<td>" + player.department + "</td>" +
                              "</tr>";
                    tableBody.append(row);
                });
            });
        });
    </script>
     -->
</body>
</html>