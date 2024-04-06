<%@page import = "com.sportsmanagement.model.Player"%>
<%@page import = "com.sportsmanagement.model.Ranks"%>

<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Player List</title>
</head>
<body>
    <h1>Player List</h1>
    <table border="1">
        <thead>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Age</th>
                <th>Department</th>
                <th>T20 Rank</th>
				<th>ODI Rank</th>
                <th>Test Rank</th>
            </tr>
        </thead>
        <tbody>
            <% 
                List<Player> dataList = (List<Player>)request.getAttribute("players");
                for(int c = 0; c < dataList.size(); c++) {
            %>
                <tr>
                    <td><%= dataList.get(c).getId() %></td>
                    <td><%= dataList.get(c).getName() %></td>
                    <td><%= dataList.get(c).getAge() %></td>
                    <td><%= dataList.get(c).getDepartment() %></td>
                    <td><%= (dataList.get(c).getRanks() != null) ? dataList.get(c).getRanks().getT20_rank() : "" %></td>
                    <td><%= (dataList.get(c).getRanks() != null) ? dataList.get(c).getRanks().getOdi_rank() : "" %></td>
                    <td><%= (dataList.get(c).getRanks() != null) ? dataList.get(c).getRanks().getTest_rank() : "" %></td>
                </tr>
            <% } %>
        </tbody>
    </table>
</body>
</html>
