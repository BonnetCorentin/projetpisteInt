<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<div class="p-5">
    <h1 class="pb-2">Consulter la liste des missions associées à l'action ${action.wording}</h1>
    <div class="container-fluid">
        <% if (session.getAttribute ("role") != null && session.getAttribute("role").equals("admin")) {%>
        <a class="btn btn-success" href="/action/ajouterMission/${action.id}"><i class="fas fa-plus"></i> Ajouter une mission</a>
        <% } %>
        <table class="table data-table table-striped table-hover">
            <thead>
            <tr>
                <th>#</th>
                <th>Nom</th>
                <% if (session.getAttribute ("role") != null && session.getAttribute("role").equals("admin")) {%>
                <th>Actions</th>
                <% } %>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${mesMissions}" var="mission">
                <tr>
                    <td>${mission.id}</td>
                    <td>${mission.wording}</td>
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