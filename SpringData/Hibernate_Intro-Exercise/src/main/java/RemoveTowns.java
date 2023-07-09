import entities.Address;
import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class RemoveTowns {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        entityManager.getTransaction().begin();
        String townNameToDelete = scanner.nextLine();

        Town townToBeDeleted = entityManager
                .createQuery("FROM Town WHERE name = :townNameToDelete", Town.class)
                .setParameter("townNameToDelete", townNameToDelete)
                .getSingleResult();

        List<Address> addressesToBeDeleted = entityManager.createQuery("FROM Address WHERE town.id = :townId", Address.class)
                .setParameter("townId", townToBeDeleted.getId())
                .getResultList();

        int countOfDeletedAddresses = addressesToBeDeleted.size();

        addressesToBeDeleted.forEach(t -> t.getEmployees()
                .forEach(em -> em.setAddress(null)));
        addressesToBeDeleted.forEach(entityManager::remove);
        entityManager.remove(townToBeDeleted);

        if (countOfDeletedAddresses > 1){
            System.out.printf("%d addresses in %s deleted%n", countOfDeletedAddresses, townNameToDelete);
        }else if (countOfDeletedAddresses == 1){
            System.out.printf("%d address in %s deleted%n", countOfDeletedAddresses, townNameToDelete);
        }
    }
}
