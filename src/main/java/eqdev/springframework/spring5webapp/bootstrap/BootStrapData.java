package eqdev.springframework.spring5webapp.bootstrap;

import eqdev.springframework.spring5webapp.domain.Author;
import eqdev.springframework.spring5webapp.domain.Book;
import eqdev.springframework.spring5webapp.domain.Publisher;
import eqdev.springframework.spring5webapp.repositories.AuthorRepository;
import eqdev.springframework.spring5webapp.repositories.BookRepository;
import eqdev.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Publisher peng = new Publisher("Penguin Books", "8524 Burnet Rd APT 721", "Austin", "TX", "78757");
        publisherRepository.save(peng);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(peng);
        peng.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(peng);
        peng.getBooks().add(noEJB);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        System.out.println("\nStarted in Bootstrap");
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Publisher Number of Books: " + peng.getBooks().size());
    }
}
