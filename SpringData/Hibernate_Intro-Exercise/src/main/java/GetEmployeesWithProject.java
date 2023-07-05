import entities.Employee;
import jdk.jfr.Percentage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class GetEmployeesWithProject {
    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();
        Scanner scanner = new Scanner(System.in);

        entityManager.getTransaction().begin();
        int employeeId = Integer.parseInt(scanner.nextLine());

        Employee searchedEmployee = entityManager
                .createQuery("FROM Employee WHERE id = :employeeId ORDER BY firstName", Employee.class)
                .setParameter("employeeId", employeeId)
                .getSingleResult();

        searchedEmployee.printEmployeeWithAllProjects();

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
