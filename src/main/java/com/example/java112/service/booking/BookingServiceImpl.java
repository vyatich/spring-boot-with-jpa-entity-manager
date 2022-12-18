package com.example.java112.service.booking;

import com.example.java112.dao.booking.BookingDao;
import com.example.java112.model.Booking;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingDao bookingDao;

    @Override
    public List<Booking> getAll() {
        return bookingDao.getAll();
    }

    @Override
    public Booking getByBookRef(String bookRef) {
        return bookingDao.getByBookRef(bookRef);
    }

    @Override
    public void delete(String bookRef) {
        bookingDao.delete(bookRef);
    }

    @Override
    public Booking update(Booking booking) {
        return bookingDao.update(booking);
    }

    @Override
    public Booking create(Booking booking) {
        return bookingDao.create(booking);
    }

    @Override
    public List<Booking> getByTotalAmount(BigDecimal totalAmount) {
        return bookingDao.getByTotalAmount(totalAmount);
    }
}
