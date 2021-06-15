<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="p-5">
	<h1 class="pb-2">Consulter la liste des apprenants</h1>
	<div class="container-fluid">
		<div class="row">
			<c:forEach items="${mesLearners}" var="learner">
				<div class="card px-0 me-2 mb-2" style="width: 14rem;">
					<img class="card-img-top" src="/img/default_profile_picture.png" alt="Photo de profil">
					<div class="card-body">
						<h5 class="card-title">${learner.forname} ${learner.surname}</h5>
						<h6 class="card-subtitle mb-2 text-muted"><i class="fas fa-paper-plane text-primary h-25"></i> <a href="mailto:${learner.email}">${learner.email}</a></h6>
						<a class="btn btn-warning" href="/learner/modifierLearner/${learner.id}"><i class="fas fa-pencil-alt"></i></a>
						<a class="btn btn-danger" href="/learner/supprimerLearner/${learner.id}"><i class="fas fa-times"></i></a>
						<a class="btn btn-sm btn-primary" href="/mission/getMissions/learner/${learner.id}"><i class="fas fa-gamepad"></i> Missions</a>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<%@include file="footer.jsp"%>