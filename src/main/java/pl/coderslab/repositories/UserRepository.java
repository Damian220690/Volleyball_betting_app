package pl.coderslab.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.model.entities.User;

public interface UserRepository extends JpaRepository<User,Long> {
}
