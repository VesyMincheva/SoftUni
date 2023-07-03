import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesFromDepartment {
    private static final String PRINT_FORMAT_EMPLOYEES_FROM_DEPARTMENT = "%s %s from Research and Development - $%s%n";

    public static void main(String[] args) {

        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Employee> employees = entityManager
                .createQuery("FROM Employee " +
                                "WHERE department.name = 'Research and Development' " +
                                "ORDER BY salary, id",
                                Employee.class)
                .getResultList();

        for (Employee employee : employees) {
            System.out.printf(PRINT_FORMAT_EMPLOYEES_FROM_DEPARTMENT,
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
