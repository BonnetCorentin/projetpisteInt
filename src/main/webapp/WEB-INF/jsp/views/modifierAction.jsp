<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="bg-dark bg-gradient p-5 text-center" style="height: 80%;">
    <h1 class="text-white pb-3"><i class="fas fa-pen"></i> Modifier une action</h1>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="card col-4">
                <div class="card-body">
                    <h2 class="card-title"><i class="fas fa-directions"></i> ${monAction.wording}</h2>
                    <form method="POST" action="/action/modifier">
                        <fieldset>
                            <input type="hidden" name="idAction" value="${monAction.id}"/>
                            <div class="form-floating">
                                <input name="wording" type="text" class="form-control" placeholder="Nom" value="${monAction.wording}" autofocus required/>
                                <label>Nom</label>
                            </div>
                            <div class="form-floating">
                                <input name="scoreMinimum" type="number" class="form-control" placeholder="Score minimum" value="${monAction.scoreMinimum}" min="0" step="1" required/>
                                <label>Score minimum</label>
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