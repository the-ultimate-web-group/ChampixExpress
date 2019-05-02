<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html  xmlns="http://www.w3.org/1999/xhtml" xml:lang="fr">
<head>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <link rel="stylesheet"  type="text/css" href="<c:url value="../../../resources/css/style.css"/>">

    <script language="JavaScript">
        function fermer() {
            window.close();
        }
    </script>
    <meta charset="UTF-8">
    <title>${title}</title>
</head>
<body>
<nav class="navbar navbar-inverse inscription-header">
    <div class="container-fluid">
        <div class="navbar-header">
            <a id="logo_polytech" class="navbar-brand" href="index.jsp"> <img src="../../../resources/images/logo.png"
                                                                              height="50px" alt="logo polytech"></a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="index">Accueil</a></li>
            <c:if test="${sessionScope.id == null }">
                <li><a href="/reservation/reservation">Reservation</a></li>
                <li><a href="/station/listerStations">Stations</a></li>
            </c:if>
            <c:if test="${sessionScope.id > 0  }">
                <li><a href="/reservation/reservation">Reservation</a></li>
                <li><a href="/station/listerStations">Stations</a></li>
                <li><a href="javascript:window.close();"><span class="glyphicon glyphicon-log-out"></span> Quitter</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>

