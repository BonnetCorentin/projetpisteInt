<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="bg-success bg-gradient p-5 text-center" style="height: 80%;">
    <h1 class="text-white pb-3"><i class="fas fa-random"></i> Associer une nouvelle mission</h1>
    <div class="container-fluid">
        <div class="row justify-content-center">
            <div class="card col-4">
                <div class="card-body">
                    <h2 class="card-title"><i class="fas fa-directions"></i>  Choix de la mission</h2>
                    <form method="POST" action="/action/insererMissionAction">
                        <fieldset>
                            <input type="hidden" name="idAction" value="${id}" />
                            <div class="form-floating">
                                <select name="mission" class="form-control" autofocus>
                                    <c:forEach items="${missions}" var="mission">
                                        <option value="${mission.id}">${mission.wording}</option>
                                    </c:forEach>
                                </select>
                                <label>Mission sélectionnée</label>
                            </div>
                            <button name="submit" type="submit" class="btn btn-success"><i class="fas fa-random"></i> Associer</button>
                        </fieldset>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>