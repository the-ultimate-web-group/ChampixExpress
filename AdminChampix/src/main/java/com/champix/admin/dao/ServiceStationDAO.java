package com.champix.admin.dao;

import com.champix.admin.errors.MonException;
import com.champix.admin.metier.StationEntity;

import java.util.List;


public class ServiceStationDAO {

	Service monService = Service.getInstance();

	public List<StationEntity> consulterListeStations() throws MonException {
		String marequete = "SELECT a FROM StationEntity a ORDER BY a.idStation";
		List<Object> maliste = null;
		return (List<StationEntity>)(Object)monService.consulterListe(marequete, maliste);

	}

	public StationEntity stationById(int numero) throws MonException {
		StationEntity borne = new StationEntity();
		String marequete ="SELECT a FROM StationEntity a WHERE a.idStation="+numero;
		return (StationEntity) monService.objectById(marequete);
	}

	public void insertStation(StationEntity uneStation) throws MonException
	{
		monService.insert(uneStation);
	}

	public void deleteStation(StationEntity uneStation) throws MonException
	{
		monService.execRequest("DELETE From StationEntity WHERE idStation = "+uneStation.getIdStation());
	}

	public void updateStation(StationEntity uneStation) throws MonException {
		monService.update(uneStation);
	}
}
