package com.gl.gradedproject.bed.dao;

import java.util.List;

import com.gl.gradedproject.bed.model.Ticket;

public interface TicketDao {

	public void saveOrUpdate(Ticket ticket);

	public void delete(long id);

	public Ticket getTicketById(long id);

	public List<Ticket> getAllTickets();

	public List<Ticket> getTicketsContainingIgnoreCase(String searchText);

}
