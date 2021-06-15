<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
    <h1>Dashboard</h1>
</div>

<div class="container">
    <!--<a class="btn btn-secondary" href="/authentification/accueil" role="button"><span class="glyphicon glyphicon-menu-left"></span> Retour accueil</a>-->
    <div class="container">
        <h3>Vos informations</h3>
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Prénom</th>
                <th class="col-md-2">Nom</th>
                <th class="col-md-2">Email</th>
            </tr>
                <tr>
                    <td>${learner.forname}</td>
                    <td>${learner.surname}</td>
                    <td>${learner.email}</td>
                    <td><a class="btn btn-primary" href="/mission/getMissions/learner/${learner.id}" role="button"><span
                            class="glyphicon glyphicon-pushpin"></span> Missions</a>
                        <a class="btn btn-info" href="/learner/modifierLearner/${learner.id}" role="button"><span
                                class="glyphicon glyphicon-pencil"></span> Modifier</a>
                </tr>
        </table>
    </div>
</div>
<%@include file="footer.jsp"%>
</body>

</html>