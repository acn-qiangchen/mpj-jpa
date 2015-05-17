package com.tink.mpj.jpa.orm.one2one;

import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Random;

public abstract class AbstractPersistentTest {
    
  public static final String PERSISTENCE_UNIT_NAME = "PU-1";

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
  protected EntityManager em;
  protected EntityTransaction tx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @Before
  public void initEntityManager() throws Exception {
    em = emf.createEntityManager();
    tx = em.getTransaction();
  }

  @After
  public void closeEntityManager() throws SQLException {
    if (em != null) em.close();
  }

  protected Long getRandomId() {
    return Math.abs(new Random().nextLong());
  }
}
