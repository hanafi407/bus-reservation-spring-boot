package com.example.reservationbus.services;

import com.example.reservationbus.entities.Reservation;

import java.util.List;

public interface ReservationService  {
    Reservation addReservation(Reservation reservation);
    List<Reservation> getAllReservation();
    List<Reservation> getReservationByMobile(String mobile);

    List<Reservation> getReservationByScheduleAndDepartureDate(Long scheduleId,String departureDate);
}
