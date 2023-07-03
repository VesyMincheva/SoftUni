import entities.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeesWithSalaryOver50000 {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();

        List<Employee> employees = entityManager
                .createQuery("FROM Employee WHERE salary > 50000", Employee.class).getResultList();

        for (Employee employee : employees) {
            System.out.println(employee.getFirstName());
        }

        entityManager.getTransaction().commit();
        entityManager.close();
    }
}
