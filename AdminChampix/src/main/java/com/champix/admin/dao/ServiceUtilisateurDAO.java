package com.champix.admin.dao;

import com.champix.admin.errors.MonException;
import com.champix.admin.metier.UtilisateurEntity;

import java.util.List;


public class ServiceUtilisateurDAO {

	Service monService = Service.getInstance();

	public List<UtilisateurEntity> consulterListeUtilisateurs() throws MonException {
		String marequete = "SELECT a FROM UtilisateurEntity a ORDER BY a.idUtilisateur";
		List<Object> maliste = null;
		return (List<UtilisateurEntity>)(Object)monService.consulterListe(marequete, maliste);

	}

	public UtilisateurEntity utilisateurById(int numero) throws MonException {
		UtilisateurEntity borne = new UtilisateurEntity();
		String marequete ="SELECT a FROM UtilisateurEntity a WHERE a.idUtilisateur="+numero;
		return (UtilisateurEntity) monService.objectById(marequete);
	}

	public void insertUtilisateur(UtilisateurEntity uneUtilisateur) throws MonException
	{
		monService.insert(uneUtilisateur);
	}

	public void deleteUtilisateur(UtilisateurEntity uneUtilisateur) throws MonException
	{
		monService.execRequest("DELETE From UtilisateurEntity WHERE idUtilisateur = "+uneUtilisateur.getIdentifiant());
	}

	public void updateUtilisateur(UtilisateurEntity uneUtilisateur) throws MonException {
		monService.update(uneUtilisateur);
	}
}
