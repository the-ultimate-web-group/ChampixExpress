package com.champix.admin.dao;

import com.champix.admin.errors.MonException;
import com.champix.admin.metier.TypeVehiculeEntity;

import java.util.List;

public class ServiceTypeVehiculeDAO {

	Service monService = Service.getInstance();

	public List<TypeVehiculeEntity> consulterListeTypeVehicules() throws MonException {
		String marequete = "SELECT a FROM TypeVehiculeEntity a ORDER BY a.idTypeVehicule";
		List<Object> maliste = null;
		return (List<TypeVehiculeEntity>)(Object)monService.consulterListe(marequete, maliste);

	}

	public TypeVehiculeEntity typeVehiculeById(int numero) throws MonException {
		TypeVehiculeEntity borne = new TypeVehiculeEntity();
		String marequete ="SELECT a FROM TypeVehiculeEntity a WHERE a.idTypeVehicule="+numero;
		return (TypeVehiculeEntity) monService.objectById(marequete);
	}

	public void insertTypeVehicule(TypeVehiculeEntity uneTypeVehicule) throws MonException
	{
		monService.insert(uneTypeVehicule);
	}

	public void deleteTypeVehicule(TypeVehiculeEntity uneTypeVehicule) throws MonException
	{
		monService.execRequest("DELETE From TypeVehiculeEntity WHERE idTypeVehicule = "+uneTypeVehicule.getIdTypeVehicule());
	}

	public void updateTypeVehicule(TypeVehiculeEntity uneTypeVehicule) throws MonException {
		monService.update(uneTypeVehicule);
	}
}
