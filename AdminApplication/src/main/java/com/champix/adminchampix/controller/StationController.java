package com.champix.adminchampix.controller;

import com.champix.adminchampix.domains.StationEntity;
import com.champix.adminchampix.repository.StationEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping("/station")
@RestController
@CrossOrigin
public class StationController {
    private StationEntityRepository stationEntityRepository;

    @Autowired
    public StationController(StationEntityRepository stationEntityRepository) {
        this.stationEntityRepository = stationEntityRepository;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listerStations")
    public ModelAndView getReservation(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {

        String destinationPage="";
        try {
            List<StationEntity> stations = stationEntityRepository.findAll();

            request.setAttribute("stations", stations);
            destinationPage = "views/listeStations";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destinationPage = "views/error";
        }
        return new ModelAndView(destinationPage);
    }
}
