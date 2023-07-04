import entities.Address;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class AddressesWithEmployeeCount {
    private static final String PRINT_FORMAT_ADDRESSES_WITH_EMPLOYEE_COUNT = "%s, %s - %d employees%n";

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Address> addresses = entityManager
                .createQuery("FROM Address ORDER BY employees.size DESC", Address.class)
                .setMaxResults(10)
                .getResultList();

        for (Address address : addresses) {
            System.out.printf(PRINT_FORMAT_ADDRESSES_WITH_EMPLOYEE_COUNT,
                                address.getText(),
                                address.getTown().getName(),
                                address.getEmployees().size());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
