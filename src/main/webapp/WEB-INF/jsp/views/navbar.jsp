<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<nav class="navbar navbar-expand-lg sticky-top navbar-dark bg-dark">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">Logo</a>
        <ul class="navbar-nav me-auto">
            <li id="toggleSidebar" class="nav-item">
                <a class="nav-link" href="#"><span class="badge border border-white fs-6"><i class="fas fa-bars"></i> Menu</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link active" href="/">Accueil</a>
            </li>
        </ul>
        <%if (session.getAttribute("id") == null) {%>
        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a class="btn btn-success" href="/authentification/login"><i
                        class="fas fa-sign-in-alt"></i>Connexion</a>
            </li>
        </ul>
        <% } else { %>
        <ul class="navbar-nav ms-auto">
            <li class="nav-item">
                <a class="btn btn-danger" href="/authentification/logOut"><i
                        class="fas fa-sign-in-alt"></i>Déconnexion</a>
            </li>
        </ul>
        <% } %>
    </div>
</nav>