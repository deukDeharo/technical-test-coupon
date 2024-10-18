package schwarz.jobs.interview.coupon.infrastructure.adapters.input.web.rest.advice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import schwarz.jobs.interview.coupon.domain.exception.EmptyDiscountException;
import schwarz.jobs.interview.coupon.domain.exception.NegativeDiscountException;
import java.util.NoSuchElementException;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class CouponRestAdvice {

    private static final Logger log = LoggerFactory.getLogger(CouponRestAdvice.class);

    @ExceptionHandler(NegativeDiscountException.class)
    public ResponseEntity<String> handleNegativeDiscountException(NegativeDiscountException e) {
        log.error("NegativeDiscountException: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(EmptyDiscountException.class)
    public ResponseEntity<String> handleEmptyDiscountException(EmptyDiscountException e) {
        log.error("EmptyDiscountException: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<String> handleNoSuchElementException(NoSuchElementException e) {
        log.error("NoSuchElementException: {}", e.getMessage());
        return new ResponseEntity<>("Requested resource not found.", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> handleEntityNotFoundException(EntityNotFoundException e) {
        log.error("EntityNotFoundException: {}", e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGeneralException(Exception e) {
        log.error("Exception: {}", e.getMessage(), e);
        return new ResponseEntity<>("An unexpected error occurred.", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}