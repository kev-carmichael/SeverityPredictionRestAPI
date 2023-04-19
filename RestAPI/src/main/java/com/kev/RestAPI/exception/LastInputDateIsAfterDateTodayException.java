package com.kev.RestAPI.exception;

public class LastInputDateIsAfterDateTodayException extends RuntimeException {

    public LastInputDateIsAfterDateTodayException() {
        super("Error - Date of last input for simulation is later than today's date");
    }
}
