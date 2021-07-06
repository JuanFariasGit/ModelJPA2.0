package br.com.dominio.model.test;

import br.com.dominio.model.Country;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public class CountryPersistenceTest {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ModelJPA2.0");
        EntityManager em = emf.createEntityManager();
        Country country = new Country();
        country.setName("Uruguai");
        country.setIso("UR");
        em.getTransaction().begin();
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<Country>> errors = validator.validate(country);
        if (errors.size() > 0) {
            errors.forEach(error -> {
                System.out.println(error.getMessage());
            });
        } else {
            em.persist(country);
        } 
        em.getTransaction().commit();
        em.close();
    }
}
