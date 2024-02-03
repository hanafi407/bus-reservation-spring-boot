package com.example.reservationbus.services;

import com.example.reservationbus.entities.BusRoute;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface BusRouteService {
    List<BusRoute> getAllBusRoute();
    BusRoute addBusRoute(BusRoute busRoute);
    BusRoute getBusRouteByRouteName(String routeName);
    BusRoute getBusRouteByCityFromAndCityTo(String cityFrom,String cityTo);
}
