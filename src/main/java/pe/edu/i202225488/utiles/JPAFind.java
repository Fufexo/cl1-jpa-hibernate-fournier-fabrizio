package pe.edu.i202225488.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202225488.domain.City;
import pe.edu.i202225488.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public class JPAFind {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        Country country = em.find(Country.class, "PER");
        List<City> cities = country.getCities().stream()
                .filter(city -> city.getPopulation() > 700000)
                .collect(Collectors.toList());

        cities.forEach(city -> System.out.println(city.getName()));

        em.close();
        emf.close();
    }
}
