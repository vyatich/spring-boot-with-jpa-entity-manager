package com.example.java112.dao.booking;

import com.example.java112.model.Booking;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class BookingDaoImpl implements BookingDao {

    //запрос на языке JPQL
    private static final String GET_ALL = "SELECT b FROM Booking b";
    private static final String GET_BY_TOTAL_AMOUNT = "SELECT b FROM Booking b where b.totalAmount = :totalAmount";


    @PersistenceContext
    private EntityManager entityManager;//предоставляет методы для работы с нашими сущностями - сохранение, получение и т.д.

    @Override
    public List<Booking> getAll() {
        Query query = entityManager.createQuery(GET_ALL);
        return query.getResultList();
    }

    @Override
    public Booking getByBookRef(String bookRef) {
        return entityManager.find(Booking.class, bookRef);
    }

    @Override
    @Transactional
    public void delete(String bookRef) {
        Booking booking = entityManager.find(Booking.class, bookRef);
        entityManager.remove(booking);
        entityManager.flush();
    }

    @Override
    @Transactional
    public Booking update(Booking booking) {
        entityManager.merge(booking);
        return booking;
    }

    @Override
    @Transactional//открываем транзакцию дял выполнения метода
    public Booking create(Booking booking) {
        entityManager.persist(booking);
        return booking;
    }

    @Override
    public List<Booking> getByTotalAmount(BigDecimal totalAmount) {
        Query query = entityManager.createQuery(GET_BY_TOTAL_AMOUNT);
        query.setParameter("totalAmount", totalAmount);
        return query.getResultList();
    }
}
