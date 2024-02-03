package com.example.reservationbus.controller;

import com.example.reservationbus.entities.Bus;
import com.example.reservationbus.model.ResponseModel;
import com.example.reservationbus.services.BusService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bus")
public class BusController {
    private final BusService busService;
    BusController(BusService busService){
        this.busService=busService;
    }

    @PostMapping("/add")
    public ResponseModel<Bus> addBus(@RequestBody Bus bus){
       Bus savedBus= busService.addBus(bus);
        return new ResponseModel<>(HttpStatus.OK.value(),"Add successfully",savedBus);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Bus>> getAllBus(){
        return ResponseEntity.ok(busService.getAllBus());
    }
}
