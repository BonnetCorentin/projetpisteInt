<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="bg-warning bg-gradient p-5 text-center" style="height: 80%;">
    <h1 class="pb-3"><i class="fas fa-pen"></i> Modifier un apprenant</h1>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="card col-4">
                <div class="card-body">
                    <h2 class="card-title"><i class="fas fa-user"></i> ${monLearner.forname} ${monLearner.surname}</h2>
                    <form method="POST" action="/learner/modifier">
                        <fieldset>
                            <input type="hidden" name="idLearner" value="${monLearner.id}"/>
                            <div class="form-floating">
                                <input name="prenom" type="text" class="form-control" placeholder="Prénom" value="${monLearner.forname}" autofocus required/>
                                <label>Prénom</label>
                            </div>
                            <div class="form-floating">
                                <input name="nom" type="text" class="form-control" placeholder="Nom" value="${monLearner.surname}" required/>
                                <label>Nom</label>
                            </div>
                            <div class="form-floating">
                                <input name="email" type="email" class="form-control" placeholder="Email" value="${monLearner.email}" required/>
                                <label>Email</label>
                            </div>
                            <button name="submit" type="submit" class="btn btn-warning"><i class="fas fa-pen"></i> Enregistrer</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>