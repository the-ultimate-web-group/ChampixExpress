<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<%@ include file="header.jsp" %>

<body id="page-top">

<%@ include file="navbar.jsp" %>

<!-- Header -->
<header class="masthead bg-primary text-white text-center">
    <div class="container">
        <img class="img-fluid mb-5 d-block mx-auto" src="../../resources/img/mushroom.png" alt="" height="256px"
             width="256px">
        <h1 class="text-uppercase mb-0">Champix Express</h1>
        <hr class="star-light">
        <h2 class="font-weight-light mb-0">Le premier reseau des voitures en libre-service</h2>
    </div>
</header>

<c:if test="${sessionScope.id > 0 }">
    <section class="text-white mb-0" id="reserver">
        <div class="container">
            <h2 class="text-center text-uppercase text-secondary mb-0">Reservez votre voiture !</h2>
            <hr class="star-dark mb-5">
        </div>
        <div class="text-center mt-4">

            <a class="btn btn-xl btn-outline-dark" href="/station/listerStations">
                <i class="fas fa-book mr-2"></i>
                Commencer
            </a>
        </div>
    </section>
</c:if>

<c:if test="${sessionScope.id == null}">
    <!-- Login Section -->
    <section class="text-white mb-0" id="connect">
        <div class="container">
            <h2 class="text-center text-uppercase text-secondary mb-0">Connectez-vous pour commencer !</h2>
            <hr class="star-dark mb-5">
            <div class="form-group login-form">
                <c:if test="${sessionScope.id == null }">
                    <div class="container">
                        <div class="row">
                            <div class="col-lg-4 ml-auto">
                                <img src="../../resources/img/man.png" width="256px" height="256px">
                            </div>
                            <div class="col-lg-4 mr-auto">
                                <form action="/auth/login" class="ml-2 mr-2 mt-4 mb-5 w-100">
                                    <hr class="hr"/>
                                    <p class="text-secondary">E-mail</p>
                                    <div class="input-group mb-3">
                                        <input type="mail" class="form-control" name="identifiant"
                                               placeholder="nom.prenom@champix.com" required>
                                    </div>
                                    <p class="text-secondary">Mot de passe</p>
                                    <div class="input-group mb-3">
                                        <input type="password" class="form-control" name="mdp"
                                               placeholder="Mot de passe" required>
                                    </div>
                                    <button type="submit"
                                            class="btn btn-primary btn-block mt-1 text-uppercase font-weight-light"
                                            name="login">Se connecter
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </section>
</c:if>

<!-- About Section -->
<section class="bg-primary text-white mb-0" id="about">
    <div class="container">
        <h2 class="text-center text-uppercase text-white">A propos de nous</h2>
        <hr class="star-light mb-5">
        <div class="row">
            <div class="col-lg-4 ml-auto">
                <p class="lead">Je trouve une voiture en quelques cliques !
                    A Lyon, vous perdez parfois du temps à trouver une place. Avec Champix Express, c'est instantané !
                    Sur le site, je réserve à l'avance ma voiture et ma place de stationnement.</p>
            </div>
            <div class="col-lg-4 mr-auto">
                <p class="lead">Vous pouvez réserver votre voiture et votre place de stationnement à l’avance.
                    L’assurance est incluse dans le prix.
                    Nos voitures sont 100% électrique, elles ne dégagent aucun CO2.
                    Vous bénéficiez d'une assistance 24h/24 7j/7 dans la voiture</p>
            </div>
        </div>
    </div>
</section>

<section class="portfolio" id="voitures">
    <div class="container">
        <h2 class="text-center text-uppercase text-secondary mb-0">Voitures</h2>
        <hr class="star-dark mb-5">
        <div class="row">
            <div class="col-md-6 col-lg-4">
                <p class="text-center text-uppercase text-secondary">Citadine</p>
                <img class="img-fluid" src="../../resources/img/cars/citadine.png" alt="">
            </div>
            <div class="col-md-6 col-lg-4">
                <p class="text-center text-uppercase text-secondary">Utilitaire</p>
                <img class="img-fluid" src="../../resources/img/cars/utilitaire.png" alt="">
            </div>
            <div class="col-md-6 col-lg-4">
                <p class="text-center text-uppercase text-secondary">Familiale</p>
                <img class="img-fluid" src="../../resources/img/cars/familiale.png" alt="">
            </div>
        </div>
    </div>
</section>

<!-- Footer -->
<%@ include file="footer.jsp" %>

</body>

</html>
