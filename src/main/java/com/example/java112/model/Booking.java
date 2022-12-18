package com.example.java112.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@ToString(exclude = "tickets")//исключаем из работы метода toString поле tickets, чтобы избежать StackOverflowError
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Booking {

    @Id
    @Column(name = "book_ref")
    private String bookRef;
    @Column(name = "book_date")
    private Date bookDate;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @JsonIgnore
    @OneToMany(mappedBy = "booking", cascade = CascadeType.REMOVE)//каскадно удаляем и связанные Ticket
    List<Ticket> tickets = new ArrayList<>();
}
