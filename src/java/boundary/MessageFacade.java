/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boundary;

import entities.Message;
import java.util.List;
import javax.annotation.ManagedBean;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

/**
 *
 * @author kzaki
 */
@Stateless
@ViewScoped
//@ManagedBean
public class MessageFacade extends AbstractFacade<Message> {

	@PersistenceContext(unitName = "SimpleEE6AppPU")
	private EntityManager em;

	@Override
	protected EntityManager getEntityManager() {
		return em;
	}

	public MessageFacade() {
		super(Message.class);
	}

//	@Transactional
	public List<Message> searchByName() {
		List<Message> messages = em.createQuery("SELECT m.message FROM Message m WHERE m.message=:msg", Message.class)
			.setParameter("msg", "hi")
			.getResultList();
		return messages;
	}

}
