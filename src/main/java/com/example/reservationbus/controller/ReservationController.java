package com.example.reservationbus.controller;

import com.example.reservationbus.entities.Reservation;
import com.example.reservationbus.model.ResponseModel;
import com.example.reservationbus.services.ReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reservation")
@AllArgsConstructor
public class ReservationController {
    private ReservationService reservationService;

    @PostMapping("/add")
    public ResponseModel<Reservation> addReservation(@RequestBody Reservation reservation){
        Reservation res = reservationService.addReservation(reservation);
        return new ResponseModel<>(HttpStatus.OK.value(),"Reservation success added",res);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Reservation>> getAllReservation(){
        return ResponseEntity.ok(reservationService.getAllReservation());
    }

    @GetMapping("/{mobile}")
    public ResponseEntity<List<Reservation>> getReservationByMobile(@PathVariable(name = "mobile") String mobile){
        List<Reservation> getByMobile = reservationService.getReservationByMobile(mobile);
        return ResponseEntity.ok(getByMobile);
    }

    @GetMapping("/query")
    public ResponseEntity<List<Reservation>> getReservationByScheduleAndDepartureDate(@RequestParam Long scheduleId,@RequestParam String date){
        return ResponseEntity.ok(reservationService.getReservationByScheduleAndDepartureDate(scheduleId,date));
    }

}
