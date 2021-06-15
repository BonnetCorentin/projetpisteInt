<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@include file="header.jsp" %>
<!-- inspiré de https://bbbootstrap.com/snippets/multi-step-form-wizard-30467045 -->
<div id="main-container" class="container-fluid">
    <div class="row justify-content-center">
        <div class="card form-container col-4">
            <div class="card-body">
                <h2 class="card-title">Connexion</h2>
                <ul id="progress-bar">
                    <li id="login-step" class="active">Identifiant</li>
                    <li id="password-step">Mot de passe</li>
                </ul>
                <form name="f" method="POST" action="getLogin">
                    <fieldset class="step bordered">
                        <legend>Identifiant</legend>
                        <div class="form-floating">
                            <input name="login" type="email" class="form-control" placeholder="E-Mail" tabindex="1"
                                   autofocus required/>
                            <label>E-Mail</label>
                        </div>
                    </fieldset>
                    <fieldset class="step bordered">
                        <legend>Mot de passe</legend>
                        <div class="form-floating">
                            <input name="pwd" type="password" class="form-control" placeholder="Mot de passe"
                                   tabindex="3" required/>
                            <label>Mot de passe</label>
                        </div>
                    </fieldset>
                    <fieldset id="step-buttons">
                        <a href="#" id="previous-step" class="btn btn-primary"><i class="fas fa-step-backward"></i>
                            Précédent</a>
                        <a href="#" id="next-step" class="btn btn-success" tabindex="2">Suivant <i
                                class="fas fa-step-forward"></i></a>
                        <button id="login-button" name="submit" class="btn btn-danger" tabindex="4"><i
                                class="fas fa-sign-in-alt"></i> Connexion
                        </button>
                    </fieldset>
                </form>
            </div>
        </div>
    </div>
</div>
<%@include file="footer.jsp" %>

</html>
