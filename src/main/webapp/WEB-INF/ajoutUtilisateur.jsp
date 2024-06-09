<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
	<section>
		<h1 id="titre-principal">Ajout d'un utilisateur</h1>
		<form method="post" class="main">
			<div class="formItem">
				<label>Nom</label>
				<input type="text" name="nom" value="${ utilisateur.nom }">
				<span class="erreur"">${ erreurs.nom }</span>
			</div>
			<div class="formItem">
				<label>Prénom</label>
				<input type="text" name="prenom" value="${ utilisateur.prenom }">
				<span class="erreur"">${ erreurs.prenom }</span>
			</div>
			<div class="formItem">
				<label>Login</label>
				<input type="text" name="login" value="${ utilisateur.login }">
				<span class="erreur"">${ erreurs.login }</span>
			</div>
			<div class="formItem">
				<label>Mot de Passe</label>
				<input type="password" name="password">
				<span class="erreur"">${ erreurs.password }</span>
			</div>
			<div class="formItem">
				<label>Confirmation de Mot de Passe</label>
				<input type="password" name="passwordBis">
				<span class="erreur"">${ erreurs.passwordBis }</span>
			</div>
			<div class="formItem">
				<input type="submit" value="Ajouter">
			</div>
		</form>
	</section>
	<footer>M2 EC2LT &copy; Avril 2024</footer>
</body>
</html>