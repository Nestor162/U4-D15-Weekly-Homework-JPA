package app;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dao.PublicationDAO;
import dao.UserDAO;
import entities.Book;
import entities.Magazine;
import entities.User;
import utils.JpaUtil;

public class Application {

	private static Logger log = LoggerFactory.getLogger(Application.class);
	private static EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();

	public static void main(String[] args) {
		EntityManager em = emf.createEntityManager();

		PublicationDAO pd = new PublicationDAO(em);
		UserDAO ud = new UserDAO(em);

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

		User user1 = new User("Marco", "Rossi", "Via Roma 123",
				"marco.rossi@example.com", "+39 123456789", LocalDate.now());

		User user2 = new User("Giulia", "Bianchi", "Via Dante 456",
				"giulia.bianchi@example.com", "+39 987654321", LocalDate.now());

		User user3 = new User("Luca", "Ferrari", "Corso Vittorio Emanuele 789",
				"luca.ferrari@example.com", "+39 456789123", LocalDate.now());

//		pd.save(book1);
//		pd.save(book2);
//		pd.save(book3);
//		pd.save(magazine1);
//		pd.save(magazine2);
//		pd.save(magazine3);

//		ud.save(user1);
//		ud.save(user2);
//		ud.save(user3);

		em.close();
		emf.close();
	}

}
