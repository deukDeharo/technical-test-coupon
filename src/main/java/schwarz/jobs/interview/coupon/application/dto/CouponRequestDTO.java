package schwarz.jobs.interview.coupon.application.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CouponRequestDTO {

    @NotEmpty
    private List<String> codes;

}
