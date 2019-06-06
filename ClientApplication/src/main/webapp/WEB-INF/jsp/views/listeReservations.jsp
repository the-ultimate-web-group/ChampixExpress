<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<%@ include file="../header.jsp" %>

<body id="page-top">

<section class="bg-primary text-white mb-0">
    <h2 class="text-center text-uppercase text-white">Mes reservations</h2>
    <hr class="star-light mb-5">

    <div class="container">
        <table class="table bg-white table-hover">
            <tr>
                <th>Vehicule</th>
                <th>Categorie</th>
                <th>Type</th>
                <th>Début réservation</th>
                <th>Echéance</th>
            </tr>
            <c:forEach items="${reservations}" var="item">
                <tr>
                    <td>${item.vehiculeByVehicule.idVehicule}</td>
                    <td>${item.vehiculeByVehicule.typeVehiculeByTypeVehicule.categorie}</td>
                    <td>${item.vehiculeByVehicule.typeVehiculeByTypeVehicule.typeVehicule}</td>
                    <td>${item.dateReservation}</td>
                    <td>${item.dateEcheance}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
</section>

<!-- Footer -->
<%@ include file="../footer.jsp" %>

</body>

</html>