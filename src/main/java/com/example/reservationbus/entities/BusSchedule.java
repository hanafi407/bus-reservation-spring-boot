package com.example.reservationbus.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bus_schedule")
public class BusSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busScheduleId;
    @OneToOne
    @JoinColumn(name = "bus_id")
    private Bus bus;
    @OneToOne
    @JoinColumn(name = "bus_route_id")
    private BusRoute busRoute;
    private String departureTime;
    private int ticketPrice;
    private int discountPercent;
    private int processingFee;
}
