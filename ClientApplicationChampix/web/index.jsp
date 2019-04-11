<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="header.jsp" %>
<script language="Javascript" type="text/javascript"></script>
<script type="text/javascript" src="js/foncControle.js"></script>

<div>
    <div class="container">
        <div class="form-group">
            <label> Champix Express </label>
            <BR> <BR>
            <label>Le premier réseau des voitures en libre-service. </label>
            <c:if test="${sessionScope.id == null }">
                <%--<a class="button" href="/auth/login">--%>
                <%--<span class="glyphicon glyphicon-user"></span>--%>
                <%--Se Connecter--%>
                <%--</a>--%>

                <div class="container">
                    <div class="row d-flex justify-content-center">
                        <div class="col-md-6">
                            <div class="col-12">
                                <div class="col-lg-8 d-flex material-box login-form bg-white shadow rounded">
                                    <form action="/auth/login" class="ml-2 mr-2 mt-4 mb-5 w-100">
                                        <h1 class="h3 mb-2 text-primary">Login</h1>
                                        <hr class="hr"/>
                                        <div class="input-group mb-3">
                                            <input type="text" class="form-control" name="username"
                                                   placeholder="Username" required>
                                        </div>
                                        <div class="input-group mb-3">
                                            <input type="password" class="form-control" name="password"
                                                   placeholder="Password" required>
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