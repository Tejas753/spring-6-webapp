package guru.springframework.spring6webapp.repositories;

import guru.springframework.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author : tejas
 * @created : 3/14/23, Tuesday
 **/
public interface BookRepository extends CrudRepository<Book, Long> {
}
