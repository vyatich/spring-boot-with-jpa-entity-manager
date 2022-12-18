package com.example.java112.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tickets")
public class Ticket {

    @Id
    @Column(name = "ticket_no")//указываем столбец, который будет сопоставляться с полем Entity
    private String ticketNumber;
    @ManyToOne
    @JoinColumn(name = "book_ref") //тут указываем столбец для сопоставления с Booking
    private Booking booking;
    @Column(name = "passenger_id")
    private String passengerId;
    @Column(name = "passenger_name")
    private String passengerName;
    @Column(name = "contact_data")
    private String contactData;
    @Transient
    private String fullPassengerInfo;
}
