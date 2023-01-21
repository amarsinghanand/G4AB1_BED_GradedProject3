package com.gl.gradedproject.bed.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.gl.gradedproject.bed.model.Ticket;
import com.gl.gradedproject.bed.service.TicketService;

@Controller
@RequestMapping("/tickets")
public class TicketController {
	@Autowired
	private TicketService ticketService;

	// lists
	@GetMapping("/lists")
	public String listTickets(Model model, @RequestParam(value = "searchText", required = false) String searchText) {
		try {
			List<Ticket> tickets = new ArrayList<Ticket>();
			if (searchText == null) {
				tickets = ticketService.getAllTickets();
			} else {
				tickets = ticketService.getTicketsContainingIgnoreCase(searchText);
				model.addAttribute("searchText", searchText);
			}
			model.addAttribute("tickets", tickets);
		} catch (Exception e) {
			model.addAttribute("message", e.getMessage());
		}

		return "list-tickets";
	}

	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model model) {

		// create model attribute to bind form data
		Ticket ticket = new Ticket();

		model.addAttribute("ticket", ticket);

		return "ticket-create";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("ticketId") long id, Model model) {

		// get the ticket from the service
		Ticket ticket = ticketService.getTicketById(id);

		// set ticket as a model attribute to pre-populate the form
		model.addAttribute("ticket", ticket);

		// send over to our form
		return "ticket-edit";
	}

	@PostMapping("/save")
	public String saveOrUpdate(@ModelAttribute("ticket") Ticket ticket, Model model) {
		// save the ticket
		ticketService.saveOrUpdate(ticket);
		model.addAttribute("ticket", ticket);

		// use a redirect to prevent duplicate submissions
		return "redirect:lists";
	}

	@PostMapping("/delete")
	public String delete(@RequestParam("ticketId") int id) {

		// delete the ticket
		ticketService.delete(id);

		// redirect to /tickets/list
		return "redirect:lists";

	}

}
