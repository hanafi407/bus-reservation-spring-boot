package com.example.reservationbus.services;

import com.example.reservationbus.entities.Bus;
import com.example.reservationbus.entities.BusRoute;
import com.example.reservationbus.entities.BusSchedule;
import com.example.reservationbus.model.ResponseModel;

import java.util.List;

public interface BusScheduleService {
    List<BusSchedule> getAllBusSchedule();

    BusSchedule addBusSchedule(BusSchedule busSchedule);

   List<BusSchedule> getBusScheduleByBusRoute(String routeName);
}
