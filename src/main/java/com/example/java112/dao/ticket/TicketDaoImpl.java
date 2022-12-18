package com.example.java112.dao.ticket;

import com.example.java112.model.Ticket;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class TicketDaoImpl implements TicketDao {

    private static final String GET_ALL = "SELECT t FROM Ticket t";

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Ticket> getAll() {
        Query query = entityManager.createQuery(GET_ALL);
        return query.getResultList();
    }

    @Override
    public Ticket getByTicketNumber(String ticketNumber) {
        return entityManager.find(Ticket.class, ticketNumber);
    }

    @Override
    @Transactional
    public void deleteByTicketNumber(String ticketNumber) {
        Ticket ticket = entityManager.find(Ticket.class, ticketNumber);
        entityManager.remove(ticket);
    }

    @Override
    @Transactional
    public Ticket update(Ticket ticket) {
        entityManager.merge(ticket);
        return ticket;
    }

    @Override
    @Transactional
    public Ticket create(Ticket ticket) {
        entityManager.persist(ticket);
        return ticket;
    }
}
