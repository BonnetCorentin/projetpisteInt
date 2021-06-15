<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="p-5">
	<h1 class="pb-2">Consulter la liste des actions</h1>
	<div class="container-fluid">
		<table class="table data-table table-striped table-hover">
			<thead>
			<tr>
				<th>#</th>
				<th>Nom</th>
				<th>Score minimum</th>
				<th>Actions</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${mesActions}" var="action">
				<tr>
					<td>${action.id}</td>
					<td>${action.wording}</td>
					<td>${action.scoreMinimum}</td>
					<td>
						<a class="btn btn-primary btn-sm" href="/mission/getMissions/action/${action.id}"><i class="fas fa-gamepad"></i> Missions associées</a>
						<% if (session.getAttribute ("role") != null && session.getAttribute("role").equals("admin")) {%>
						<a class="btn btn-warning" href="/action/modifierAction/${action.id}"><i class="fas fa-pen"></i></a>
						<a class="btn btn-danger" href="/action/supprimerAction/${action.id}"><i class="fas fa-times"></i></a>
						<% } %>
					</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@include file="footer.jsp"%>