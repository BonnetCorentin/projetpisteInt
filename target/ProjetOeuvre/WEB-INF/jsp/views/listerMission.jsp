<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="p-5">
	<h1 class="pb-2">Consulter la liste des missions</h1>
	<div class="container-fluid">
		<table class="table data-table table-striped table-hover">
			<thead>
			<tr>
				<th>#</th>
				<th>Nom</th>
				<th>Actions</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${mesMissions}" var="mission">
				<tr>
					<td>${mission.id}</td>
					<td>${mission.wording}</td>
					<td>
						<a class="btn btn-success btn-sm" href="/mission/sinscrireMission/${sessionScope.id}/${mission.id}"><i class="fas fa-sign-in-alt"></i> S'inscrire</a>
						<a class="btn btn-primary btn-sm" href="/action/${mission.id}/getActions"><i class="fas fa-directions"></i> Actions associées</a>
						<% if (session.getAttribute ("role") != null && session.getAttribute ("role").equals ("admin")) {%>
						<a class="btn btn-warning" href="/mission/modifierMission/${mission.id}"><i class="fas fa-pen"></i></a>
						<a class="btn btn-danger" href="/mission/supprimerMission/${mission.id}"><i class="fas fa-times"></i></a>
						<% } %>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@include file="footer.jsp"%>