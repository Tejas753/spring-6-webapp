package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : tejas
 * @created : 3/14/23, Tuesday
 **/
public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
