package com.shikbeTumio.vehicledetails.api.vehicledetails.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.shikbeTumio.vehicledetails.api.vehicledetails.exception.ErrorResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
@ResponseStatus
public class VehicleDetailsExceptionHandler {
    @ExceptionHandler(MandatoryFieldMissingException.class)
    public ResponseEntity<ErrorResponse> handleMandatoryFieldMissing(MandatoryFieldMissingException ex){
        String msg = ex.getMessage();
        List<String> errors = Arrays.stream(msg.split(",")).collect(Collectors.toList());
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST, errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(VehicleNotSaved.class)
    public ResponseEntity<ErrorResponse> handleVehicleNotSaved(VehicleNotSaved ex){
        String msg = ex.getMessage();
        List<String> errors = Arrays.stream(msg.split(",")).collect(Collectors.toList());
        ErrorResponse errorResponse = new ErrorResponse(HttpStatus.EXPECTATION_FAILED, errors);
        return new ResponseEntity<>(errorResponse, HttpStatus.EXPECTATION_FAILED);
    }
}
