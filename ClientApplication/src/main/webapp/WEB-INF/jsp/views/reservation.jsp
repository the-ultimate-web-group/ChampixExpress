<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<%@ include file="../header.jsp" %>

<body id="page-top">

<section class="bg-primary text-white mb-0">
    <div class="container">
        <h2 class="text-center text-uppercase text-white">Reservation</h2>
        <hr class="star-light mb-5">
        <form action='${pageContext.request.contextPath}/reservation/envoiReservation?idVehicule=${idVehicule}' onsubmit="return verif(this);">
            <div>
                <div class="container">
                    <div class="well">
                        <h1>Ajouter une réservation</h1>
                        <div class="row">
                            <div class="col-lg-4 ml-auto">
                                <p> Début de votre résevation:</p>
                                <div class="form-group">
                                    <input type="date" name="dateDeb" id="dateDeb" class="form-control" min="0">
                                </div>
                                <p> Fin de votre réservation :</p>
                                <div class="form-group">
                                    <input type = "date" name="dateFin" id="dateFin" class="form-control" min="0">
                                </div>
                            </div>
                            <div class="col-lg-4 mr-auto">
                                <img
                                        src="../../../resources/img/car.svg"
                                        alt="car" height="248px" width="248px"/>
                            </div>
                        </div>
                        <div class="text-center mt-4">
                            <button type="submit" class="btn btn-xl btn-outline-light"> Valider
                            </button>
                            <button type="button" class="btn btn-xl btn-outline-light"
                                    onclick="relocate_home()"> Annuler
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>

<!-- Footer -->
<%@ include file="../footer.jsp" %>

</body>
</html>
