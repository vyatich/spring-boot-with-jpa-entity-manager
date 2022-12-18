package com.example.java112.service.ticket;

import com.example.java112.dao.ticket.TicketDao;
import com.example.java112.model.Ticket;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j//подключаем логгер для нашего сервиса
public class TicketServiceImpl implements TicketService {

    private final TicketDao ticketDao;

    @Override
    public List<Ticket> getAll() {
        return ticketDao.getAll();
    }

    @Override
    public Ticket getByTicketNumber(String number) {
        log.info("Request with ticket number '{}'", number);//логгирование операций с уровнем INFO
        Ticket ticket = ticketDao.getByTicketNumber(number);
        log.info("Response from database with ticket '{}'", ticket);
        ticket.setFullPassengerInfo(String.format("%s - %s", ticket.getPassengerName(), ticket.getPassengerId()));
        return ticket;
    }
}
