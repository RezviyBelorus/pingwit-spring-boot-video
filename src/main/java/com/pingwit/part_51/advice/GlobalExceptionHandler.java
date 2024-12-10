package com.pingwit.part_51.advice;

import com.pingwit.part_51.exception.CarSharingException;
import com.pingwit.part_51.exception.CarSharingExceptionDto;
import com.pingwit.part_51.property.CarSharingContactsProperty;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final CarSharingContactsProperty property;

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleRuntimeException() {
        String message = "Something goes wrong, please contact our customer support";

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

    @ExceptionHandler(CarSharingException.class)
    public ResponseEntity<CarSharingExceptionDto> handleCarSharingException(CarSharingException e) {
        String message = String.format("%s Please contact our customer support", e.getMessage());

        CarSharingExceptionDto dto = new CarSharingExceptionDto(message, property.phone(), property.email());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(dto);
    }

    // Part_52 - Controller validation
    // Обработка ошибок валидации @RequestBody
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException e) {
        Map<String, String> errors = new HashMap<>();

        e.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        return errors;
    }

    // Part_52 - Controller validation
    // Обработка ошибок валидации @PathVariable и @RequestParam
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(ConstraintViolationException.class)
    public Map<String, String> handleConstraintViolation(ConstraintViolationException e) {
        Map<String, String> errors = new HashMap<>();

        Set<ConstraintViolation<?>> violations = e.getConstraintViolations();

        violations.forEach(violation -> {
            String fieldName = violation.getPropertyPath().toString();
            String message = violation.getMessage();

            errors.put(fieldName, message);
        });

        return errors;
    }
}
