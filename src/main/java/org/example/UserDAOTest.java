package org.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UserDAOTest {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("NoFormat");
        EntityManager entityManager = factory.createEntityManager();
        entityManager.getTransaction().begin();

//        addUser(entityManager);

//        mergeUser(entityManager);

//        findAnEntityInstance(entityManager);

//        executeAQuery(entityManager);

//        removeAnEntityInstance(entityManager);

        closeConnect(factory, entityManager);
    }

    private static void removeAnEntityInstance(EntityManager entityManager) {
        Integer primaryKey = 1;
//        User reference = entityManager.find(User.class,primaryKey);
        User reference = entityManager.getReference(User.class,primaryKey);
        entityManager.remove(reference);
        entityManager.getTransaction().commit();
    }

    private static void executeAQuery(EntityManager entityManager) {
        String sql = "SELECT u from User u where u.email = 'baone123@gmail.com'";
        Query query = entityManager.createQuery(sql);
        User user = (User)  query.getSingleResult();
        System.out.println(user);
    }

    private static void closeConnect(EntityManagerFactory factory, EntityManager entityManager) {
        entityManager.close();
        factory.close();
    }

    private static void findAnEntityInstance(EntityManager entityManager) {
        Integer primaryKey = 1;
        User user = entityManager.find(User.class, primaryKey);
        System.out.println(user);
    }

    private static void mergeUser(EntityManager entityManager) {
        User existingUser = new User();
        existingUser.setId(2);
        existingUser.setEmail("baone2@gmail.com");
        existingUser.setFullName("Nguy Duc Bao 2");
        existingUser.setPassword("123123");
        entityManager.merge(existingUser);
        entityManager.getTransaction().commit();
    }

    private static void addUser(EntityManager entityManager) {
        User newUser = new User();
        newUser.setEmail("baognguyen@gmail.com");
        newUser.setFullName("Bao Nguyen Duc");
        newUser.setPassword("baobao");
        entityManager.persist(newUser);
        entityManager.getTransaction().commit();

    }
}
