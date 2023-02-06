package app.daos;

import app.entities.Reservation;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.stream.Stream;

public class ReservationDao {

    private final EntityManager entityManager;

    public ReservationDao(EntityManagerFactory factory){
        this.entityManager = factory.createEntityManager();
    }

    public Stream<Reservation> findAll(){
        TypedQuery<Reservation> query = entityManager.createQuery("select reservation from Reservation reservation", Reservation.class);
        return query.getResultStream();
    }
}
