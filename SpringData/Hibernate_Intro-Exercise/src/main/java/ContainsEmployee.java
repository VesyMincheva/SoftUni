import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class ContainsEmployee {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.
                createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        entityManager.getTransaction().begin();

        String searchedName = scanner.nextLine();

        boolean isEmployeeListEmpty = entityManager
                .createQuery("FROM Employee WHERE concat_ws(' ', firstName, lastName) = :fullName", Employee.class)
                .setParameter("fullName", searchedName)
                .getResultList()
                .isEmpty();

        if (!isEmployeeListEmpty){
            System.out.println("Yes");
        }else {
            System.out.println("No");
        }
    }
}
