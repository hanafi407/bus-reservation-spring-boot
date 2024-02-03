package com.example.reservationbus.repos;

import com.example.reservationbus.entities.BusRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BusRouteRepository extends JpaRepository<BusRoute,Long> {
    Optional<BusRoute> findByRouteName(String routeName);
    Optional<BusRoute> findByCityFromAndCityTo(String cityFrom,String cityTo);

}
