<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="bg-warning bg-gradient p-5 text-center" style="height: 80%;">
    <h1 class="pb-3"><i class="fas fa-pen"></i> Modifier une mission</h1>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="card col-4">
                <div class="card-body">
                    <h2 class="card-title"><i class="fas fa-gamepad"></i> ${maMission.wording}</h2>
                    <form method="POST" action="/mission/modifier">
                        <fieldset>
                            <input type="hidden" name="idMission" value="${maMission.id}"/>
                            <div class="form-floating">
                                <input name="wording" type="text" class="form-control" placeholder="Nom" value="${maMission.wording}" autofocus required/>
                                <label>Nom</label>
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