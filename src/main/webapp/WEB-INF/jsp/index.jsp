<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: christian--%>
<%--  Date: 06/04/2018--%>
<%--  Time: 14:11--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page language="java" contentType="text/html; charset=UTF-8"--%>
<%--         pageEncoding="UTF-8"%>--%>

<%--<%@include file="vues/header.jsp" %>--%>
<%--<body>--%>
<%--<%@include file="vues/navigation.jsp"%>--%>
<%--<div class="jumbotron text-center">--%>

<%--    <h1>Bienvenue sur la médiathèque de Polytech</h1>--%>
<%--    <h2>${sessionScope.name} ${sessionScope.surname}</h2>--%>
<%--</div>--%>
<%--<h2>Sélectionnez dans le menu la fonctionnalité voulue !</h2>--%>
<%--<%@include file="vues/footer.jsp"%>--%>
<%--</body>--%>
<%--</html>--%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="views/header.jsp" %>
<div class="p-5">
    <h1>Bienvenue sur le simulateur du permis piste de l'aéroport de Nice !</h1>
    <c:set var="currentDate" value="<%= new java.util.Date()%>"/>
    <fmt:formatDate value="${currentDate}" var="formattedDate" type="date" pattern="EEEE dd MMMM yyyy"/>
    <fmt:formatDate value="${currentDate}" var="formattedTime" type="date" pattern="HH:mm"/>
    <p class="lead">Nous sommes le ${formattedDate} et il est ${formattedTime}.</p>
    <hr class="my-4">
    <p>Sélectionnez dans <span class="badge bg-dark"><i class="fas fa-bars"></i> Menu</span> la fonctionnalité désirée
        ou cliquez sur le bouton suivant.</p>
    <a class="btn btn-primary btn-lg" href="#"><i class="fas fa-gamepad"></i> Accéder aux jeux</a>
</div>
<%@include file="views/footer.jsp" %>
