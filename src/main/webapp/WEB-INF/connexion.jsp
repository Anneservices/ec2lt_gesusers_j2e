<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="inc/header.jsp" %>
	<section>
		<% 
		if(request.getAttribute("status") != null)
		{%>
			<div class="alert alert-${ status ? 'success' : 'danger' }">
				${ statusMessage }
			</div><%
		}
		%>
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