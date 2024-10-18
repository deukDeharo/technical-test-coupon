package schwarz.jobs.interview.coupon.application.ports.input.usecase;

import schwarz.jobs.interview.coupon.application.dto.CouponDTO;
import schwarz.jobs.interview.coupon.application.dto.CouponRequestDTO;
import java.util.Collection;

public interface GetCouponsUseCase {
    public Collection<CouponDTO> getCouponsByCodes(CouponRequestDTO requestDTO);
}
