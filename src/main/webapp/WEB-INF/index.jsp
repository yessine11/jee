<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="com.Etudiant" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste des étudiants</title>
</head>
<body>
<h2>Liste des étudiants</h2>
<%
@SuppressWarnings("unchecked")
        List<Etudiant> etudiants = (List<Etudiant>) request.getAttribute("etudiants");
    %>
<table border="1">
        <tr>
            <th>ID</th>
            <th>Nom</th>
            <th>Prénom</th>
            <th>DateNaissance</th>
            <th>Filiere</th>
        </tr>
        <% for (Etudiant etudiant : etudiants) { %>
            <tr>
                <td><%= etudiant.getId() %></td>
                <td><%= etudiant.getNom() %></td>
                <td><%= etudiant.getPrenom() %></td>
                <td><%= etudiant.getDateNaissance() %></td>
                 <td><%= etudiant.getFiliere() %></td>
            </tr>
        <% } %>
        </table>
    <a href="ajouter.jsp">Ajouter un étudiant</a>
    
    <br><br>

    
    <% for (Etudiant etudiant : etudiants) { %>
        <a href="modifier.jsp?id=<%= etudiant.getId() %>">Modifier <%= etudiant.getNom() %> <%= etudiant.getPrenom() %></a>
        <br>
    <% } %>
    
</body>
</html>