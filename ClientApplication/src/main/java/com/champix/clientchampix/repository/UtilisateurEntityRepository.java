package com.epul.champix.repositories;

import com.epul.champix.models.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurEntityRepository extends JpaRepository<UtilisateurEntity, Integer> {

    public UtilisateurEntity findByIdentifiant(String identifiant);

}

