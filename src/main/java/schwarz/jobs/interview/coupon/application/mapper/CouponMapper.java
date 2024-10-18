package schwarz.jobs.interview.coupon.application.mapper;

import javax.validation.constraints.NotNull;
import schwarz.jobs.interview.coupon.application.dto.CouponDTO;
import schwarz.jobs.interview.coupon.domain.model.Coupon;
import schwarz.jobs.interview.coupon.infrastructure.adapters.output.persistence.entity.CouponPersistenceEntity;

public class CouponMapper {

    public static CouponDTO toDTO(@NotNull Coupon coupon) {
        return CouponDTO.builder()
                .discount(coupon.getDiscount())
                .code(coupon.getCode())
                .minBasketValue(coupon.getMinBasketValue())
                .build();
    }

    public static Coupon fromDTO(@NotNull CouponDTO couponDTO) {
        return Coupon.builder()
                .discount(couponDTO.getDiscount())
                .code(couponDTO.getCode())
                .minBasketValue(couponDTO.getMinBasketValue())
                .build();
    }

    public static Coupon toDomain(@NotNull CouponPersistenceEntity entity) {
        return Coupon.builder()
                .discount(entity.getDiscount())
                .code(entity.getCode())
                .minBasketValue(entity.getMinBasketValue())
                .build();
    }

    public static CouponPersistenceEntity fromDomain(@NotNull Coupon coupon) {
        return CouponPersistenceEntity.builder()
                .discount(coupon.getDiscount())
                .code(coupon.getCode())
                .minBasketValue(coupon.getMinBasketValue())
                .build();
    }
}
