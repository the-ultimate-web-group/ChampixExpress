package com.champix.clientchampix.domains;

import com.champix.clientchampix.security.MD5;

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
    @Column(name = "idClient", nullable = false)
    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    @Id
    @Column(name = "identifiant", nullable = false, length = 45)
    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    @Basic
    @Column(name = "mdp", nullable = false, length = 45)
    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp, boolean isEncrypted) {
        if (isEncrypted)
            this.mdp = mdp;
        else
            this.mdp = MD5.hash(mdp);
    }
    public void setMdp(String mdp) {
        if (mdp.length() == 32)
            setMdp(mdp, true);
        else
            setMdp(mdp, false);
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
    @JoinColumn(name = "idClient", referencedColumnName = "idClient", nullable = false, updatable = false, insertable = false)
    public ClientEntity getClientByIdClient() {
        return clientByIdClient;
    }

    public void setClientByIdClient(ClientEntity clientByIdClient) {
        this.clientByIdClient = clientByIdClient;
    }
}
