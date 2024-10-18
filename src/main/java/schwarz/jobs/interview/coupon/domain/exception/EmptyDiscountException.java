package schwarz.jobs.interview.coupon.domain.exception;


public class EmptyDiscountException extends RuntimeException {

    public EmptyDiscountException(String message) {
        super(message);
    }
}
