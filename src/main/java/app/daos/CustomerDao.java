package app.daos;

import app.entities.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.stream.Stream;

public class CustomerDao {

    private final EntityManager entityManager;

    public CustomerDao(EntityManagerFactory factory) {
        this.entityManager = factory.createEntityManager();
    }

    public Stream<Customer> findAll(){
        TypedQuery<Customer> query = entityManager.createQuery("SELECT customer FROM Customer customer", Customer.class);
        return query.getResultStream();
    }


}
