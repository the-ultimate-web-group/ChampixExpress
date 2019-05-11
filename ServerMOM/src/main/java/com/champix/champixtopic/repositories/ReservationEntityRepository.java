package com.champix.champixtopic.repositories;

import com.champix.champixtopic.domains.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Timestamp;
import java.util.Optional;

public interface ReservationEntityRepository extends JpaRepository<ReservationEntity, Integer> {

    Optional<ReservationEntity> findByClientAndDateReservation(Integer clientId, Timestamp dateReservation);

    Optional<ReservationEntity> findByVehiculeAndDateReservation(Integer vehiculeId, Timestamp dateReservation);
}
