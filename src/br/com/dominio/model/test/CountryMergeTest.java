package br.com.dominio.model.test;

import br.com.dominio.model.Country;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CountryMergeTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModelJPA2.0");
        EntityManager em = emf.createEntityManager();
        Country country = em.find(Country.class, 2);
        country.setName("Argentina");
        country.setIso("ARG");
        em.getTransaction().begin();
        em.merge(country);
        em.getTransaction().commit();
        em.close();
    }
    
}
