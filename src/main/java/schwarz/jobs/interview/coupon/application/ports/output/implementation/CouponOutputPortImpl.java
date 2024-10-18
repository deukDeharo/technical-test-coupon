package schwarz.jobs.interview.coupon.application.ports.output.implementation;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import schwarz.jobs.interview.coupon.application.mapper.CouponMapper;
import schwarz.jobs.interview.coupon.application.ports.output.CouponOutputPort;
import schwarz.jobs.interview.coupon.domain.model.Coupon;
import schwarz.jobs.interview.coupon.infrastructure.adapters.output.persistence.entity.CouponPersistenceEntity;
import schwarz.jobs.interview.coupon.infrastructure.adapters.output.persistence.repository.CouponPersistenceRepository;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CouponOutputPortImpl implements CouponOutputPort {

    private final CouponPersistenceRepository repository;

    @Override
    public Coupon saveCoupon(Coupon coupon) {
        CouponPersistenceEntity entity = repository.save(CouponMapper.fromDomain(coupon));
        return CouponMapper.toDomain(entity);
    }

    @Override
    public Collection<Coupon> getCouponsByCodes(Collection<String> codes) {
        Collection<CouponPersistenceEntity> couponsEntity = repository.findAllByCodeIn(codes);
        return couponsEntity.stream()
            .map(CouponMapper::toDomain)
            .collect(Collectors.toSet());
    }

    // @Override
    // public Coupon getCouponByCode(String code) {
    //     return repository.findByCode(code)
    //             .orElseThrow(() -> new EntityNotFoundException(String.format("Coupon with code %s does not exist", code)));
    // }

}
