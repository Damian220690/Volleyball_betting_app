package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.entities.CouponMatch;

public interface CouponMatchRepository extends JpaRepository<CouponMatch, Long> {
}
