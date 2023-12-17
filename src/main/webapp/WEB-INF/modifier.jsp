<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Etudiant" %>
<%@ page import="com.EtudiantDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifier un étudiant</title>
</head>
<body>
<h2>Modifier les informations d'un étudiant</h2>

    <%
        int etudiantId = Integer.parseInt(request.getParameter("id")); 
        Etudiant etudiant = EtudiantDAO.getEtudiantById(etudiantId);
    %>

    <form action="EtudiantServlet" method="post">
        <input type="hidden" name="id" value="<%= etudiant.getId() %>">
        Nom: <input type="text" name="nom" value="<%= etudiant.getNom() %>" required><br>
        Prénom: <input type="text" name="prenom" value="<%= etudiant.getPrenom() %>" required><br>
        Date de naissance: <input type="date" name="dateNaissance" value="<%= etudiant.getDateNaissance() %>"><br>
        Filière: <input type="text" name="filiere" value="<%= etudiant.getFiliere() %>"><br>
        <input type="submit" value="Modifier">
    </form>
    <a href="index.jsp">Retour à la liste des étudiants</a>
</body>
</html>