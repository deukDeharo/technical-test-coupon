package schwarz.jobs.interview.coupon.domain.service.implementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import schwarz.jobs.interview.coupon.application.dto.ApplicationRequestDTO;
import schwarz.jobs.interview.coupon.application.dto.CouponDTO;
import schwarz.jobs.interview.coupon.application.dto.CouponRequestDTO;
import schwarz.jobs.interview.coupon.application.ports.output.CouponOutputPort;
import schwarz.jobs.interview.coupon.domain.model.Basket;
import schwarz.jobs.interview.coupon.domain.model.Coupon;
import schwarz.jobs.interview.coupon.domain.service.CouponService;


@Service
@RequiredArgsConstructor
public class CouponServiceImpl implements CouponService {

    private final CouponOutputPort couponOutputPort;

    @Override
    public void createCoupon(Coupon coupon) {
       couponOutputPort.saveCoupon(coupon);
    }

    @Override
    public Collection<Coupon> getCouponsByCodes(Set<String> codSet) {
        return couponOutputPort.getCouponsByCodes(codSet);
    }
    
    // public Optional<Coupon> getCoupon(final String code) {
    //     return couponRepository.findByCode(code);
    // }

    // public Optional<Basket> apply(final Basket basket, final String code) {

    //     return getCoupon(code).map(coupon -> {

    //         if (basket.getValue().doubleValue() >= 0) {

    //             if (basket.getValue().doubleValue() > 0) {

    //                 basket.applyDiscount(coupon.getDiscount());

    //             } else if (basket.getValue().doubleValue() == 0) {
    //                 return basket;
    //             }

    //         } else {
    //             System.out.println("DEBUG: TRIED TO APPLY NEGATIVE DISCOUNT!");
    //             throw new RuntimeException("Can't apply negative discounts");
    //         }

    //         return basket;
    //     });
    // }

    // public Coupon createCoupon(final CouponDTO couponDTO) {

    //     Coupon coupon = null;

    //     try {
    //         coupon = Coupon.builder()
    //             .code(couponDTO.getCode().toLowerCase())
    //             .discount(couponDTO.getDiscount())
    //             .minBasketValue(couponDTO.getMinBasketValue())
    //             .build();

    //     } catch (final NullPointerException e) {

    //         // Don't coupon when code is null
    //     }

    //     return couponRepository.save(coupon);
    // }

    // public List<Coupon> getCoupons(final CouponRequestDTO couponRequestDTO) {

    //     final ArrayList<Coupon> foundCoupons = new ArrayList<>();

    //     couponRequestDTO.getCodes().forEach(code -> foundCoupons.add(couponRepository.findByCode(code).get()));

    //     return foundCoupons;
    // }

  

    
}
