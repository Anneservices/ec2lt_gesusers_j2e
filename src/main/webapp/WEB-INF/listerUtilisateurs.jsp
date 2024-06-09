<%@page import="beans.Utilisateur"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% final String APP_ROOT = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title></title>
	<link rel="stylesheet" type="text/css" href="<%= APP_ROOT %>/css/design.css">
</head>
<body>
	<header>Gestion des utilisateurs</header>
	<nav>
		<ul>
			<li><a href="<%= APP_ROOT %>">Accueil</a></li>
			<li><a href="<%= APP_ROOT %>/list">Lister</a></li>
			<li><a href="<%= APP_ROOT %>/add">Ajouter</a></li>
		</ul>
	</nav>
	<section>
		<h1 id="titre-principal">Lister des utilisateurs</h1>
			<%
				ArrayList<Utilisateur> users = (ArrayList<Utilisateur>) request.getAttribute("utilisateurs");
				
				if(users.isEmpty())
				{
					out.print("Désolé, la liste des utilisateurs est vide !");
				}
				else
				{%>
					<table border="1" cellspacing="0" cellpadding="10">
					<tr>
						<th>ID</th>
						<th>Nom</th>
						<th>Prénom</th>
						<th>Login</th>
						<th>Password</th>
						<th colspan="2">Actions</th>
					</tr><%			
					for(Utilisateur user : users)
					{%>
						<tr>
							<td><%= user.getId()%></td>
							<td><%= user.getNom()%></td>
							<td><%= user.getPrenom()%></td>
							<td><%= user.getLogin()%></td>
							<td><%= user.getPassword()%></td>
							<td><a href="update?id=<%= user.getId() %>">Modifier</a></td>
							<td><a href="delete?id=<%= user.getId() %>" onclick="return confirm('En êtes-vous sûr ?')">Supprimer</a></td>
						</tr><%
					}%>
					</table><%
				}	
			%>
	</section>
	<footer>M2 EC2LT &copy; Avril 2024</footer>
</body>
</html>