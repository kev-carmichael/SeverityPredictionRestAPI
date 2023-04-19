package com.kev.RestAPI.exception;

public class TwentyEightDayHrsGreaterThan90DayHrsException extends RuntimeException {
    public TwentyEightDayHrsGreaterThan90DayHrsException() {
        super("Error - 28 day hrs greater than 90 day hrs");
    }
}
