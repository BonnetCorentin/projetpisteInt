<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="bg-success bg-gradient p-5 text-center" style="height: 80%;">
    <h1 class="text-white pb-3"><i class="fas fa-plus"></i> Ajouter une action</h1>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="card col-4">
                <div class="card-body">
                    <h2 class="card-title"><i class="fas fa-directions"></i>  Nouvelle action</h2>
                    <form method="POST" action="insererAction">
                        <fieldset>
                            <div class="form-floating">
                                <input name="wording" type="text" class="form-control" placeholder="Nom" autofocus required/>
                                <label>Nom</label>
                            </div>
                            <div class="form-floating">
                                <input name="scoreMinimum" type="number" class="form-control" placeholder="Score minimum" val="0" min="0" step="0.1" required/>
                                <label>Score minimum</label>
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