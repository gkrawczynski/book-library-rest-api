package pl.coderslab.models;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Service
public class MemoryBookService {
    private List<Book> list;

    public MemoryBookService() {
        list = new ArrayList<>();
        list.add(new Book(1L, "9788324631766", "Thinking in Java", "Bruce Eckel","Helion", "programming"));
        list.add(new Book(2L, "9788324627738", "Rusz glowa, Java.","Sierra Kathy, Bates Bert", "Helion", "programming"));
        list.add(new Book(3L, "9780130819338", "Java 2. Podstawy","Cay Horstmann, Gary Cornell", "Helion", "programming"));
    }

    public List<Book> getList() {
        return list;
    }

    public Book getById(long id){
        Book book = getList().stream()
                .filter(g -> g.getId() == id)
                .findAny().get();

        return book;
    }

    public void editBook(long id, String isbn, String title, String author, String publisher, String type) {
        Book book = getList().stream()
                .filter(e -> e.getId() == id)
                .findAny()
                .get();

        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setType(type);
    }

    public void addBook(String isbn, String title, String author, String publisher, String type){
        Book book = new Book();
        book.setId(Book.getFirstIdAvailable());
        book.setIsbn(isbn);
        book.setTitle(title);
        book.setAuthor(author);
        book.setPublisher(publisher);
        book.setType(type);

        System.out.println("Book added to books library: " + book.toString());
        this.list.add(book);
    }

    public void delBook(long id){
        List<Book> delBook = getList().stream()
                .filter(d -> d.getId() != id)
                .collect(Collectors.toList());
        this.list = delBook;
    }

}
