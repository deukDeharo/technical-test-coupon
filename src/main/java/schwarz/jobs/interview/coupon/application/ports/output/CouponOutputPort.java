package schwarz.jobs.interview.coupon.application.ports.output;

import java.util.Collection;

import schwarz.jobs.interview.coupon.domain.model.Coupon;


public interface CouponOutputPort {
    public Coupon saveCoupon(Coupon coupon);

    public Coupon findCouponById(Long id);

    public Collection<Coupon> findCouponsByCodes(Collection<String> codes);

    public Coupon findCouponByCode(String code);

}
