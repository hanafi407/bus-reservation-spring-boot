package com.example.reservationbus.services.impl;

import com.example.reservationbus.entities.Bus;
import com.example.reservationbus.repos.BusRepository;
import com.example.reservationbus.services.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    private final BusRepository busRepository;

    public BusServiceImpl(BusRepository busRepository){
        this.busRepository=busRepository;
    }
    @Override
    public Bus addBus(Bus bus) {
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> getAllBus() {
        return busRepository.findAll();
    }
}
