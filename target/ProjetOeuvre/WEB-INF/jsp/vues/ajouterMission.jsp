<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="header.jsp" %>
<body>
<%@include file="navigation.jsp"%>
<div class="jumbotron text-center">
<H1> Ajout d'une mission </H1>
</div>
<form method="post" action="insererMission" onsubmit="return teste()">
<div class="col-md-12 well well-md">
    <h1>Ajouter Mission</h1>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 control-label">Nom de la mission :</label>
        <div class="col-md-3">
            <INPUT type="text" name="wording" value="" id="wording" class="form-control" min="0">
        </div>

    </div>
    <div class="row" >
        <div class="col-md-12" style ="border:none; background-color:transparent; height :20px;">
        </div>
    </div>

    <div class="form-group">
        <button type="submit" class="btn btn-default btn-primary"><span class="glyphicon glyphicon-ok"></span>
            Ajouter
        </button>

    </div>
</div>
</form>
<%@include file="footer.jsp"%>
</body>

</html>