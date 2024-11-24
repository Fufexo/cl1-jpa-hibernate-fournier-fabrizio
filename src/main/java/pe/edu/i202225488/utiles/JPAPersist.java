package pe.edu.i202225488.utiles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import pe.edu.i202225488.domain.City;
import pe.edu.i202225488.domain.Country;
import pe.edu.i202225488.domain.CountryLanguage;
import pe.edu.i202225488.domain.CountryLanguageId;

import java.util.ArrayList;

public class JPAPersist {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("world");
        EntityManager em = emf.createEntityManager();

        // Inicia la transacción
        em.getTransaction().begin();

        // Crear el país con las listas de ciudades y lenguajes
        Country country = new Country(
                "ASU",
                "Asura",
                "Asia",
                "Oeste",
                12345.67,
                2024,
                1000,
                70.5,
                12345.67,
                123456.78,
                "Asuranos",
                "Republica",
                "Rudyos Greyrat",
                null,
                "AS",
                new ArrayList<>(),
                new ArrayList<>()
        );

        // Crear 3 ciudades
        City cityX = new City(null, "Ranoa", "Fittoa", 500, country);
        City cityY = new City(null, "Buena Aldea", "Fittoa", 300, country);
        City cityZ = new City(null, "Millis", "Fittoa", 200, country);

        country.getCities().add(cityX);
        country.getCities().add(cityY);
        country.getCities().add(cityZ);

        // Crear lenguajes nativos
        CountryLanguage language1 = new CountryLanguage(
                new CountryLanguageId("ASU", "Euskera"),
                country,
                "T",
                75.0
        );

        CountryLanguage language2 = new CountryLanguage(
                new CountryLanguageId("ASU", "Basol"),
                country,
                "F",
                25.0
        );


        country.getLanguages().add(language1);
        country.getLanguages().add(language2);

        em.persist(country);

        // Finaliza la transacción
        em.getTransaction().commit();

        // Cierra el EntityManager y el EntityManagerFactory
        em.close();
        emf.close();

        System.out.println("Datos persistidos con éxito.");
    }
}
