package com.example.java112.service.booking;

import com.example.java112.model.Booking;

import java.math.BigDecimal;
import java.util.List;

public interface BookingService {

    List<Booking> getAll();

    Booking getByBookRef(String bookRef);

    void delete(String bookRef);

    Booking update(Booking booking);

    Booking create(Booking booking);

    List<Booking> getByTotalAmount(BigDecimal totalAmount);
}
