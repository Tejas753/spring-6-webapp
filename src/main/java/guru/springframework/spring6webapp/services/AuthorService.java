package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Author;

/**
 * @author : tejas
 * @created : 3/17/23, Friday
 **/
public interface AuthorService {
    Iterable<Author> findAll();
}
