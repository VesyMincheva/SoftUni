import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ChangeCasing {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Town> towns = entityManager.createQuery("FROM Town", Town.class).getResultList();

        for (Town town : towns) {
            if (town.getName().length() > 5){
                entityManager.detach(town);
            }else {
                town.setName(town.getName().toUpperCase());
                entityManager.persist(town);
            }
        }

        entityManager.getTransaction().commit();
        entityManager.close();


    }
}
