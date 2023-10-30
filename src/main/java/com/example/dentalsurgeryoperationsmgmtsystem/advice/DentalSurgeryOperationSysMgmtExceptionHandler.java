package com.example.dentalsurgeryoperationsmgmtsystem.advice;

import com.example.dentalsurgeryoperationsmgmtsystem.exceptions.PatientNotFoundException;

import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class DentalSurgeryOperationSysMgmtExceptionHandler {

    @ExceptionHandler({PatientNotFoundException.class})
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, String> handlePatientNotFoundException(PatientNotFoundException patientNotFoundException){
        Map<String, String> errorMessageMap= new HashMap<>();
        errorMessageMap.put("errorMessage", patientNotFoundException.getMessage());
        return errorMessageMap;
    }

//    @ExceptionHandler({userNotFoundException.class})
//    @ResponseStatus(HttpStatus.NOT_FOUND)
//    public Map<String, String> userNotFoundException(UserNotFoundException userNotFoundException){
//        Map<String, String> errorMessageMap= new HashMap<>();
//        errorMessageMap.put("errorMessage", UserNotFoundException.getMessage());
//        return errorMessageMap;
//    }
}
