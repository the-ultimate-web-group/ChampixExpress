package com.champix.clientchampix.dto;

import java.io.Serializable;
import java.sql.Date;

public class ReservationDTO implements Serializable {
    private int idClient;
    private int idVehicule;

    private Date dateDebut;
    private Date dateFin;

    public int getIdClient() {
        return idClient;
    }

    public int getIdVehicule() {
        return idVehicule;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public void setIdVehicule(int idVehicule) {
        this.idVehicule = idVehicule;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
}

