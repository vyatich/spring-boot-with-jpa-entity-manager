package com.example.java112.dao.ticket;

import com.example.java112.model.Ticket;

import java.util.List;

public interface TicketDao {

    List<Ticket> getAll();

    Ticket getByTicketNumber(String ticketNumber);

    void deleteByTicketNumber(String ticketNumber);

    Ticket update(Ticket ticket);

    Ticket create(Ticket ticket);
}
