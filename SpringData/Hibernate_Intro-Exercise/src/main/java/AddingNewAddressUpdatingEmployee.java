import entities.Address;
import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
import java.util.Scanner;

public class AddingNewAddressUpdatingEmployee {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        entityManager.getTransaction().begin();
        String lastNameToAddAddress = scanner.nextLine();

        List<Employee> employeesToUpdate = entityManager.createQuery("FROM Employee WHERE lastName = :lastName", Employee.class)
                .setParameter("lastName", lastNameToAddAddress)
                .getResultList();

        Address address = new Address();
        address.setText("Vitoshka 15");
        entityManager.persist(address);

        employeesToUpdate.forEach(e -> e.setAddress(address));

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
        scanner.close();

    }
}
