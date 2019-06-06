package com.champix.dto;

import java.io.Serializable;
import java.sql.Date;

public class ReservationDTO implements Serializable {

    private int idClient;
    private int idVehicule;

    private Date dateReservation;
    private Date dateEcheance;

    public int getIdClient() {
        return idClient;
    }

    public int getIdVehicule() {
        return idVehicule;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }

    public Date getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Date dateReservation) {
        this.dateReservation = dateReservation;
    }

    public Date getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Date dateEcheance) {
        this.dateEcheance = dateEcheance;
    }
}
