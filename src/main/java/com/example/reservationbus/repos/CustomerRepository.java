package com.example.reservationbus.repos;

import com.example.reservationbus.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer ,Long> {
    Optional<Customer> findByMobileAndEmail(String mobile, String email);
    Optional<Customer> findByMobile(String mobile);
    Optional<Customer> findByEmail(String email);

    boolean existsByMobileAndEmail(String mobile,String email);
    boolean existsByMobile(String mobile);
    boolean existsByEmail(String email);
}
