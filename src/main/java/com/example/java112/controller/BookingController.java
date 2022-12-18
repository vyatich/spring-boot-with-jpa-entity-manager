package com.example.java112.controller;

import com.example.java112.model.Booking;
import com.example.java112.service.booking.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController//тот же самый контроллер, только отавать данные мы будем в JSON формате
@RequestMapping(BookingController.PATH)
@RequiredArgsConstructor//конструктор с final полями
public class BookingController {

    public static final String PATH = "/booking/";

    //внедряем бин, который будет содержать всю бизнес-логику для работы с Booking
    private final BookingService bookingService;

    @GetMapping
    public List<Booking> getAll() {
        return bookingService.getAll();
    }

    @GetMapping(value = "{bookRef}")
    public Booking getByBookRef(@PathVariable String bookRef) {
        return bookingService.getByBookRef(bookRef);
    }

    @DeleteMapping(value = "{bookRef}")
    public void delete(@PathVariable String bookRef) {
        bookingService.delete(bookRef);
    }

    @PostMapping
    public Booking create(@RequestBody Booking booking) {
        return bookingService.create(booking);
    }

    @GetMapping(value = "total-amount/")
    public List<Booking> getByTotalAmount(@RequestParam BigDecimal totalAmount) {
        return bookingService.getByTotalAmount(totalAmount);
    }
}
