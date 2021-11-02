package novo.novoAvtorKniga.bootstrap;


import novo.novoAvtorKniga.domain.Author;
import novo.novoAvtorKniga.domain.Book;
import novo.novoAvtorKniga.domain.Publisher;
import novo.novoAvtorKniga.repositories.AuthorRepository;
import novo.novoAvtorKniga.repositories.BookRepository;
import novo.novoAvtorKniga.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("St. Petersturg");
        publisher.setState("FL");

        publisherRepository.save(publisher);
        System.out.println("Publisher Count: " + publisherRepository.count());

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(publisher);
        publisher.getBooks().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noJEB = new Book("J2EE Development without EJB", "21464567");
        rod.getBooks().add(noJEB);
        noJEB.getAuthors().add(rod);
        noJEB.setPublisher(publisher);
        publisher.getBooks().add(noJEB);

        authorRepository.save(rod);
        bookRepository.save(noJEB);
        publisherRepository.save(publisher);

        System.out.println("Number of books " + bookRepository.count());
        System.out.println("Publisher number of books " + publisher.getBooks().size());
    }
}
