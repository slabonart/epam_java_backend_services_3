package pl.slabonart.epam_java_backend_services_3.repository;

import org.springframework.data.repository.CrudRepository;
import pl.slabonart.epam_java_backend_services_3.domain.User;

public interface UserRepository extends CrudRepository<User, Long> {
}
