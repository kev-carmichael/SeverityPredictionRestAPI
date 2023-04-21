package com.kev.RestAPI.exception;

public class PicAgeLess17AndPrivatePilotLicenceException extends RuntimeException{
    public PicAgeLess17AndPrivatePilotLicenceException() {
        super("Error - Pic age is than 17 and private pilot licence held");
    }
}
