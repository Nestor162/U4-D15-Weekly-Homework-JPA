package app;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.PublicationDAO;
import entities.Book;
import entities.Magazine;
import utils.JpaUtil;

public class Application {

	private static Logger log = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		PublicationDAO pd = new PublicationDAO(em);

		Book book1 = new Book("9780553573398", "Assassin's Apprentice", 1995,
				464, "Robin Hobb", "Fantasy");

		Book book2 = new Book("9781421527727", "Battle Royale", 1999, 617,
				"Koushun Takami", "Thriller");

		Book book3 = new Book("9780765356147", "Mistborn: Hero of Ages", 2008,
				572, "Brandon Sanderson", "Fantasy");

		Magazine magazine1 = new Magazine("987654321", "National Geographic",
				2021, 100, Magazine.publicationFrequency.MONTHLY);

		Magazine magazine2 = new Magazine("9780123456789", "Vogue", 2022, 80,
				Magazine.publicationFrequency.MONTHLY);

		Magazine magazine3 = new Magazine("9789999999999", "New Scientist",
				2021, 52, Magazine.publicationFrequency.MONTHLY);

		pd.save(book1);
		pd.save(book2);
		pd.save(book3);
		pd.save(magazine1);
		pd.save(magazine2);
		pd.save(magazine3);

		em.close();
		emf.close();
	}

}
