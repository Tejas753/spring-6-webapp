package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.domain.Publisher;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import guru.springframework.spring6webapp.repositories.PublisherRepository;
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
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

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

        //storing  the data in the repository
        Author rodSaved = authorRepository.save(rod);
        Book csSaved = bookRepository.save(cs);

        //Creating the association between author and the book
        grahamSaved.getBooks().add(gotSaved);
        rodSaved.getBooks().add(csSaved);

        Publisher maxwell = new Publisher();
        maxwell.setPublisherName("MAXWELL PUBLICATIONS");
        maxwell.setAddress("2951 S king dr");
        maxwell.setCity("Chicago");
        maxwell.setState("IL");
        maxwell.setZip("60616");

        Publisher maxwellSaved = publisherRepository.save(maxwell);

        gotSaved.setPublisher(maxwell);
        csSaved.setPublisher(maxwell);

        authorRepository.save(grahamSaved);
        authorRepository.save(rodSaved);
        bookRepository.save(gotSaved);
        bookRepository.save(csSaved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " +authorRepository.count());
        System.out.println("Book count:" +bookRepository.count());

        System.out.println("Publisher count:" +publisherRepository.count());


    }
}
