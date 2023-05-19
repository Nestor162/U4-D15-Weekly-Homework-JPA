package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import utils.JpaUtil;

public class Application {

	private static Logger log = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		em.close();
		emf.close();
	}

}
