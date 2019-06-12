package com.champix.admin.metier;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "reservation", schema = "autolib", catalog = "")
@IdClass(ReservationEntityPK.class)
public class ReservationEntity {
    private Integer vehicule;
    private Integer client;
    private Timestamp dateReservation;
    private Timestamp dateEcheance;
    private VehiculeEntity vehiculeByVehicule;
    private ClientEntity clientByClient;

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
    @Column(name = "date_reservation")
    public Timestamp getDateReservation() {
        return dateReservation;
    }

    public void setDateReservation(Timestamp dateReservation) {
        this.dateReservation = dateReservation;
    }

    @Basic
    @Column(name = "date_echeance")
    public Timestamp getDateEcheance() {
        return dateEcheance;
    }

    public void setDateEcheance(Timestamp dateEcheance) {
        this.dateEcheance = dateEcheance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ReservationEntity that = (ReservationEntity) o;
        return Objects.equals(vehicule, that.vehicule) &&
                Objects.equals(client, that.client) &&
                Objects.equals(dateReservation, that.dateReservation) &&
                Objects.equals(dateEcheance, that.dateEcheance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vehicule, client, dateReservation, dateEcheance);
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
}
