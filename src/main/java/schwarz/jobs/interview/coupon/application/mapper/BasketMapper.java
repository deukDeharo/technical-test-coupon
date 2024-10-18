package schwarz.jobs.interview.coupon.application.mapper;

import javax.validation.constraints.NotNull;

import schwarz.jobs.interview.coupon.application.dto.BasketDTO;
import schwarz.jobs.interview.coupon.domain.model.Basket;

public class BasketMapper {

    public static BasketDTO toDTO(@NotNull Basket basket) {
        return BasketDTO.builder()
                .value(basket.getValue())
                .appliedDiscount(basket.getAppliedDiscount())
                .applicationSuccessful(basket.getApplicationSuccessful())
                .build();
    }

    public static Basket fromDTO(@NotNull BasketDTO basketDTO) {
        return Basket.builder()
                .value(basketDTO.getValue())
                .appliedDiscount(basketDTO.getAppliedDiscount())
                .applicationSuccessful(basketDTO.getApplicationSuccessful())
                .build();
    }
}