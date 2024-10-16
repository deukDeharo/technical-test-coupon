package schwarz.jobs.interview.coupon.domain.model;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Basket {

    @NotNull
    private BigDecimal value;

    private Double appliedDiscount;

    private Boolean applicationSuccessful;

    public void applyDiscount(final Double discount) {
        this.applicationSuccessful = false;
        this.appliedDiscount = discount;
    }

}
