package dao;

import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entities.Loan;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class LoanDAO {
	private final EntityManager em;

	public LoanDAO(EntityManager em) {
		this.em = em;
	}

	public void save(Loan l) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(l);
		transaction.commit();
		log.info("Presitto aggiunto!" + System.lineSeparator());
	}

	public void delete(String id) {
		Loan found = em.find(Loan.class, UUID.fromString(id));
		if (found != null) {
			EntityTransaction transaction = em.getTransaction();
			transaction.begin();
			em.remove(found);
			transaction.commit();
			log.info("Prestito con id: " + id + " eliminato dal database!"
					+ System.lineSeparator());
		}
	}

	public void getById(String id) {
		Loan found = em.find(Loan.class, UUID.fromString(id));
		log.info("Trovato prestito con id: " + id + System.lineSeparator()
				+ found.toString());
	}

	public void refresh(String id) {
		Loan found = em.find(Loan.class, UUID.fromString(id));

		em.refresh(found);
		log.info("Ripristinato Evento ai valori: " + found);
	}
}
