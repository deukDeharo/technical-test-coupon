package schwarz.jobs.interview.coupon.infrastructure.adapters.output.persistence.repository;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import schwarz.jobs.interview.coupon.domain.model.Coupon;

public interface CouponPersistenceRepository extends JpaRepository<Coupon, Long> {

    Optional<Coupon> findByCode(final String code);

    Collection<Coupon> findAllByCodeIn(Collection<String> codes);

}
