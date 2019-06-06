package com.champix.clientchampix.controller;

import com.champix.clientchampix.domains.UtilisateurEntity;
import com.champix.clientchampix.jwt.JWTManager;
import com.champix.clientchampix.repository.UtilisateurEntityRepository;
import com.champix.clientchampix.security.MD5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.security.auth.login.LoginException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

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
            String mdp = MD5.hash(request.getParameter("mdp"));
            String message ="";

            UtilisateurEntity unUtilisateur;
            unUtilisateur = unUtilisateurRepostory.findByIdentifiant(identifiant);
            if (unUtilisateur != null)
            {
                if (unUtilisateur.getMdp().equals(mdp)) {
                    HttpSession session = request.getSession();
                    session.setAttribute("id", unUtilisateur.getIdClient());
                    session.setAttribute("jwt", new JWTManager.Builder()
                            .setId(unUtilisateur.getIdClient().toString())
                            .setExpiredAfterMillis(3600000L)
                            .build());
                    destinationPage = "/index";
                } else {
                    message = "mot de passe erroné";
                    request.setAttribute("erreur", message);
                    destinationPage = "/views/error";
                }
            } else {
                message = "login erroné";
                request.setAttribute("erreur", message);
                destinationPage = "/views/error";
            }
        }
        return new ModelAndView(destinationPage);
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String destinationPage;
        {
            HttpSession session = request.getSession();
            session.removeAttribute("id");
            destinationPage = "/index";
        }
        return new ModelAndView(destinationPage);
    }
}
