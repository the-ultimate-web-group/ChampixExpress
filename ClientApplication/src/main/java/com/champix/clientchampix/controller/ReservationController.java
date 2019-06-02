package com.champix.clientchampix.controller;

import com.champix.clientchampix.dto.ReservationDTO;
import com.champix.clientchampix.jms.MessageJms;
import com.champix.clientchampix.jwt.JWTManager;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;

@RequestMapping("/reservation")
@RestController
@CrossOrigin
public class ReservationController {

    MessageJms messageJms = new MessageJms();

    @RequestMapping(method = RequestMethod.GET, value = "/reservation")
    public ModelAndView getReservation(HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {
        if (!checkJWTSession(request))
            return new ModelAndView("/index");
        
        String destinationPage="";
        try {
            request.setAttribute("idVehicule", request.getParameter("idVehicule"));
            destinationPage = "views/reservation";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destinationPage = "views/error";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/envoiReservation")
    public ModelAndView envoiReservation(HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {
        if (!checkJWTSession(request))
            return new ModelAndView("/index");

        String destinationPage="";
        try {
            int idVehicule = Integer.parseInt(request.getParameter("idVehicule"));
            HttpSession session = request.getSession();
            int idClient = (int) session.getAttribute("id");
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = simpleDateFormat.parse(request.getParameter("dateDeb"));
            Date dateDeb = new java.sql.Date(date.getTime());
            java.util.Date date2 = simpleDateFormat.parse(request.getParameter("dateFin"));
            Date dateFin = new java.sql.Date(date2.getTime());

            //TODO jms call
            ReservationDTO reservationDTO = new ReservationDTO();
            reservationDTO.setIdVehicule(idVehicule);
            reservationDTO.setIdClient(idClient);
            reservationDTO.setDateDebut(dateDeb);
            reservationDTO.setDateFin(dateFin);
            System.out.println(reservationDTO);
            messageJms.sendMessage(reservationDTO);

            destinationPage = "/index";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destinationPage = "views/error";
        }
        return new ModelAndView(destinationPage);
    }
    
    private boolean checkJWTSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (!JWTManager.verify((String) session.getAttribute("jwt"))) {
            session.setAttribute("id", null);
            session.setAttribute("jwt", null);
            request.setAttribute("error", "Session expired");
            return false;
        }
        return true;
    }
}
