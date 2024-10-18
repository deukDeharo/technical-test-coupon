package schwarz.jobs.interview.coupon.application.ports.input.usecase.implementation;

import java.util.Collection;
import java.util.Set;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import schwarz.jobs.interview.coupon.application.dto.ApplicationRequestDTO;
import schwarz.jobs.interview.coupon.application.dto.BasketDTO;
import schwarz.jobs.interview.coupon.application.dto.CouponDTO;
import schwarz.jobs.interview.coupon.application.dto.CouponRequestDTO;
import schwarz.jobs.interview.coupon.application.mapper.CouponMapper;
import schwarz.jobs.interview.coupon.application.ports.input.usecase.CouponUseCase;
import schwarz.jobs.interview.coupon.domain.model.Coupon;
import schwarz.jobs.interview.coupon.domain.service.CouponService;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CouponUseCaseImpl implements CouponUseCase {

    private final CouponService couponService;
    @Override
    public BasketDTO applyDiscount(ApplicationRequestDTO dto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'applyDiscount'");
    }

    @Override
    public void createCoupon(CouponDTO couponDTO) {
        couponService.createCoupon(CouponMapper.fromDTO(couponDTO));
    }

    @Override
    public Collection<CouponDTO> getCouponsByCodes(CouponRequestDTO requestDTO) {
       Collection<Coupon> coupons = couponService.getCouponsByCodes(requestDTO.getCodes());
       return coupons.stream()
            .map(CouponMapper::toDTO)
            .collect(Collectors.toSet());
    }

    
}
