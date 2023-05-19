package dao;

import java.util.List;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import entities.Loan;
import entities.Publication;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PublicationDAO {
	private final EntityManager em;

	public PublicationDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Publication p) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(p);
		transaction.commit();
		log.info("Elemento aggiunto al catalogo!" + System.lineSeparator());
	}

	public void delete(String ISBN) {
		Publication found = em.find(Publication.class, ISBN);
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			log.info("Elemento con codice ISBN: " + ISBN + " eliminato!"
					+ System.lineSeparator());
		}
	}

	public void getByISBN(String ISBN) {
		Publication found = em.find(Publication.class, ISBN);
		log.info("Trovato elemento con codice ISBN: " + ISBN
				+ System.lineSeparator() + found.toString());
	}

	public void getByYear(int year) {
		TypedQuery<Publication> query = em.createQuery(
				"SELECT p FROM Publication p WHERE p.publicationYear = :year",
				Publication.class);
		query.setParameter("year", year);
		List<Publication> publications = query.getResultList();

		publications.forEach(p -> log.info("Trovato elemento pubblicato nel: "
				+ year + System.lineSeparator() + p.toString()));
	}

	public void getByAuthorName(String author) {
		TypedQuery<Publication> query = em.createQuery(
				"SELECT p FROM Publication p WHERE p.author = :author AND TYPE(p) = Book",
				Publication.class);
		query.setParameter("author", author);
		List<Publication> publications = query.getResultList();

		log.info("Libri pubblicati da" + author + ":");
		publications.forEach(p -> log.info(p.toString()));
	}

	public void getByTitle(String title) {
		TypedQuery<Publication> query = em.createQuery(
				"SELECT p FROM Publication p WHERE  LOWER(p.title) LIKE CONCAT('%', :title, '%')",
				Publication.class);
		query.setParameter("title", title.toLowerCase());
		List<Publication> publications = query.getResultList();

		log.info("Elementi che contengono " + title + " nel titolo: ");
		publications.forEach(p -> log.info(p.toString()));
	}

	public void isBorrowed(String id) {
		TypedQuery<Loan> query = em.createQuery(
				"SELECT l FROM Loan l WHERE l.user.id = :id ", Loan.class);
		query.setParameter("id", UUID.fromString(id));
		List<Loan> publications = query.getResultList();

		log.info("Elementi presi in prestito da utente con id" + id + ": ");
		publications.forEach(l -> log.info(l.toString()));
	}

	public void overdueLoansNotReturned() {
		TypedQuery<Loan> query = em.createQuery(
				"SELECT l FROM Loan l WHERE l.returnedDate IS NULL AND l.expectedReturnDate < CURRENT_DATE()",
				Loan.class);

		List<Loan> publications = query.getResultList();

		log.info("Prestiti scaduti e non restituiti: ");
		publications.forEach(l -> log.info(l.toString()));
	}

	public void refresh(String ISBN) {
		Publication found = em.find(Publication.class, ISBN);

		em.refresh(found);
		log.info("Ripristinato Evento ai valori: " + found);
	}
}
