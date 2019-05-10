package com.champix.adminchampix.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            destinationPage = "views/error";
        }
        return new ModelAndView(destinationPage);
    }
}
