package schwarz.jobs.interview.coupon.domain.exception;


public class NegativeDiscountException extends RuntimeException {

    public NegativeDiscountException(String message) {
        super(message);
    }
}
