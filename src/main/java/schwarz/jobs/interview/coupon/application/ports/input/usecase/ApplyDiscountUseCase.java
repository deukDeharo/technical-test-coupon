package schwarz.jobs.interview.coupon.application.ports.input.usecase;

import schwarz.jobs.interview.coupon.application.dto.ApplicationRequestDTO;
import schwarz.jobs.interview.coupon.application.dto.BasketDTO;

public interface ApplyDiscountUseCase {
    public BasketDTO applyDiscount(ApplicationRequestDTO dto);
}
