package app.daos;

import app.entities.Chambre;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.stream.Stream;

public class ChambreDao {

    private final EntityManager entityManager;

    public ChambreDao(EntityManagerFactory factory){
        this.entityManager = factory.createEntityManager();
    }

    public Stream<Chambre> findAll(){
        TypedQuery<Chambre> query = entityManager.createQuery("SELECT c FROM Chambre c", Chambre.class);
        return query.getResultStream();
    }
}

