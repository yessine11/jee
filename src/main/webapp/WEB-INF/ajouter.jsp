<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="com.Etudiant" %>
<%@ page import="com.EtudiantDAO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajouter un étudiant</title>
</head>
<body>
 <h2>Ajouter un nouvel étudiant</h2>

    <form action="EtudiantServlet" method="post"> 
    <input type="hidden" name="action" value="ajouter">
        Nom: <input type="text" name="nom" required><br>
        Prénom: <input type="text" name="prenom" required><br>
        Date de naissance: <input type="date" name="dateNaissance"><br>
        Filière: <input type="text" name="filiere"><br>
        <input type="submit" value="Ajouter">
    </form>
    <a href="index.jsp">Retour à la liste des étudiants</a>
</body>
</html>