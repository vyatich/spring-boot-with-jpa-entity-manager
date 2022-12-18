package com.example.java112.controller;

import com.example.java112.model.Ticket;
import com.example.java112.service.ticket.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(TicketController.PATH)
@RequiredArgsConstructor
public class TicketController {

    public static final String PATH = "/ticket/";

    private final TicketService ticketService;

    @GetMapping
    public List<Ticket> getAll() {
        return ticketService.getAll();
    }

    @GetMapping(value = "{number}")
    public Ticket getByTicketNumber(@PathVariable String number) {
        return ticketService.getByTicketNumber(number);
    }
}
