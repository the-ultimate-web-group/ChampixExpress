package com.champix.clientchampix.controller;

import com.champix.clientchampix.dto.ReservationDTO;
import com.champix.clientchampix.jms.MessageJms;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.util.List;

@RequestMapping("/reservation")
@RestController
@CrossOrigin
public class ReservationController {

    MessageJms messageJms = new MessageJms();

    @RequestMapping(method = RequestMethod.GET, value = "/reservation")
    public ModelAndView getReservation(HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {

        String destinationPage="";
        try {
            destinationPage = "views/reservation";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destinationPage = "views/error";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/askReservation")
    public ModelAndView askReservation(HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {

        String destinationPage="";
        try {
            int idVehicule = Integer.parseInt(request.getParameter("idVehicule"));
            int idClient = Integer.parseInt(request.getParameter("idClient"));
//            Date dateDeb = new Date(request.getParameter("dateDeb"));
//            Date dateFin = Integer.parseInt(request.getParameter("dateFin"));

            //TODO jms call
            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.setIdVehicule(idVehicule);
            reservationDTO.setIdClient(idClient);
//            reservationDTO.setDateDebut(dateDeb);
//            reservationDTO.setDateFin(dateFin);
            messageJms.sendMessage(reservationDTO);

            destinationPage = "/index";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destinationPage = "views/error";
        }
        return new ModelAndView(destinationPage);
    }
}
