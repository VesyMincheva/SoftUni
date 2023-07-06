import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class IncreaseSalaries {
    private static final List<String> DEPARTMENTS_TO_INCREASE_SALARIES = List.of("Engineering",
            "Tool Design", "Marketing", "Information Services");
    private static final String PRINT_FORMAT_EMPLOYEES_WITH_NEW_SALARIES = "%s %s ($%s)%n";

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Employee> employeesToIncreaseSalaries = entityManager
                .createQuery("FROM Employee WHERE department.name IN :departments", Employee.class)
                .setParameter("departments", DEPARTMENTS_TO_INCREASE_SALARIES)
                .getResultList();

        employeesToIncreaseSalaries
                .forEach(e -> e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12))));

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();

        for (Employee employee : employeesToIncreaseSalaries) {
            System.out.printf(PRINT_FORMAT_EMPLOYEES_WITH_NEW_SALARIES,
                                employee.getFirstName(),
                                employee.getLastName(),
                                employee.getSalary());
        }
    }
}
