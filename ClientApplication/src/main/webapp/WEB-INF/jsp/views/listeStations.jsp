<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="../header.jsp" %>
<body class="liste">
<div class="jumbotron text-center">
    <h1>Liste des réservations</h1>
</div>

<div class="container">
    <div class="container">
        <table class="table table-hover">
            <tr>
                <th class="col-md-1">Numéro de station</th>
                <th class="col-md-2">Ville</th>
                <th class="col-md-2">Adresse</th>
                <th class="col-md-2">Bornes</th>
            </tr>

            <c:forEach items="${stations}" var="item">
                <tr>
                    <td>${item.numero}</td>
                    <td>${item.ville}</td>
                    <td>${item.adresse}</td>
                    <td>
                        <table class="table table-hover">
                            <tr>
                                <td>Borne</td>
                                <td>Etat</td>
                                <td>Type du vehicule</td>
                                <td>Batterie</td>
                            </tr>

                            <c:forEach items="${item.bornesByIdStation}" var="borne">
                                <tr>
                                    <td>borne.idBorne</td>
                                    <td>borne.etatBorne</td>
                                    <c:if test="${borne.etatBorne == 0}">
                                        <td>borne.vehiculeByIdVehicule.typeVehiculeByTypeVehicule.typeVehicule</td>
                                        <td>borne.vehiculeByIdVehicule.etatBatterie</td>
                                    </c:if>

                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                    <td>
                        <c:if test="${item.statut == 'En attente'}">
                            <a class="btn btn-info" href="validerReservation.htm?id=${item.oeuvreventeByIdOeuvrevente.idOeuvrevente}&adh=${item.adherentByIdAdherent.idAdherent}&date=${item.dateReservation}"
                               role="button"><span class="glyphicon glyphicon-ok"></span></a>
                        </c:if>
                    </td>
                    <td>
                        <c:if test="${item.statut != 'Annulee'}">
                            <a class="btn btn-danger" href="annulerReservation.htm?id=${item.oeuvreventeByIdOeuvrevente.idOeuvrevente}&adh=${item.adherentByIdAdherent.idAdherent}&date=${item.dateReservation}"
                               role="button"><span class="glyphicon glyphicon-remove"></span></a>
                        </c:if>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</div>
</body>

</html>