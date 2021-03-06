package com.champix.clientchampix.repository;

import com.champix.clientchampix.domains.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurEntityRepository extends JpaRepository<UtilisateurEntity, Integer> {

    public UtilisateurEntity findByIdentifiant(String identifiant);

}

