package schwarz.jobs.interview.coupon.infrastructure.adapters.output.persistence.implementation;

import java.util.Collection;

import javax.persistence.EntityNotFoundException;

import lombok.RequiredArgsConstructor;
import schwarz.jobs.interview.coupon.application.ports.output.CouponOutputPort;
import schwarz.jobs.interview.coupon.domain.model.Coupon;
import schwarz.jobs.interview.coupon.infrastructure.adapters.output.persistence.repository.CouponPersistenceRepository;

@RequiredArgsConstructor
public class CouponOutputPortImpl implements CouponOutputPort {

    private final CouponPersistenceRepository repository;

    @Override
    public Coupon saveCoupon(Coupon coupon) {
        return repository.save(coupon);
    }

    @Override
    public Coupon getCouponById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Coupon with ID %s does not exist", id)));
    }

    @Override
    public Collection<Coupon> getCouponsByCodes(Collection<String> codes) {
        return repository.findAllByCodeIn(codes);
    }

    @Override
    public Coupon getCouponByCode(String code) {
        return repository.findByCode(code)
                .orElseThrow(() -> new EntityNotFoundException(String.format("Coupon with code %s does not exist", code)));
    }

}
