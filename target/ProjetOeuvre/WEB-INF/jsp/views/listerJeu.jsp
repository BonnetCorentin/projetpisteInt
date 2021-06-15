<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="p-5">
	<h1 class="pb-2">Consulter la liste des jeux</h1>
	<div class="container-fluid">
		<table class="table data-table table-striped table-hover">
			<thead>
			<tr>
				<th>#</th>
				<th>Mission</th>
				<th>Date</th>
				<th>Score total</th>
			</tr>
			</thead>
			<tbody>
			<c:forEach items="${mesJeux}" var="jeu">
				<tr>
					<td>${jeu.id}</td>
					<td><c:if test="${not empty jeu.mission}">
						${jeu.mission.wording}
					</c:if></td>
					<td>${jeu.date}</td>
					<td>${jeu.scoreTotal}</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
</div>
<%@include file="footer.jsp"%>