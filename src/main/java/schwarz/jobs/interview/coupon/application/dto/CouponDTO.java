package schwarz.jobs.interview.coupon.application.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouponDTO {

    @NotNull
    private Double discount;

    @NotEmpty
    private String code;

    private Double minBasketValue;

}
