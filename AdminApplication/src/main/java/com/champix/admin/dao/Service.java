package com.champix.admin.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Service {

    private EntityManagerFactory factory;
    private EntityManager entityManager;

    private static Service singletonReservation;

    public static Service getInstance() {

        if (singletonReservation != null) return singletonReservation;
        else {
            singletonReservation = new Service();
            return singletonReservation;
        }
    }

    private Service() {

        try {
            factory = Persistence.createEntityManagerFactory("persistenceUnit");

            entityManager = factory.createEntityManager();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    public void insert(Object unOb) {

        entityManager.getTransaction().begin();

        entityManager.persist(unOb);

        entityManager.flush();

        entityManager.getTransaction().commit();
    }

    public void update(Object unOb) {

        entityManager.getTransaction().begin();

        entityManager.merge(unOb);

        entityManager.flush();

        entityManager.getTransaction().commit();
    }

    //delete
    public void execRequest(String marequete) {
        entityManager.createQuery(marequete).executeUpdate();
    }

    public List<Object> consulterListe(String marequete, List<Object> maliste) {
        maliste = entityManager.createQuery(marequete).getResultList();
        return maliste;
    }

    public Object objectById(String marequete) {
        return entityManager.createQuery(marequete).getResultList().get(0);
    }

}
