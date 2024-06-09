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
	<div class="alert alert-${ status ? 'success' : 'danger' }">
		${ statusMessage }
	</div>
		<h1 id="titre-principal">Authentification</h1>
		<form method="post" class="main">
			<div class="formItem">
				<label>Login</label>
				<input type="text" name="login" value="${ login }">
			</div>
			<div class="formItem">
				<label>Mot de Passe</label>
				<input type="password" name="password">
			</div>
			<div class="formItem">
				<input type="submit" value="connexion">
			</div>
		</form>
	</section>
	<footer>M2 EC2LT &copy; Avril 2024</footer>
</body>
</html>