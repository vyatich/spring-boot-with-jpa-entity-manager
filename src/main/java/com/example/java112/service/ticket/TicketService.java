package com.example.java112.service.ticket;

import com.example.java112.model.Ticket;

import java.util.List;

public interface TicketService {

    List<Ticket> getAll();

    Ticket getByTicketNumber(String number);
}
