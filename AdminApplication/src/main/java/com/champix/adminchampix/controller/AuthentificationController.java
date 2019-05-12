package com.champix.adminchampix.controller;

import com.champix.adminchampix.domains.UtilisateurEntity;
import com.champix.adminchampix.repository.UtilisateurEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RequestMapping("/auth")
@RestController
@CrossOrigin
public class AuthentificationController {

    private UtilisateurEntityRepository unUtilisateurRepostory;

    // on initialise
    @Autowired
    public AuthentificationController(UtilisateurEntityRepository UtilisateurRepostory) {
        this.unUtilisateurRepostory = UtilisateurRepostory;
    }

    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        {
            String identifiant = request.getParameter("identifiant");
            String mdp = request.getParameter("mdp");
            String message ="";

            UtilisateurEntity unUtilisateur;
            unUtilisateur = unUtilisateurRepostory.findByIdentifiant(identifiant);
            if (unUtilisateur != null)
            {
                // TODO : améliorer avec un hash du mdp
                if (unUtilisateur.getMdp().equals(mdp)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("id", unUtilisateur.getIdClient());
                    destinationPage = "/index";
                } else {
                    message = "mot de passe erroné";
                    request.setAttribute("message", message);
                    destinationPage = "/views/formLogin";
                }
            } else {
                message = "login erroné";
                request.setAttribute("message", message);
                destinationPage = "/views/formLogin";
            }
        }
        return new ModelAndView(destinationPage);
    }
}