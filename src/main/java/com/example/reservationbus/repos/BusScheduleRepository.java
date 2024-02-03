package com.example.reservationbus.repos;

import com.example.reservationbus.entities.Bus;
import com.example.reservationbus.entities.BusRoute;
import com.example.reservationbus.entities.BusSchedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BusScheduleRepository extends JpaRepository<BusSchedule,Long> {
   Optional<List<BusSchedule>> findByBusRoute(BusRoute busRoute);
   boolean existsByBusAndBusRouteAndDepartureTime(Bus bus,BusRoute busRoute,String date);
}
