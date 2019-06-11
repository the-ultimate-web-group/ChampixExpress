package com.champix.admin.dao;

import com.champix.admin.errors.MonException;
import com.champix.admin.metier.VehiculeEntity;

import java.util.List;


public class ServiceVehiculeDAO {

	Service monService = Service.getInstance();

	public List<VehiculeEntity> consulterListeVehicules() throws MonException {
		String marequete = "SELECT a FROM VehiculeEntity a ORDER BY a.idVehicule";
		List<Object> maliste = null;
		return (List<VehiculeEntity>)(Object)monService.consulterListe(marequete, maliste);

	}

	public VehiculeEntity vehiculeById(int numero) throws MonException {
		VehiculeEntity borne = new VehiculeEntity();
		String marequete ="SELECT a FROM VehiculeEntity a WHERE a.idVehicule="+numero;
		return (VehiculeEntity) monService.objectById(marequete);
	}

	public void insertVehicule(VehiculeEntity uneVehicule) throws MonException
	{
		monService.insert(uneVehicule);
	}

	public void deleteVehicule(VehiculeEntity uneVehicule) throws MonException
	{
		monService.execRequest("DELETE From VehiculeEntity WHERE idVehicule = "+uneVehicule.getIdVehicule());
	}

	public void updateVehicule(VehiculeEntity uneVehicule) throws MonException {
		monService.update(uneVehicule);
	}
}
