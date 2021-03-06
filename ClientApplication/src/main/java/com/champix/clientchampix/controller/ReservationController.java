package com.champix.clientchampix.controller;

import com.champix.clientchampix.domains.ReservationEntity;
import com.champix.clientchampix.jms.JmsService;
import com.champix.clientchampix.jwt.JWTManager;
import com.champix.clientchampix.repository.ReservationEntityRepository;
import com.champix.dto.ReservationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.jms.Topic;
import javax.jms.TopicConnectionFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;

@RequestMapping("/reservation")
@RestController
@CrossOrigin
public class ReservationController {

    private ReservationEntityRepository reservationEntityRepository;

    JmsService messageJms = new JmsService();

    @Resource(mappedName = "java:/ConnectionFactory")
    TopicConnectionFactory topicConnectionFactory;

    @Resource(lookup = "java:jboss/exported/topic/ChampixTopic")
    Topic topic;

    @Autowired
    ReservationController(ReservationEntityRepository reservationEntityRepository) {
        this.reservationEntityRepository = reservationEntityRepository;
    }

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

        @RequestMapping(method = RequestMethod.POST, value = "/envoiReservation")
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
            reservationDTO.setDateReservation(dateDeb);
            reservationDTO.setDateEcheance(dateFin);
            messageJms.sendMessage(reservationDTO, topicConnectionFactory, topic);

            destinationPage = "/index";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destinationPage = "views/error";
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservations")
    public ModelAndView getAllReservationUser(HttpServletRequest request,
                                       HttpServletResponse response) throws Exception {
        if (!checkJWTSession(request))
            return new ModelAndView("/index");

        String destinationPage="";
        try {
            HttpSession session = request.getSession();
            int idClient = (int) session.getAttribute("id");
            List<ReservationEntity> reservationEntities = reservationEntityRepository.findAllByClient(idClient);
            System.out.println(reservationEntities);
            request.setAttribute("reservations",reservationEntities);
            destinationPage = "views/listeReservations";
        } catch (Exception e) {
            request.setAttribute("error", e.getMessage());
            destinationPage = "views/error";
        }
        return new ModelAndView(destinationPage);
    }
    
    private boolean checkJWTSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("id") == null || !JWTManager.verify((String) session.getAttribute("jwt"))) {
            session.removeAttribute("id");
            session.removeAttribute("jwt");
            request.setAttribute("error", "Session expired");
            return false;
        }
        return true;
    }
}
