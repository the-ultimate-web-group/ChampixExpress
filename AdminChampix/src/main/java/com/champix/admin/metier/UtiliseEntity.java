package com.champix.admin.metier;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "utilise", schema = "autolib", catalog = "")
@IdClass(UtiliseEntityPK.class)
public class UtiliseEntity {
    private Integer vehicule;
    private Integer client;
    private Timestamp date;
    private Integer borneDepart;
    private Integer borneArrivee;
    private VehiculeEntity vehiculeByVehicule;
    private ClientEntity clientByClient;
    private BorneEntity borneByBorneDepart;
    private BorneEntity borneByBorneArrivee;

    @Id
    @Column(name = "vehicule")
    public Integer getVehicule() {
        return vehicule;
    }

    public void setVehicule(Integer vehicule) {
        this.vehicule = vehicule;
    }

    @Id
    @Column(name = "client")
    public Integer getClient() {
        return client;
    }

    public void setClient(Integer client) {
        this.client = client;
    }

    @Id
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "borne_depart")
    public Integer getBorneDepart() {
        return borneDepart;
    }

    public void setBorneDepart(Integer borneDepart) {
        this.borneDepart = borneDepart;
    }

    @Basic
    @Column(name = "borne_arrivee")
    public Integer getBorneArrivee() {
        return borneArrivee;
    }

    public void setBorneArrivee(Integer borneArrivee) {
        this.borneArrivee = borneArrivee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtiliseEntity that = (UtiliseEntity) o;
        return Objects.equals(vehicule, that.vehicule) &&
                Objects.equals(client, that.client) &&
                Objects.equals(date, that.date) &&
                Objects.equals(borneDepart, that.borneDepart) &&
                Objects.equals(borneArrivee, that.borneArrivee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicule, client, date, borneDepart, borneArrivee);
    }

    @ManyToOne
    @JoinColumn(name = "vehicule", referencedColumnName = "id_vehicule", nullable = false, insertable = false, updatable=false)
    public VehiculeEntity getVehiculeByVehicule() {
        return vehiculeByVehicule;
    }

    public void setVehiculeByVehicule(VehiculeEntity vehiculeByVehicule) {
        this.vehiculeByVehicule = vehiculeByVehicule;
    }

    @ManyToOne
    @JoinColumn(name = "client", referencedColumnName = "id_client", nullable = false, insertable = false, updatable=false)
    public ClientEntity getClientByClient() {
        return clientByClient;
    }

    public void setClientByClient(ClientEntity clientByClient) {
        this.clientByClient = clientByClient;
    }

    @ManyToOne
    @JoinColumn(name = "borne_depart", referencedColumnName = "id_borne", nullable = false, insertable = false, updatable=false)
    public BorneEntity getBorneByBorneDepart() {
        return borneByBorneDepart;
    }

    public void setBorneByBorneDepart(BorneEntity borneByBorneDepart) {
        this.borneByBorneDepart = borneByBorneDepart;
    }

    @ManyToOne
    @JoinColumn(name = "borne_arrivee", referencedColumnName = "id_borne", insertable = false, updatable=false)
    public BorneEntity getBorneByBorneArrivee() {
        return borneByBorneArrivee;
    }

    public void setBorneByBorneArrivee(BorneEntity borneByBorneArrivee) {
        this.borneByBorneArrivee = borneByBorneArrivee;
    }
}
