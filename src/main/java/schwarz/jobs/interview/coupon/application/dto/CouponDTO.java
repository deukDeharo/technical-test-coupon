package schwarz.jobs.interview.coupon.application.dto;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouponDTO {

    private BigDecimal discount;

    private String code;

    private BigDecimal minBasketValue;

}
