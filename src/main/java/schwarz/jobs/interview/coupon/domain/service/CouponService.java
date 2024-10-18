package schwarz.jobs.interview.coupon.domain.service;

import java.util.Collection;
import java.util.Set;
import schwarz.jobs.interview.coupon.domain.model.Basket;
import schwarz.jobs.interview.coupon.domain.model.Coupon;

public interface CouponService {
    public Basket applyDiscount(Basket basket, String code);
    public void createCoupon(Coupon coupon);
    public Collection<Coupon> getCouponsByCodes(Set<String> codSet);
}
