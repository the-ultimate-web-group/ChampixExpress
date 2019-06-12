<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="header.jsp" %>
<%@include file="navigation.jsp"%>

<body>
<div class="col-md-12 well well-md">
    <h1>Gestion des erreurs </h1>
</div>
<!-- TODO gestion des erreurs -->
    <div class="alert-danger" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        Erreur : ${erreur}
    </div>

<br><br>
<div class="form-group">
    <div class="col-md-6 col-md-offset-3">
        <button type="button" class="btn btn-default btn-primary"  onclick="relocate_home()">
            <span class="glyphicon glyphicon-log-out"></span>
             Retour à l'accueil
        </button>
    </div>
</div>


<script>
    function relocate_home()
    {
        location.href = "..";
    }
</script>
</body>
</html>