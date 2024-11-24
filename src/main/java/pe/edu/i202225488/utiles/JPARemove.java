package pe.edu.i202225488.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202225488.domain.Country;

public class JPARemove {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        String countryCode= "ASU";
        Country country = em.find(Country.class, countryCode);

        em.remove(country);

        em.getTransaction().commit();

        em.close();
        emf.close();
    }
}