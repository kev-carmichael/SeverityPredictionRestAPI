package com.kev.RestAPI.exception;

public class PicAgeLessThan21AndAirlineTransportLicenceException extends RuntimeException {
    public PicAgeLessThan21AndAirlineTransportLicenceException() {
        super("Error - PicAge is less than 21 and Airline Transport Licence held");
    }
}
