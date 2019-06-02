<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../header.jsp" %>
<body>
<div class="col-md-12 well well-md">
    <center><h1>Gestion des erreurs </h1></center>
</div>
<c:if test="${erreur != null}">
    <div class="alert-danger" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <c:out value="${erreur}" />
    </div>
</c:if>
<c:if test="${error != null}">
    <div class="alert-danger" role="alert">
        <span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
        <c:out value="${error}" />
    </div>
</c:if>

<div class="form-group">
    <div class="col-md-6 col-md-offset-3">
        <button type="button" class="btn btn-default btn-primary"  onclick="relocate_home()">
            <span class="glyphicon glyphicon-log-in"></span>
            Valider
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