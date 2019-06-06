package com.champix.clientchampix.repository;

import com.champix.clientchampix.domains.ReservationEntity;
import com.champix.clientchampix.domains.UtilisateurEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationEntityRepository extends JpaRepository<ReservationEntity, Integer> {

    public List<ReservationEntity> findAllByClient(Integer identifiant);

}

