package com.champix.clientchampix.controller;

import com.champix.clientchampix.jms.MessageJms;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/reservation")
@RestController
@CrossOrigin
public class ReservationController {

    @RequestMapping(method = RequestMethod.GET, value = "/reservation")
    public ModelAndView getReservation(HttpServletRequest request,
                                     HttpServletResponse response) throws Exception {

        String destinationPage="";
        try {
            int idVehicule = Integer.parseInt(request.getParameter("idVehicule"));
            int idClient = Integer.parseInt(request.getParameter("idClient"));

//            StringBuilder message = new StringBuilder();
//            MessageJms messageJms = new MessageJms();
//            messageJms.sendMessage(" ");
            //TODO jms call

            destinationPage = "/index";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destinationPage = "views/error";
        }
        return new ModelAndView(destinationPage);
    }
}
