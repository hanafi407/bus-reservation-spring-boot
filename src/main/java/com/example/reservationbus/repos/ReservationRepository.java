package com.example.reservationbus.repos;

import com.example.reservationbus.entities.BusSchedule;
import com.example.reservationbus.entities.Customer;
import com.example.reservationbus.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Optional<List<Reservation>> findByCustomer(Customer customer);

    Optional<List<Reservation>> findByBusScheduleAndDepartureDate(BusSchedule busSchedule,String departureDate);


}
