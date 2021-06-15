<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
<H1> Modification d'un apprenant </H1>
</div>
<form method="post" action="/learner/modifier" onsubmit="return teste()">
<div class="col-md-12 well well-md">
    <h1>Modifier apprenti</h1>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-3">
            <INPUT type="hidden" name="idLearner" value="${monLearner.id}" id="idLearner" class="form-control" min="0">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label">Prénom de l'apprenti : </label>
        <div class="col-md-3">
            <INPUT type="text" name="prenom" value="${monLearner.forname}" id="prenom" class="form-control" min="0">
        </div>

    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label">Nom de l'apprenti : </label>
        <div class="col-md-3">
            <INPUT type="text" name="nom" value="${monLearner.surname}" id="nom" class="form-control" min="0">
        </div>
    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label">Email de l'apprenti : </label>
        <div class="col-md-3">
            <INPUT type="email" name="email" value="${monLearner.email}" id="email" class="form-control" min="0">
        </div>
    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
            Modifier
        </button>

    </div>
</div>
</form>
<%@include file="footer.jsp"%>
</body>

</html>