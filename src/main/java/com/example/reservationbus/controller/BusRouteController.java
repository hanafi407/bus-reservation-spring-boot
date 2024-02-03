package com.example.reservationbus.controller;

import com.example.reservationbus.entities.BusRoute;
import com.example.reservationbus.model.ResponseModel;
import com.example.reservationbus.services.BusRouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/route")
@RequiredArgsConstructor
public class BusRouteController {
    private final BusRouteService busRouteService;

    @GetMapping("/all")
    public ResponseEntity<List<BusRoute>> getAllBusRoute(){
        List<BusRoute> busRoute = busRouteService.getAllBusRoute();
        return  ResponseEntity.ok(busRoute);
    }

    @PostMapping("/add")
    public ResponseModel<BusRoute> addBusRoute(@RequestBody BusRoute busRoute){
        BusRoute busRoute1 = busRouteService.addBusRoute(busRoute);
        return new ResponseModel<>(HttpStatus.OK.value(),"Bus route add successfully",busRoute1);
    }

    @GetMapping("/{routeName}")
    public ResponseEntity<BusRoute> getBusRouteByRouteName(@PathVariable(name = "routeName") String routeName){
        BusRoute route = busRouteService.getBusRouteByRouteName(routeName);
        return  ResponseEntity.ok(route);

    }

    @GetMapping("/query")
    public ResponseEntity<BusRoute> getBusRouteByCityFromAndCityTo(@RequestParam String cityFrom,@RequestParam String cityTo){

        return ResponseEntity.ok(busRouteService.getBusRouteByCityFromAndCityTo(cityFrom,cityTo));
    }
}
