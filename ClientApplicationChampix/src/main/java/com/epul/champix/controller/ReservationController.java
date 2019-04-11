package com.epul.champix.controller;

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
            destinationPage = "reservation";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destinationPage = "vues/Erreur";
        }
        return new ModelAndView(destinationPage);
    }
}
