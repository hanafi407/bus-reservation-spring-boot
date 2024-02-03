package com.example.reservationbus.model;

import org.springframework.http.HttpStatus;

public class ReservationApiException extends RuntimeException{
    private HttpStatus status;
    private String message;

    public ReservationApiException(HttpStatus status,String message){
        this.status=status;
        this.message=message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
