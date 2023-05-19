package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

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
		log.info("TrovatoElemento con codice ISBN: " + ISBN
				+ System.lineSeparator() + found.toString());
	}

	public void refresh(String ISBN) {
		Publication found = em.find(Publication.class, ISBN);

		em.refresh(found);
		log.info("Ripristinato Evento ai valori: " + found);
	}
}
