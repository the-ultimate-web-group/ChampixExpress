package com.champix.admin.dao;

import com.champix.admin.errors.MonException;
import com.champix.admin.metier.UtiliseEntity;

import java.util.List;


public class ServiceUtiliseDAO {

	Service monService = Service.getInstance();

	public List<UtiliseEntity> consulterListeUtilises() throws MonException {
		String marequete = "SELECT a FROM UtiliseEntity a ORDER BY a.idUtilise";
		List<Object> maliste = null;
		return (List<UtiliseEntity>)(Object)monService.consulterListe(marequete, maliste);

	}

	public UtiliseEntity utiliseById(int numero) throws MonException {
		UtiliseEntity borne = new UtiliseEntity();
		String marequete ="SELECT a FROM UtiliseEntity a WHERE a.idUtilise="+numero;
		return (UtiliseEntity) monService.objectById(marequete);
	}

	public void insertUtilise(UtiliseEntity uneUtilise) throws MonException
	{
		monService.insert(uneUtilise);
	}

//	public void deleteUtilise(UtiliseEntity uneUtilise) throws MonException
//	{
//		monService.execRequest("DELETE From UtiliseEntity WHERE idVe = "+uneUtilise.getIdUtilise());
//	}

	public void updateUtilise(UtiliseEntity uneUtilise) throws MonException {
		monService.update(uneUtilise);
	}
}
