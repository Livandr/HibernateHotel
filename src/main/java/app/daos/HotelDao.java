package app.daos;

import app.entities.Hotel;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

import java.util.Optional;
import java.util.stream.Stream;

public class HotelDao {

    private final EntityManager entityManager;

    public HotelDao(EntityManagerFactory factory) {
        this.entityManager = factory.createEntityManager();

    }

    public Stream<Hotel> findAll(){
        TypedQuery<Hotel> query = entityManager.createQuery("SELECT h FROM Hotel h", Hotel.class);

        return query.getResultStream();
    }

    public Optional<Hotel> findById (Long id){
        TypedQuery<Hotel> query = entityManager.createQuery("SELECT h FROM Hotel h WHERE h.id = :id", Hotel.class);
        query.setParameter("id", id);
        return Optional.of(query.getSingleResult());
    }

    public void save(Hotel hotel){
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        if(hotel.getId() != null){
            entityManager.merge(hotel);
        }
        else {
            entityManager.persist(hotel);
        } entityManager.flush();
        transaction.commit();
    }
}