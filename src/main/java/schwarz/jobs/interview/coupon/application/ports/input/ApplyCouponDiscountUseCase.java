package schwarz.jobs.interview.coupon.application.ports.input;

import schwarz.jobs.interview.coupon.application.dto.ApplicationRequestDTO;
import schwarz.jobs.interview.coupon.domain.model.Basket;

public interface ApplyCouponDiscountUseCase {
    public Basket applyDiscount(ApplicationRequestDTO dto);
}
