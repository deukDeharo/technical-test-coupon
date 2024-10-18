package schwarz.jobs.interview.coupon.infrastructure.adapters.input.web.rest;


import java.util.Collection;

import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import schwarz.jobs.interview.coupon.application.dto.ApplicationRequestDTO;
import schwarz.jobs.interview.coupon.application.dto.BasketDTO;
import schwarz.jobs.interview.coupon.application.dto.CouponDTO;
import schwarz.jobs.interview.coupon.application.dto.CouponRequestDTO;
import schwarz.jobs.interview.coupon.application.ports.input.usecase.CouponUseCase;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api/coupon")
@Slf4j
public class CouponRestAdapter {

    private final CouponUseCase couponUseCase;
    
    @PostMapping(value = "/apply")
    public ResponseEntity<BasketDTO> apply(
        @ApiParam(value = "Provides the necessary basket and customer information required for the coupon application", required = true)
        @RequestBody @Valid final ApplicationRequestDTO applicationRequestDTO) {
            return  ResponseEntity.ok(couponUseCase.applyDiscount(applicationRequestDTO));
        }

    @PostMapping("/")
    public ResponseEntity<Void> createCoupon(@RequestBody @Valid final CouponDTO couponDTO){
        couponUseCase.createCoupon(couponDTO);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/search")
    public ResponseEntity<Collection<CouponDTO>> getCoupons(@RequestBody @Valid CouponRequestDTO couponRequestDTO) {
        return ResponseEntity.ok(couponUseCase.getCouponsByCodes(couponRequestDTO));
    }

}
