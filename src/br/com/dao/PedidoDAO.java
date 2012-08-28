package br.com.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.bean.Pedido;
import br.com.caelum.vraptor.ioc.Component;

@Component
public class PedidoDAO extends DAO {

	public void salvar(Pedido pedido) {
		// obtendo o EntityManager
		EntityManager em = getEntityManager();
		try {
			// inicia o processo de transacao
			em.getTransaction().begin();
			// faz a persistencia
			// Persistir lista de itens primeiro
			/*
			 * if (pedido.getItens() != null && pedido.getId() == 0) { for (Item
			 * i : pedido.getItens()) { if (i.getId() == 0) { em.persist(i); } }
			 * }
			 */
			if (pedido.getId() != 0) {
				em.merge(pedido);
			} else {
				em.persist(pedido);
			}

			// Query q = em.createQuery(
			// "select object(p) from Pedido as p where p.id = ?1")
			// .setParameter(1, pedido.getId());
			// pedido = (Pedido) q.getResultList().get(0);

			// manda bala para o BD
			em.getTransaction().commit();
		} catch (Exception e) {
			// se der algo de errado vem parar aqui, onde eh cancelado
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public void removerPedidoId(int id) {
		// obtendo o EntityManager
		EntityManager em = getEntityManager();
		try {
			// inicia o processo de transacao
			em.getTransaction().begin();

			Query q = em.createQuery(
					"select object(p) from Pedido as p where p.id = ?1")
					.setParameter(1, id);
			Pedido p = (Pedido) q.getResultList().get(0);
			if (p != null)
				em.remove(p);
			em.getTransaction().commit();
		} catch (Exception e) {
			// se der algo de errado vem parar aqui, onde eh cancelado
			em.getTransaction().rollback();
		} finally {
			em.close();
		}
	}

	public Pedido obterPedidoId(int id) {
		if (id == 0)
			return null;
		Pedido p;
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery(
					"select object(p) from Pedido as p where p.id = ?1")
					.setParameter(1, id);
			p = (Pedido) q.getResultList().get(0);
			p.getValorTotal();
			return p;
		} finally {
			em.close();
		}
	}

	public List<Pedido> exibir() {
		List<Pedido> lista;
		EntityManager em = getEntityManager();
		try {
			Query q = em.createQuery("select object(p) from Pedido as p");
			lista = q.getResultList();
			for (Pedido o : lista) {
				o.getValorTotal();
			}
			return lista;
		} finally {
			em.close();
		}
	}
}
