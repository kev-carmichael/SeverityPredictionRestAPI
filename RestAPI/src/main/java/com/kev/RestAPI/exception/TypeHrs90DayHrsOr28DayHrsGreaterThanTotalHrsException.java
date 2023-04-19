package com.kev.RestAPI.exception;

public class TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException extends RuntimeException {
    public TypeHrs90DayHrsOr28DayHrsGreaterThanTotalHrsException() {
        super("Error - type hrs, 90-day hrs or 28-day hrs greater than total hrs");
    }
}
