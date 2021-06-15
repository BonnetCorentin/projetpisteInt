<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="p-5">
	<h1 class="pb-2">Consulter la liste des actions associées à la mission ${mission.wording}</h1>
	<div class="container-fluid">
		<table class="table data-table table-striped table-hover">
			<thead>
			<tr>
				<th>#</th>
				<th>Nom</th>
				<th>Score minimum</th>
				<% if (session.getAttribute ("role") != null && session.getAttribute("role").equals("admin")) {%>
				<th>Actions</th>
				<% } %>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${mesActions}" var="action">
				<tr>
					<td>${action.id}</td>
					<td>${action.wording}</td>
					<td>${action.scoreMinimum}</td>
					<% if (session.getAttribute ("role") != null && session.getAttribute("role").equals("admin")) {%>
					<td>
						<a class="btn btn-danger" href="/mission/supprimerMission/${mission.id}/action/${action.id}"><i class="fas fa-times"></i></a>
					</td>
					<% } %>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@include file="footer.jsp"%>