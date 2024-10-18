package schwarz.jobs.interview.coupon.domain.service.implementation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import schwarz.jobs.interview.coupon.application.ports.output.CouponOutputPort;
import schwarz.jobs.interview.coupon.domain.exception.NegativeDiscountException;
import schwarz.jobs.interview.coupon.domain.model.Basket;
import schwarz.jobs.interview.coupon.domain.model.Coupon;
import java.math.BigDecimal;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@ExtendWith(SpringExtension.class)
class CouponServiceImplTest {

    @Mock
    private CouponOutputPort couponOutputPort;

    @InjectMocks
    private CouponServiceImpl couponService;

    @Test
    void createCoupon_ShouldInvokeOutputPortSave() {
        Coupon coupon = new Coupon(null, "TEST1", 10.00, 50.00);
        couponService.createCoupon(coupon);
        verify(couponOutputPort, times(1)).saveCoupon(coupon);
    }

    @Test
    void getCouponsByCodes_ShouldReturnCoupons() {
        Set<String> codes = Set.of("CODE1");
        when(couponOutputPort.getCouponsByCodes(codes)).thenReturn(Collections.singleton(new Coupon(null, "CODE1", 15.00, 50.00)));

        Collection<Coupon> coupons = couponService.getCouponsByCodes(codes);

        assertNotNull(coupons);
        assertEquals(1, coupons.size());
        verify(couponOutputPort, times(1)).getCouponsByCodes(codes);
    }

    @Test
    void applyDiscount_ShouldApplyDiscountIfValid() {
        Basket basket = Basket.builder()
                .value(new BigDecimal("100.00"))
                .appliedDiscount(0.0)
                .applicationSuccessful(false)
                .build();
        
        Coupon coupon = new Coupon(null, "CODE1", 15.00, 50.00);

        when(couponOutputPort.getCouponByCode(anyString())).thenReturn(coupon);

        Basket result = couponService.applyDiscount(basket, "CODE1");

        assertNotNull(result);
        assertEquals(new BigDecimal("85.00"), result.getValue());
        verify(couponOutputPort, times(1)).getCouponByCode(anyString());
    }

    @Test
    void applyDiscount_ShouldThrowExceptionForNegativeValue() {
        Basket basket = Basket.builder()
                .value(new BigDecimal("-10.00"))
                .appliedDiscount(0.0)
                .applicationSuccessful(false)
                .build();

        NegativeDiscountException exception = assertThrows(NegativeDiscountException.class, () ->
            couponService.applyDiscount(basket, "CODE_NEG")
        );

        assertEquals("Can't apply negative discounts", exception.getMessage());
    }

    @Test
    void applyDiscount_ShouldThrowExceptionForZeroValue() {
        Basket basket = Basket.builder()
                .value(new BigDecimal("0.00"))
                .appliedDiscount(0.0)
                .applicationSuccessful(false)
                .build();

        NegativeDiscountException exception = assertThrows(NegativeDiscountException.class, () ->
            couponService.applyDiscount(basket, "CODE_ZERO")
        );

        assertEquals("Can't apply empty discounts", exception.getMessage());
    }
}