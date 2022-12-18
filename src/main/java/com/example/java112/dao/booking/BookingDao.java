package com.example.java112.dao.booking;

import com.example.java112.model.Booking;

import java.math.BigDecimal;
import java.util.List;

public interface BookingDao {

    List<Booking> getAll();

    Booking getByBookRef(String bookRef);

    void delete(String bookRef);

    Booking update(Booking booking);

    Booking create(Booking booking);

    List<Booking> getByTotalAmount(BigDecimal totalAmount);
}
