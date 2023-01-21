package com.gl.gradedproject.bed.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gl.gradedproject.bed.dao.TicketDao;
import com.gl.gradedproject.bed.model.Ticket;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	private TicketDao ticketDAO;

	@Override
	@Transactional
	public List<Ticket> getAllTickets() {
		return ticketDAO.getAllTickets();
	}

	@Override
	@Transactional
	public void saveOrUpdate(Ticket ticket) {
		ticketDAO.saveOrUpdate(ticket);
	}

	@Override
	@Transactional
	public Ticket getTicketById(long id) {
		return ticketDAO.getTicketById(id);
	}

	@Override
	@Transactional
	public void delete(long id) {
		ticketDAO.delete(id);
	}

	@Override
	@Transactional
	public List<Ticket> getTicketsContainingIgnoreCase(String searchText) {
		return ticketDAO.getTicketsContainingIgnoreCase(searchText);
	}

}
