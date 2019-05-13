<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<%@ include file="../header.jsp" %>

<body id="page-top">

<section class="bg-primary text-white mb-0">
    <h2 class="text-center text-uppercase text-white">Reservation</h2>
    <hr class="star-light mb-5">

    <div class="container">
        <table class="table bg-white table-hover">
            <tr>
                <th>Ville</th>
                <th>Adresse</th>
                <th>Bornes</th>
            </tr>
            <c:forEach items="${stations}" var="item">
                <tr>
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
                                    <td>${borne.idBorne}</td>
                                    <c:if test="${borne.etatBorne == 0}">
                                        <td> <p class="label-etat libre"> Libre </p></td>
                                        <td>${borne.vehiculeByIdVehicule.typeVehiculeByTypeVehicule.typeVehicule}</td>
                                        <td>${borne.vehiculeByIdVehicule.etatBatterie}</td>
                                        <td>
                                            <a class="btn btn-info"
                                               href="/reservation/reservation?idVehicule=${borne.vehiculeByIdVehicule.idVehicule}"
                                               role="button">
                                                <i class="fas fa-calendar-alt mr-2"></i>
                                            </a>
                                        </td>
                                    </c:if>
                                    <c:if test="${borne.etatBorne != 0}">
                                        <td> <p class="label-etat occupe"> En utilisation </p></td>
                                    </c:if>

                                </tr>
                            </c:forEach>
                        </table>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>

<!-- Footer -->
<%@ include file="../footer.jsp" %>

</body>

</html>