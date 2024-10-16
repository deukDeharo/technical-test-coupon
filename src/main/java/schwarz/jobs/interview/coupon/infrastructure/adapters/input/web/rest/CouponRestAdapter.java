package schwarz.jobs.interview.coupon.infrastructure.adapters.input.web.rest;


import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import schwarz.jobs.interview.coupon.application.dto.ApplicationRequestDTO;
import schwarz.jobs.interview.coupon.application.dto.CouponDTO;
import schwarz.jobs.interview.coupon.application.dto.CouponRequestDTO;
import schwarz.jobs.interview.coupon.domain.model.Basket;
import schwarz.jobs.interview.coupon.domain.model.Coupon;
import schwarz.jobs.interview.coupon.domain.service.CouponService;


@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
@Slf4j
public class CouponRestAdapter {

    private final CouponService couponService;

    /**
     * @param applicationRequestDTO
     * @return
     */
    //@ApiOperation(value = "Applies currently active promotions and coupons from the request to the requested Basket - Version 1")
    @PostMapping(value = "/apply")
    public ResponseEntity<Basket> apply(
        //@ApiParam(value = "Provides the necessary basket and customer information required for the coupon application", required = true)
        @RequestBody @Valid final ApplicationRequestDTO applicationRequestDTO) {

        log.info("Applying coupon");

        final Optional<Basket> basket =// always will be not successfull, as we do not have any point on the service that will set is as true 
            couponService.apply(applicationRequestDTO.getBasket(), applicationRequestDTO.getCode());

        if (basket.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        if (!applicationRequestDTO.getBasket().isApplicationSuccessful()) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        log.info("Applied coupon");

        return ResponseEntity.ok().body(applicationRequestDTO.getBasket()); 
        // returns the original basket, no the one with the discout applied. Even if we didn't have the issue with the isApplicationSuccessful
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody @Valid final CouponDTO couponDTO) {

        final Coupon coupon = couponService.createCoupon(couponDTO);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/coupons")
    public List<Coupon> getCoupons(@RequestBody @Valid final CouponRequestDTO couponRequestDTO) {

        return couponService.getCoupons(couponRequestDTO);
    }
}
