package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.coderslab.model.entities.Coupon;

import java.util.Set;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long> {
    Set<Coupon> findAllByCouponsNumber(long id);
}
