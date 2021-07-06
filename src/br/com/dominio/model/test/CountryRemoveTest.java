package br.com.dominio.model.test;

import br.com.dominio.model.Country;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CountryRemoveTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModelJPA2.0");
        EntityManager em = emf.createEntityManager();
        Country country = em.find(Country.class, 3);
        em.getTransaction().begin();
        em.remove(country);
        em.getTransaction().commit();
        em.close();
    }
    
}
