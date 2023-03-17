package guru.springframework.spring6webapp.services;

import guru.springframework.spring6webapp.domain.Book;

/**
 * @author : tejas
 * @created : 3/16/23, Thursday
 **/
public interface BookService {

    Iterable<Book> findAll();

}
