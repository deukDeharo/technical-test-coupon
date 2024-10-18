package schwarz.jobs.interview.coupon.application.ports.output;

import java.util.Collection;

import schwarz.jobs.interview.coupon.domain.model.Coupon;


public interface CouponOutputPort {
    public Coupon saveCoupon(Coupon coupon);

    public Collection<Coupon> getCouponsByCodes(Collection<String> codes);

}
