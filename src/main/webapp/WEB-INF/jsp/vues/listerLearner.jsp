<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
	<h1>Listing des apprenants</h1>
</div>

<div class="container">
		<!--<a class="btn btn-secondary" href="/authentification/accueil" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>-->
		<h2>Tableau des apprenants</h2>
		<div class="container">
			<h3>Liste des apprenants</h3>
			<table class="table table-hover">
				<tr>
					<th class="col-md-1">Prénom</th>
					<th class="col-md-2">Nom</th>
					<th class="col-md-2">Email</th>
				</tr>

				<c:forEach items="${mesLearners}" var="item">
					<tr>
						<td>${item.forname}</td>
						<td>${item.surname}</td>
						<td>${item.email}</td>
						<td><a class="btn btn-primary" href="/mission/getMissions/learner/${item.id}" role="button"><span
								class="glyphicon glyphicon-pushpin"></span> Missions</a>
							<a class="btn btn-info" href="/learner/modifierLearner/${item.id}" role="button"><span
								class="glyphicon glyphicon-pencil"></span> Modifier</a>
							<a class="btn btn-danger" href="/learner/supprimerLearner/${item.id}" role="button"><span
									class="glyphicon glyphicon-remove-circle"></span> Supprimer</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
    </div>
<%@include file="footer.jsp"%>
</body>

</html>