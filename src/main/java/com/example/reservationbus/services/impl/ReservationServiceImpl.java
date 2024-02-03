package com.example.reservationbus.services.impl;

import com.example.reservationbus.entities.BusRoute;
import com.example.reservationbus.entities.BusSchedule;
import com.example.reservationbus.entities.Customer;
import com.example.reservationbus.entities.Reservation;
import com.example.reservationbus.model.ReservationApiException;
import com.example.reservationbus.repos.BusRouteRepository;
import com.example.reservationbus.repos.BusScheduleRepository;
import com.example.reservationbus.repos.CustomerRepository;
import com.example.reservationbus.repos.ReservationRepository;
import com.example.reservationbus.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ReservationServiceImpl implements ReservationService {
    private ReservationRepository reservationRepository;
    private CustomerRepository customerRepository;
    private BusScheduleRepository busScheduleRepository;

    @Override
    public Reservation addReservation(Reservation reservation) {
        Customer customer;
        boolean isCustomerExist = customerRepository.existsByMobileAndEmail(reservation.getCustomer().getMobile(), reservation.getCustomer().getEmail());
        if (isCustomerExist) {
            customer = customerRepository.findByMobileAndEmail(reservation.getCustomer().getMobile(), reservation.getCustomer().getEmail()).orElseThrow();
        } else {
            customer = customerRepository.save(reservation.getCustomer());
        }

        reservation.setCustomer(customer);

        return reservationRepository.save(reservation);
    }

    @Override
    public List<Reservation> getAllReservation() {
        return reservationRepository.findAll();
    }

    @Override
    public List<Reservation> getReservationByMobile(String mobile) {
        Customer customer = customerRepository.findByMobile(mobile).orElseThrow();
        return reservationRepository.findByCustomer(customer).orElseThrow();
    }

    @Override
    public List<Reservation> getReservationByScheduleAndDepartureDate(Long scheduleId, String departureDate) throws ReservationApiException {
        BusSchedule busSchedule = busScheduleRepository.findById(scheduleId)
                .orElseThrow(()-> new ReservationApiException(HttpStatus.BAD_REQUEST,"Bus route doesn't in our record"));

        return reservationRepository.findByBusScheduleAndDepartureDate(busSchedule,departureDate)
                .orElseThrow(()->new ReservationApiException(HttpStatus.BAD_REQUEST,"Reservation is not found"));
    }
}
