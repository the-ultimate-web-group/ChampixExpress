package com.champix.admin.dao;

import com.champix.admin.errors.MonException;
import com.champix.admin.metier.BorneEntity;

import java.util.List;


public class ServiceBorneDAO {

	Service monService = Service.getInstance();

	public List<BorneEntity> consulterListeBornes() throws MonException {
		String marequete = "SELECT a FROM BorneEntity a ORDER BY a.idBorne";
		List<Object> maliste = null;
		return (List<BorneEntity>)(Object)monService.consulterListe(marequete, maliste);

	}

	public BorneEntity borneById(int numero) throws MonException {
		BorneEntity borne = new BorneEntity();
		String marequete ="SELECT a FROM BorneEntity a WHERE a.idBorne="+numero;
		return (BorneEntity) monService.objectById(marequete);
	}

	public void insertBorne(BorneEntity uneBorne) throws MonException
	{
		monService.insert(uneBorne);
	}

	public void deleteBorne(BorneEntity uneBorne) throws MonException
	{
		monService.execRequest("DELETE From BorneEntity WHERE idBorne = "+uneBorne.getIdBorne());
	}

	public void updateBorne(BorneEntity uneBorne) throws MonException {
		monService.update(uneBorne);
	}
}
