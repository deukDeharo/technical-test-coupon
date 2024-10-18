package schwarz.jobs.interview.coupon.application.ports.input.usecase;

import schwarz.jobs.interview.coupon.application.dto.CouponDTO;

public interface CreateCouponUseCase {
    public void createCoupon(CouponDTO couponDTO);
}
