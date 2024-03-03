package pl.slabonart.epam_java_backend_services_3.repository;

import org.springframework.data.repository.CrudRepository;
import pl.slabonart.epam_java_backend_services_3.domain.Subscription;

public interface SubscriptionRepository extends CrudRepository<Subscription, Long> {

}
