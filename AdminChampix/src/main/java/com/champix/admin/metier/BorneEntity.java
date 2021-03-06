package com.champix.admin.metier;

import javax.persistence.*;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "borne", schema = "autolib", catalog = "")
public class BorneEntity {
    private Integer idBorne;
    private Byte etatBorne;
    private Integer station;
    private Integer idVehicule;
    private StationEntity stationByStation;
    private VehiculeEntity vehiculeByIdVehicule;
    private Collection<UtiliseEntity> utilisesByIdBorne;
    private Collection<UtiliseEntity> utilisesByIdBorne_0;

    @Id
    @Column(name = "id_borne")
    public Integer getIdBorne() {
        return idBorne;
    }

    public void setIdBorne(Integer idBorne) {
        this.idBorne = idBorne;
    }

    @Basic
    @Column(name = "etat_borne")
    public Byte getEtatBorne() {
        return etatBorne;
    }

    public void setEtatBorne(Byte etatBorne) {
        this.etatBorne = etatBorne;
    }

    @Basic
    @Column(name = "station")
    public Integer getStation() {
        return station;
    }

    public void setStation(Integer station) {
        this.station = station;
    }

    @Basic
    @Column(name = "id_vehicule")
    public Integer getIdVehicule() {
        return idVehicule;
    }

    public void setIdVehicule(Integer idVehicule) {
        this.idVehicule = idVehicule;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BorneEntity that = (BorneEntity) o;
        return Objects.equals(idBorne, that.idBorne) &&
                Objects.equals(etatBorne, that.etatBorne) &&
                Objects.equals(station, that.station) &&
                Objects.equals(idVehicule, that.idVehicule);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBorne, etatBorne, station, idVehicule);
    }

    @ManyToOne
    @JoinColumn(name = "station", referencedColumnName = "id_station", nullable = false, insertable = false, updatable=false)
    public StationEntity getStationByStation() {
        return stationByStation;
    }

    public void setStationByStation(StationEntity stationByStation) {
        this.stationByStation = stationByStation;
    }

    @ManyToOne
    @JoinColumn(name = "id_vehicule", referencedColumnName = "id_vehicule", insertable = false, updatable=false)
    public VehiculeEntity getVehiculeByIdVehicule() {
        return vehiculeByIdVehicule;
    }

    public void setVehiculeByIdVehicule(VehiculeEntity vehiculeByIdVehicule) {
        this.vehiculeByIdVehicule = vehiculeByIdVehicule;
    }

    @OneToMany(mappedBy = "borneByBorneDepart")
    public Collection<UtiliseEntity> getUtilisesByIdBorne() {
        return utilisesByIdBorne;
    }

    public void setUtilisesByIdBorne(Collection<UtiliseEntity> utilisesByIdBorne) {
        this.utilisesByIdBorne = utilisesByIdBorne;
    }

    @OneToMany(mappedBy = "borneByBorneArrivee")
    public Collection<UtiliseEntity> getUtilisesByIdBorne_0() {
        return utilisesByIdBorne_0;
    }

    public void setUtilisesByIdBorne_0(Collection<UtiliseEntity> utilisesByIdBorne_0) {
        this.utilisesByIdBorne_0 = utilisesByIdBorne_0;
    }
}
