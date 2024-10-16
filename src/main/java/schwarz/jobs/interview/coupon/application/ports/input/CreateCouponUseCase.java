package schwarz.jobs.interview.coupon.application.ports.input;

import schwarz.jobs.interview.coupon.application.dto.CouponDTO;
import schwarz.jobs.interview.coupon.domain.model.Coupon;

public interface CreateCouponUseCase {
    public Coupon createCoupon(CouponDTO dto);
}
