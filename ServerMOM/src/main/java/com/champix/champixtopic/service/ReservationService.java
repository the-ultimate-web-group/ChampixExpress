package com.champix.champixtopic.service;

import com.champix.champixtopic.domains.ReservationEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReservationService {

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    private static ReservationService singletonReservation;

    public static ReservationService getInstance() {

        if (singletonReservation != null) return singletonReservation;
        else {
            singletonReservation = new ReservationService();
            return singletonReservation;
        }
    }

    private ReservationService() {

        try {
            factory = Persistence.createEntityManagerFactory("PersistenceUnit");

            entityManager = factory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void save(ReservationEntity reservationEntity) {


        entityManager.getTransaction().begin();

        entityManager.persist(reservationEntity);

        entityManager.flush();

        entityManager.getTransaction().commit();
    }
}
