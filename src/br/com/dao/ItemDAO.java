package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.bean.Item;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class ItemDAO extends DAO {

	public void salvar(Item item) {
		// obtendo o EntityManager
		EntityManager em = getEntityManager();
		try {
			// inicia o processo de transacao
			em.getTransaction().begin();
			// faz a persistencia
			em.persist(item);
			// manda bala para o BD
			em.getTransaction().commit();
		} catch (Exception e) {
			// se der algo de errado vem parar aqui, onde eh cancelado
			em.getTransaction().rollback();
		}
	}

	public List exibir() {
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object(i) from Item as i");
			return q.getResultList();
		} finally {
			em.close();
		}
	}
}
