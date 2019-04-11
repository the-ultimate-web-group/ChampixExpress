<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="refresh" content="0;URL=javascript:fermer();">
    <title> TP Inscription </title>
    <link rel="stylesheet" href="resources/css/bootstrap.min.css">
    <link rel="stylesheet" href="resources/css/style.css">
    <link rel="stylesheet" href="resources/css/jquery-ui.min.css">
    <script src="resources/js/jquery-3.3.1.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/jquery-ui.min.js"></script>
</head>
<body>
<nav class="navbar navbar-inverse inscription-header">
    <div class="container-fluid">
        <div class="navbar-header">
            <a id="logo_polytech" class="navbar-brand" href="index.jsp"> <img src="resources/images/logo.png"
                                                                              height="50px"></a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="index.jsp">Accueil</a></li>
            <c:if test="${sessionScope.id == null }">

                <li><a href="/reservation/reservation.jsp">Reservation</a></li>
            </c:if>
            <c:if test="${sessionScope.id > 0  }">
                <li><a href="/reservation/reservation.jsp">Reservation</a></li>
                <li><a href="javascript:window.close();"><span class="glyphicon glyphicon-log-out"></span> Quitter</a>
                </li>
            </c:if>
        </ul>
    </div>
</nav>
<br><br><br><br>

