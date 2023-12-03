package com.uexcel;

import org.hibernate.jpa.HibernatePersistenceProvider;

import com.uexcel.entity.Product;
import com.uexcel.persistence.CustomPersistenceUnitInfo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
// import jakarta.persistence.Persistence;

import java.util.HashMap;

public class App {
    public static void main(String[] args) {

        // EntityManagerFactory entityManagerFactory =
        // Persistence.createEntityManagerFactory("my-persistence-unit");

        // I PREFERE XML METHOD

        EntityManagerFactory entityManagerFactory = new HibernatePersistenceProvider()
                .createContainerEntityManagerFactory(
                        new CustomPersistenceUnitInfo(),
                        new HashMap<>());

        EntityManager entityManager = entityManagerFactory.createEntityManager(); // It represents the context

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(new Product(4L, "Chocolate"));
            entityManager.getTransaction().commit();
        } catch (Exception e) {

        } finally {
            entityManager.close();
        }

    }
}
