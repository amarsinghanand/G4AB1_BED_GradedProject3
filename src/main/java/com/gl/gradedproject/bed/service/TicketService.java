package com.gl.gradedproject.bed.service;

import java.util.List;

import com.gl.gradedproject.bed.model.Ticket;

public interface TicketService {
	public Ticket getTicketById(long id);

	public void saveOrUpdate(Ticket ticket);

	public void delete(long id);

	public List<Ticket> getAllTickets();

	public List<Ticket> getTicketsContainingIgnoreCase(String searchText);
}
