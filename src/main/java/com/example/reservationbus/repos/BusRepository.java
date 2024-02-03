package com.example.reservationbus.repos;

import com.example.reservationbus.entities.Bus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BusRepository extends JpaRepository<Bus,Long> {

}
