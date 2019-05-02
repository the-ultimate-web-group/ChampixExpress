<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../header.jsp" %>
<body class="liste">
<div class="jumbotron text-center">
    <h1>Liste des vehicules</h1>
</div>

<div class="container">
    <div class="container">
        <table class="table table-hover">
            <tr>

            </tr>

            <c:forEach items="${vehicules}" var="item">
                <tr>

                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>