package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author : tejas
 * @created : 3/14/23, Tuesday
 **/

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author graham = new Author();
        graham.setFirstName("Graham");
        graham.setLastName("Stevens");

        Book got = new Book();
        got.setTitle("Game of Thrones");
        got.setIsbn("A76-66363-37373");

        Author grahamSaved = authorRepository.save(graham);
        Book gotSaved = bookRepository.save(got);

        Author rod = new Author();
        rod.setFirstName("Rodriguous");
        rod.setLastName("James");

        Book cs = new Book();
        cs.setTitle("Intro to CS");
        cs.setIsbn("B21-3423-23233");

        Author rodSaved = authorRepository.save(rod);
        Book csSaved = bookRepository.save(cs);

        grahamSaved.getBooks().add(gotSaved);
        rodSaved.getBooks().add(csSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " +authorRepository.count());
        System.out.println("Book count:" +bookRepository.count());

    }
}
