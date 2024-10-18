package schwarz.jobs.interview.coupon.infrastructure.adapters.output.persistence.repository;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import schwarz.jobs.interview.coupon.infrastructure.adapters.output.persistence.entity.CouponPersistenceEntity;

public interface CouponPersistenceRepository extends JpaRepository<CouponPersistenceEntity, Long> {

    Optional<CouponPersistenceEntity> findByCode(final String code);

    @Query("SELECT c FROM CouponPersistenceEntity c WHERE c.code IN :codes")
    Collection<CouponPersistenceEntity> findAllByCodeIn(Collection<String> codes);

    

}
