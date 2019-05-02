<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>
<script language="Javascript" type="text/javascript"></script>
<script type="text/javascript" src="js/foncControle.js"></script>
<div class="header-container">
    <h1> Champix Express </h1>
    <h3>Le premier réseau des voitures en libre-service. </h3>
</div>
<div>
    <div class="container">
        <div class="form-group login-form">
            <c:if test="${sessionScope.id == null }">
                <div class="container">
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-6">
                            <div class="col-12">
                                <div class="col-lg-8 d-flex material-box login-form bg-white shadow rounded">
                                    <form action="/auth/login" class="ml-2 mr-2 mt-4 mb-5 w-100">
                                        <hr class="hr"/>
                                        <div class="input-group mb-3">
                                            <label>E-mail</label>
                                            <input type="mail" class="form-control" name="identifiant"
                                                   placeholder="nom.prenom@champix.com" required>
                                        </div>
                                        <div class="input-group mb-3">
                                            <label>Mot de passe</label>
                                            <input type="password" class="form-control" name="mdp"
                                                   placeholder="Mot de passe" required>
                                        </div>
                                        <button type="submit"
                                                class="btn btn-primary btn-block mt-1 text-uppercase font-weight-light"
                                                name="login">Submit
                                        </button>
                                    </form>
                                </div>
                                <div class="col-lg-2"></div>
                            </div>
                        </div>
                        <div class="col-md-6"></div>
                    </div>
                </div>
            </c:if>
        </div>
    </div>
</div>
</body>
</html>