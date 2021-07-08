package br.com.dominio.test;

import br.com.dominio.model.Country;
import br.com.dominio.model.State;
import br.com.dominio.util.JpaUtil;
import javax.persistence.EntityManager;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class StateTest {

    EntityManager manager;

    public StateTest() {
    }

    @Before
    public void setUp() {
        manager = JpaUtil.getEntityManager();
    }

    @After
    public void tearDown() {
        manager.close();
    }
    
    @Test
    public void test() {
        boolean exception = false;
        try {
            State state = new State();
            state.setName("Pernambuco");
            state.setUf("PE");
            state.setCountry(manager.find(Country.class, 1));
            manager.getTransaction().begin();
            manager.persist(state);
            manager.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
        }        
        Assert.assertEquals(false, exception);
    }
}
