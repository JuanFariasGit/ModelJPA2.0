package br.com.dominio.model.test;

import br.com.dominio.model.Country;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CountryPersistenceTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModelJPA2.0");
        EntityManager em = emf.createEntityManager();
        Country country = new Country();
        country.setName("Arg");
        country.setIso("BRA");
        em.getTransaction().begin();
        em.persist(country);
        em.getTransaction().commit();
        em.close();
    }
}
