package com.example.reservationbus.services.impl;

import com.example.reservationbus.entities.BusRoute;
import com.example.reservationbus.model.ReservationApiException;
import com.example.reservationbus.repos.BusRouteRepository;
import com.example.reservationbus.services.BusRouteService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BusRouteServiceImpl implements  BusRouteService {
    private final BusRouteRepository busRouteRepository;
    public BusRouteServiceImpl(BusRouteRepository busRouteRepository){
        this.busRouteRepository=busRouteRepository;
    }

    @Override
    public List<BusRoute> getAllBusRoute() {
        return busRouteRepository.findAll();
    }

    @Override
    public BusRoute addBusRoute(BusRoute busRoute) {
        return busRouteRepository.save(busRoute);
    }

    @Override
    public BusRoute getBusRouteByRouteName(String routeName) {
        return busRouteRepository.findByRouteName(routeName).orElseThrow(
                ()->new ReservationApiException(HttpStatus.BAD_REQUEST,"No such route found"));

    }

    @Override
    public BusRoute getBusRouteByCityFromAndCityTo(String cityFrom, String cityTo) {
        return busRouteRepository.findByCityFromAndCityTo(cityFrom,cityTo).orElseThrow(
                ()->new ReservationApiException(HttpStatus.BAD_REQUEST,"No such route found"));
    }
}
