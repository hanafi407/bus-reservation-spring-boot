package com.example.reservationbus.controller;

import com.example.reservationbus.entities.BusSchedule;
import com.example.reservationbus.model.ResponseModel;
import com.example.reservationbus.services.BusScheduleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/schedule")
@AllArgsConstructor
public class BusScheduleController {
    private BusScheduleService busScheduleService;

    @GetMapping("/all")
    public ResponseEntity<List<BusSchedule>> getAllBusSchedule(){
        return ResponseEntity.ok(busScheduleService.getAllBusSchedule());
    }

    @PostMapping("/add")
    public ResponseModel<BusSchedule> addBusSchedule(@RequestBody BusSchedule busSchedule){
        BusSchedule addBusSchedule = busScheduleService.addBusSchedule(busSchedule);

        return new  ResponseModel<>(HttpStatus.OK.value(),"Success added",addBusSchedule);
    }

    @GetMapping("/{routeName}")
    public ResponseEntity<List<BusSchedule>> getScheduleByRouteName(@PathVariable(name = "routeName") String routeName){
        return ResponseEntity.ok(busScheduleService.getBusScheduleByBusRoute(routeName));
    }
}
