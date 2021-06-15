<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
	<h1>Listing des actions</h1>
</div>

<div class="container">
		<!--<a class="btn btn-secondary" href="/authentification/accueil" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>-->
		<h2>Tableau des actions</h2>
		<div class="container">
			<h3>Liste des actions</h3>
			<table class="table table-hover">
				<tr>
					<th class="col-md-1">Nom de l'action</th>
				</tr>

				<c:forEach items="${mesActions}" var="item">
					<tr>
						<td>${item.wording}</td>
						<td><a class="btn btn-primary" href="/mission/getMissions/action/${item.id}" role="button"><span
								class="glyphicon glyphicon-pushpin"></span> Missions</a>
							<%
								if (session.getAttribute("role").equals("admin")) {
							%>
							<a class="btn btn-info" href="/action/modifierAction/${item.id}" role="button"><span
								class="glyphicon glyphicon-pencil"></span> Modifier</a>
							<a class="btn btn-danger" href="/action/supprimerAction/${item.id}" role="button"><span
									class="glyphicon glyphicon-remove-circle"></span> Supprimer</a>
							<% } %></td>

					</tr>
				</c:forEach>
			</table>
		</div>
    </div>
<%@include file="footer.jsp"%>
</body>

</html>