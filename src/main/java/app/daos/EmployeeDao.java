package app.daos;

import app.entities.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.stream.Stream;

public class EmployeeDao {
    private final EntityManager entityManager;

    public EmployeeDao(EntityManagerFactory factory){
        this.entityManager = factory.createEntityManager();
    }

    public Stream<Employee> findAll(){
        TypedQuery<Employee> query = entityManager.createQuery("SELECT employee FROM Employee employee", Employee.class);
        return query.getResultStream();
    }
}
