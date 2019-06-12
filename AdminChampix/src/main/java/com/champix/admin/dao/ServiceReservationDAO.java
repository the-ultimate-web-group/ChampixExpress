package com.champix.admin.dao;

import com.champix.admin.errors.MonException;
import com.champix.admin.metier.ReservationEntity;

import java.util.List;

public class ServiceReservationDAO {

	private Service monService;

	public ServiceReservationDAO() {
		monService = Service.getInstance();
	}

	public List<ReservationEntity> consulterListeReservations() throws MonException {
		String marequete = "FROM ReservationEntity a ORDER BY a.dateReservation DESC";
		List<Object> maliste = null;
		return (List<ReservationEntity>)(Object)monService.consulterListe(marequete, maliste);

	}

	public List<ReservationEntity> consulterListeReservations(String vehicule) throws MonException {
		if (Integer.parseInt(vehicule)==0) return this.consulterListeReservations();
		String marequete = "FROM ReservationEntity a WHERE vehicule = "+vehicule+" ORDER BY a.dateReservation DESC";
		List<Object> maliste = null;
		return (List<ReservationEntity>)(Object)monService.consulterListe(marequete, maliste);

	}

	public ReservationEntity reservationById(int numero) throws MonException {
		ReservationEntity borne = new ReservationEntity();
		String marequete ="FROM ReservationEntity a WHERE a.Vehicule="+numero;
		return (ReservationEntity) monService.objectById(marequete);
	}

	public void insertReservation(ReservationEntity uneReservation) throws MonException
	{
		monService.insert(uneReservation);
	}

//	public void deleteReservation(ReservationEntity uneReservation) throws MonException
//	{
//		monService.execRequest("DELETE From ReservationEntity WHERE idReservation = "+uneReservation.getIdReservation());
//	}

	public void updateReservation(ReservationEntity uneReservation) throws MonException {
		monService.update(uneReservation);
	}
}
