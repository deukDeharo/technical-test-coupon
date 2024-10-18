package schwarz.jobs.interview.coupon.application.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BasketDTO {

    @NotNull
    private BigDecimal value;

    @NotNull
    private Double appliedDiscount;

    private Boolean applicationSuccessful;

}
