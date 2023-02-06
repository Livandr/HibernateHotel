package app;

import app.daos.ChambreDao;
import app.entities.Chambre;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class Main {
    public static void main(String[] args) {

//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("HOTEL");
//
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        entityManager.getTransaction().begin();
//
//        Hotel hotel = new Hotel();
//        hotel.setName("CARLTON");
//        hotel.setStars(5);
//        hotel.setAdress("Bruxelles");
//
//        entityManager.getTransaction().commit();
//        entityManagerFactory.close();

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("demo");
//        EntityManager em = factory.createEntityManager();
//
//        em.getTransaction().begin();
//        em.persist(new Personne());
//        em.getTransaction().commit();
//
//        try (
//                PersonneDao dao = new PersonneDao(factory)
//        ){
//            List<Personne> personnes = dao.findAll().toList();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

        ChambreDao chambreDao = new ChambreDao(factory);

        List<Chambre> chambres = chambreDao.findAll().toList();



//        TypedQuery<Personne> query = em.createQuery("SELECT p FROM Personne p JOIN Adresse a ON a.street = 'Rue du connard'", Personne.class);
//        List<Personne> personnes = query.getResultList();
//
//        personnes.forEach(it -> System.out.println());


    }
}