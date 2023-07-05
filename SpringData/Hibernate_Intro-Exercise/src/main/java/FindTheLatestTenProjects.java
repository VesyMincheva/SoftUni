import entities.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Comparator;
import java.util.List;

public class FindTheLatestTenProjects {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager entityManager = factory.createEntityManager();

        entityManager.getTransaction().begin();
        List<Project> lastStartedProjects = entityManager.createQuery("FROM Project ORDER BY startDate DESC", Project.class)
                .setMaxResults(10)
                .getResultList();

        List<Project> sortedProjects = lastStartedProjects.stream().sorted(Comparator.comparing(Project::getName))
                .toList();

        for (Project project : sortedProjects) {
            System.out.printf("Project name: %s%n", project.getName());
            System.out.printf("     Project Description: %s%n", project.getDescription());
            System.out.printf("     Project Start Date:%s%n",project.getStartDate());
            System.out.printf("     Project End Date: %s%n", project.getEndDate());
        }
    }
}
