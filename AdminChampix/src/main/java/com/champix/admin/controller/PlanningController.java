package com.champix.admin.controller;

import com.champix.admin.dao.*;
import com.champix.admin.errors.MonException;
import com.champix.admin.metier.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class PlanningController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView afficherPlanningGlobal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        try {
            ServiceReservationDAO monServiceReservation = new ServiceReservationDAO();
            ServiceVehiculeDAO monServiceVehicule = new ServiceVehiculeDAO();

            List<ReservationEntity> mesReservations = monServiceReservation.consulterListeReservations((request.getParameter("vehicule") != null  ? request.getParameter("vehicule") : "0" ));
            List<VehiculeEntity> mesVehicules = monServiceVehicule.consulterListeVehicules();

            request.setAttribute("mesReservations",mesReservations);
            request.setAttribute("mesVehicules",mesVehicules);
            destinationPage = "index";
        } catch (MonException e) {
            request.setAttribute("erreur", e.getMessage());
            destinationPage = "/err";
        }
        return new ModelAndView(destinationPage);
    }
}
