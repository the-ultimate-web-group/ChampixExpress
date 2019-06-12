<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<%@include file="vues/header.jsp" %>
<body>
<div id="header">
    <h1>Planning des réservations</h1>
    <form id="form" action="/" method="get">

        <h2>Véhicule</h2>
        <select id="selectVehicule" name="vehicule">
            <option value="0">Tous</option>
            <c:forEach items="${mesVehicules}" var="vehicule">
                <option value="${vehicule.idVehicule}">Véhicule n°${vehicule.idVehicule}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Afficher">
    </form>
</div>

<div id="page">
    <script>

        document.addEventListener('DOMContentLoaded', function() {
            var calendarEl = document.getElementById('calendar');

            var calendar = new FullCalendar.Calendar(calendarEl, {
                plugins: [ 'dayGrid' ],
                <c:if test="${fn:length(mesReservations) gt 0}">
                    defaultDate: '${fn:substring(mesReservations[0].dateReservation,0,10)}',
                </c:if>
                events: [
                    <c:forEach items="${mesReservations}" var="reservation">
                    {
                        title: '${reservation.clientByClient.nom}, Véhicule n°${reservation.vehicule}',
                        start: '${reservation.dateReservation}',
                        end: '${reservation.dateEcheance}'
                    },
                    </c:forEach>
                ]
            });

            calendar.render();
        });

    </script>

    <div id="conteneur">
        <div id='calendar'></div>
    </div>
</div>
</body>

</html>