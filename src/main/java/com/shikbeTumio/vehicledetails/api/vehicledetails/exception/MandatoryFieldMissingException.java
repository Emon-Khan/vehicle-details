package com.shikbeTumio.vehicledetails.api.vehicledetails.exception;

public class MandatoryFieldMissingException extends Exception {
    public MandatoryFieldMissingException(String allErrors) {
        super(allErrors);
    }
}
