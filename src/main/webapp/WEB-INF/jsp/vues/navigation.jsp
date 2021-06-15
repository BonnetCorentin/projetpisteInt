<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <!--<div class="navbar-header">
            <a class="navbar-brand" href="/authentification/accueil">Médiathèque de POLYTECH</a>
        </div>
        <p class="navbar-text">Gestion de l'exposition 2021</p>
        <ul class="nav navbar-nav">
            <li><a href="/authentification/accueil"> <span class="glyphicon glyphicon-home"></span> Accueil</a></li>
            <li class="dropdown">
                <a class="nav navbar-nav navbar-right"  href="/authentification/login">
                    <span class="glyphicon glyphicon-user"></span>
                    Se Connecter
                    <span class="caret"></span>
                </a>
            </li>!-->
        <%
            if (session.getAttribute("id") != null) {
        %>
        <%
            if (session.getAttribute("role").equals("admin")) {
        %>
        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <span class="glyphicon glyphicon-user"></span>
                Apprenants
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <li><a href="/learner/ajout"> <span class="glyphicon glyphicon-plus"></span> Ajout Apprenant</a></li>
                <li><a href="/learner/getLearners"><span class="glyphicon glyphicon-th-list"></span> Lister les
                    apprenants</a></li>
            </ul>
        </li>
        <% }%>

        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <span class="glyphicon glyphicon-user"></span>
                Missions
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <%
                    if (session.getAttribute("role").equals("admin")) {
                %>
                <li><a href="/mission/ajout"> <span class="glyphicon glyphicon-plus"></span>Ajout Mission</a></li>
                <% }%>
                <li><a href="/mission/getMissions"><span class="glyphicon glyphicon-th-list"></span> Lister les missions</a>
                </li>
                <%
                    if (session.getAttribute("role").equals("apprenant")){
                %>
                <li><a href="/mission/getMissions/learner/${sessionScope.id}"><span class="glyphicon glyphicon-th-list"></span> Mes missions</a>
                </li>
                <% }%>
            </ul>
        </li>

        <li class="dropdown">
            <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                <span class="glyphicon glyphicon-user"></span>
                Actions
                <span class="caret"></span>
            </a>
            <ul class="dropdown-menu">
                <%
                    if (session.getAttribute("role").equals("admin")) {
                %>
                <li><a href="/action/ajout"> <span class="glyphicon glyphicon-plus"></span> Ajout Action</a></li>
                <% }%>
                <li><a href="/action/getActions"><span class="glyphicon glyphicon-th-list"></span> Lister les
                    actions</a></li>
            </ul>
        </li>
        <li><a href="/authentification/logOut"><span class="glyphicon glyphicon-log-out"></span> Déconnecter</a></li>

    </div>
    </ul>
    <a align="right" href="/learner/afficherLearner/${sessionScope.id}"><span>Mon compte</span></a>
    <% } else {%>
    <a align="right" href="/authentification/login"><span>Login</span></a><%}%>
</nav>
