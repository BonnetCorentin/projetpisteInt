<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<nav id="sidebar" class="sidebar p-3 text-white bg-dark">
    <%
        if (session.getAttribute("id") != null) {
    %>
    <h4 class="text-center">${sessionScope.name}</h4>
    <% } else { %>
    <h4 class="text-center">Veuillez vous connecter</h4><% } %>
    <%
        if (session.getAttribute("id") != null) {
    %>
    <hr class="my-4"/>
    <%
        if (session.getAttribute("role").equals("admin")) {%>
    <ul class="nav nav-pills flex-column">
        <li class="nav-item">
            <a href="/learner/ajout" class="nav-link ">
                <i class="fas fa-gamepad"></i> Ajouter un apprenant
            </a>
        </li>
        <li class="nav-item">
            <a href="/learner/getLearners" class="nav-link ">
                <i class="fas fa-gamepad"></i> Lister les apprenants
            </a>
        </li>
            <% }

        if (session.getAttribute("role").equals("admin")) {%>
        <ul class="nav nav-pills flex-column">
            <li class="nav-item">
                <a href="/mission/ajout" class="nav-link ">
                    <i class="fas fa-gamepad"></i> Ajouter une mission
                </a>
            </li>
                <% } %>
            <li class="nav-item">
                <a href="/mission/getMissions" class="nav-link ">
                    <i class="fas fa-gamepad"></i> Lister les missions
                </a>
            </li>
            <li class="nav-item">
                <a href="/mission/getMissions/learner/${sessionScope.id}" class="nav-link">
                    <i class="fas fa-gamepad"></i> Mes missions
                </a>

            </li>
                <%
        if (session.getAttribute("role").equals("admin")) {%>
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a href="/action/ajout" class="nav-link ">
                        <i class="fas fa-gamepad"></i> Ajouter une action
                    </a>
                </li>
                    <% } %>
                <li class="nav-item">
                    <a href="/action/getActions" class="nav-link ">
                        <i class="fas fa-gamepad"></i> Lister les actions
                    </a>
                </li>

                    <% } %>
</nav>