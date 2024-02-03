package com.example.reservationbus.services.impl;

import com.example.reservationbus.entities.BusRoute;
import com.example.reservationbus.entities.BusSchedule;
import com.example.reservationbus.model.ReservationApiException;
import com.example.reservationbus.repos.BusRouteRepository;
import com.example.reservationbus.repos.BusScheduleRepository;
import com.example.reservationbus.services.BusScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class BusScheduleServiceImpl implements BusScheduleService {
    private BusScheduleRepository busScheduleRepository;
    private BusRouteRepository busRouteRepository;

    @Override
    public List<BusSchedule> getAllBusSchedule() {
        return busScheduleRepository.findAll();
    }

    @Override
    public BusSchedule addBusSchedule(BusSchedule busSchedule) throws ResponseStatusException {
        boolean existBusSchedule = busScheduleRepository.existsByBusAndBusRouteAndDepartureTime(
                busSchedule.getBus(), busSchedule.getBusRoute(), busSchedule.getDepartureTime()
        );
        if (existBusSchedule) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Bus schedule exist");

        }
        return busScheduleRepository.save(busSchedule);
    }

    @Override
    public List<BusSchedule> getBusScheduleByBusRoute(String routeName) {
        BusRoute busRoute = busRouteRepository.findByRouteName(routeName)
                .orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST, "Route bus not found"));
        return busScheduleRepository.findByBusRoute(busRoute)
                .orElseThrow(() -> new ReservationApiException(HttpStatus.BAD_REQUEST, "Bus route not found"));
    }
}
