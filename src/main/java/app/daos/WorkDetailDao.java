package app.daos;

import app.entities.WorkDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

import java.util.stream.Stream;

public class WorkDetailDao {

    private final EntityManager entityManager;

    public WorkDetailDao(EntityManagerFactory factory){
        this.entityManager = factory.createEntityManager();
    }

    public Stream<WorkDetail> findAll(){
        TypedQuery<WorkDetail> query = entityManager.createQuery("select workDetail from WorkDetail workDetail", WorkDetail.class);
        return query.getResultStream();
    }
}
