package com.example.reservationbus.services;

import com.example.reservationbus.entities.Bus;

import java.util.List;

public interface BusService {
    Bus addBus(Bus bus);
    List<Bus> getAllBus();
}
