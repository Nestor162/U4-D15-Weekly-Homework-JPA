package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Publication;
import entities.User;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserDAO {
	private final EntityManager em;

	public UserDAO(EntityManager em) {
		this.em = em;
	}

	public void save(User u) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(u);
		transaction.commit();
		log.info("Utente aggiunto!" + System.lineSeparator());
	}

	public void delete(String id) {
		Publication found = em.find(Publication.class, UUID.fromString(id));
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			log.info("Utente con id: " + id + " eliminato dal database!"
					+ System.lineSeparator());
		}
	}

	public void getById(String id) {
		Publication found = em.find(Publication.class, UUID.fromString(id));
		log.info("Trovato utente con id: " + id + System.lineSeparator()
				+ found.toString());
	}

	public void refresh(String id) {
		Publication found = em.find(Publication.class, UUID.fromString(id));

		em.refresh(found);
		log.info("Ripristinato Evento ai valori: " + found);
	}
}
