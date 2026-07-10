package com.cognizant.comparison;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.springframework.data.jpa.repository.JpaRepository;
public class JPAComparison {
    public static void main(String[] args) {

        System.out.println("===== JPA vs Hibernate vs Spring Data JPA =====");

        Product product = new Product(101, "Laptop", 65000);

        System.out.println("\nSample Product:");
        System.out.println(product);

        showJPA();

        showHibernate();

        showSpringDataJPA();

        showComparison();
    }
    public static void showJPA() {

        System.out.println("\n----- JPA -----");

        EntityManager entityManager = null;
        EntityTransaction transaction = null;

        System.out.println("Uses EntityManager");
        System.out.println("Standard Java Persistence API");
        System.out.println("Database independent");
        System.out.println("Common methods:");
        System.out.println("persist()");
        System.out.println("find()");
        System.out.println("remove()");
    }

    public static void showHibernate() {

        System.out.println("\n----- Hibernate -----");

        SessionFactory sessionFactory = null;
        Session session = null;

        System.out.println("Uses Session");
        System.out.println("Hibernate is an implementation of JPA");
        System.out.println("Supports HQL");
        System.out.println("Provides extra features");
        System.out.println("Common methods:");
        System.out.println("save()");
        System.out.println("get()");
        System.out.println("delete()");
    }

    public static void showSpringDataJPA() {

        System.out.println("\n----- Spring Data JPA -----");

        JpaRepository<?, ?> repository = null;

        System.out.println("Uses JpaRepository");
        System.out.println("Reduces boilerplate code");
        System.out.println("Automatic CRUD methods");
        System.out.println("Repository interfaces are implemented by Spring");
    }

    public static void showComparison() {

        System.out.println("\n----- Comparison -----");

        System.out.printf("%-20s %-20s %-20s %-20s%n",
                "Feature", "JPA", "Hibernate", "Spring Data JPA");

        System.out.printf("%-20s %-20s %-20s %-20s%n",
                "API",
                "EntityManager",
                "Session",
                "JpaRepository");

        System.out.printf("%-20s %-20s %-20s %-20s%n",
                "CRUD",
                "Manual",
                "Manual",
                "Automatic");

        System.out.printf("%-20s %-20s %-20s %-20s%n",
                "Dependency",
                "JPA Specification",
                "Hibernate",
                "Spring Framework");
    }
}
