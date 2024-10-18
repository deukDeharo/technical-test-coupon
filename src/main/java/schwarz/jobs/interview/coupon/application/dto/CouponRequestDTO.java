package schwarz.jobs.interview.coupon.application.dto;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class CouponRequestDTO {

    private Set<String> codes;

    public CouponRequestDTO(Set<String> codes) {
        this.codes = codes;
    }

    public CouponRequestDTO() {
    }

    public Set<String> getCodes() {
        return codes;
    }

    public void setCodes(Set<String> codes) {
        this.codes = codes;
    }
    
}
