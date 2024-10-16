package schwarz.jobs.interview.coupon.application.ports.input;

import java.util.Collection;
import java.util.Set;

import schwarz.jobs.interview.coupon.domain.model.Coupon;

public interface GetCouponsByCodeUseCase {
    public Coupon getCouponByCode(String code);

    public Collection<Coupon> getCouponsByCodes(Set<String> codSet);
    
}
