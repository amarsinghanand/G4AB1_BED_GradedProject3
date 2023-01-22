package com.gl.gradedproject.bed.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.gl.gradedproject.bed.model.Ticket;

@Repository
public class TicketDaoImpl implements TicketDao {
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveOrUpdate(Ticket ticket) {
		Session currentSession = sessionFactory.getCurrentSession();
		if (ticket.getId() > 0L) {
			currentSession.update(ticket);
		} else {
			currentSession.save(ticket);
		}
	}

	@Override
	public void delete(long ticketId) {
		Session session = sessionFactory.getCurrentSession();
		Ticket ticket = session.byId(Ticket.class).load(ticketId);
		session.delete(ticket);
	}

	@Override
	public Ticket getTicketById(long ticketId) {
		Session currentSession = sessionFactory.getCurrentSession();
		Ticket ticket = currentSession.get(Ticket.class, ticketId);
		return ticket;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getAllTickets() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
		Root<Ticket> root = cq.from(Ticket.class);
		cq.select(root);
		cq.orderBy(cb.asc(root.get("id")));
		Query query = session.createQuery(cq);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Ticket> getTicketsContainingIgnoreCase(String searchText) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Ticket> cq = cb.createQuery(Ticket.class);
		Root<Ticket> from = cq.from(Ticket.class);
		cq.select(from).where(cb.or(cb.like(cb.upper(from.get("title")), "%" + searchText.toUpperCase() + "%"),
				cb.like(cb.upper(from.get("description")), "%" + searchText.toUpperCase() + "%")));
		cq.orderBy(cb.asc(from.get("id")));
		Query query = session.createQuery(cq);
		return query.getResultList();
	}
}
