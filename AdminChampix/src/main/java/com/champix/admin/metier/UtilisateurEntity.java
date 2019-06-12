package com.champix.admin.metier;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "utilisateur", schema = "autolib", catalog = "")
public class UtilisateurEntity {
    private Integer idClient;
    private String identifiant;
    private String mdp;
    private ClientEntity clientByIdClient;

    @Basic
    @Id
    @Column(name = "id_client")
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Basic
    @Column(name = "identifiant")
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    @Basic
    @Column(name = "mdp")
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UtilisateurEntity that = (UtilisateurEntity) o;
        return Objects.equals(idClient, that.idClient) &&
                Objects.equals(identifiant, that.identifiant) &&
                Objects.equals(mdp, that.mdp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idClient, identifiant, mdp);
    }

    @ManyToOne
    @JoinColumn(name = "id_client", referencedColumnName = "id_client", updatable = false, insertable = false, nullable = false)
    public ClientEntity getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(ClientEntity clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }
}
