<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="bg-success bg-gradient p-5 text-center" style="height: 80%;">
    <h1 class="text-white pb-3"><i class="fas fa-plus"></i> Ajouter un apprenant</h1>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="card col-4">
                <div class="card-body">
                    <h2 class="card-title"><i class="fas fa-user"></i>  Nouvel apprenant</h2>
                    <form method="POST" action="insererLearner">
                        <fieldset>
                            <div class="form-floating">
                                <input name="prenom" type="text" class="form-control" placeholder="Prénom" autofocus required/>
                                <label>Prénom</label>
                            </div>
                            <div class="form-floating">
                                <input name="nom" type="text" class="form-control" placeholder="Nom" required/>
                                <label>Nom</label>
                            </div>
                            <div class="form-floating">
                                <input name="email" type="email" class="form-control" placeholder="Email" required/>
                                <label>Email</label>
                            </div>
                            <div class="form-floating">
                                <input name="mdp" type="password" class="form-control" placeholder="Mot de passe" required/>
                                <label>Mot de passe</label>
                            </div>
                            <button name="submit" type="submit" class="btn btn-success"><i class="fas fa-plus"></i> Ajouter</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp"%>