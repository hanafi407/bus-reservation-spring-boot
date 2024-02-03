package com.example.reservationbus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class ReservationbusApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReservationbusApplication.class, args);
//		try {
//			InetAddress localhost = InetAddress.getLocalHost();
//			System.out.println("IP Address: " + localhost.getHostAddress());
//			System.out.println("Hostname: " + localhost.getHostName());
//		} catch (UnknownHostException e) {
//			e.printStackTrace();
//		}
//		System.out.println("running");
	}


}
