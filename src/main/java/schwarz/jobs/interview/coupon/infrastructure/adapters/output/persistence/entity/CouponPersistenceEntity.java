package schwarz.jobs.interview.coupon.infrastructure.adapters.output.persistence.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "coupon")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CouponPersistenceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, length = 250)
    private String code;

    @Column(name = "discount", nullable = false, precision = 10, scale = 2)
    private Double discount;

    @Column(name = "min_basket_value", precision = 10, scale = 2)
    private Double minBasketValue;
}