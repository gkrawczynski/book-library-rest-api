package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.models.Book;
import pl.coderslab.models.MemoryBookService;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    MemoryBookService memoryBookService;

    @RequestMapping("/hello")
    public String hello() {
        return "{hello: World}";
    }

    @RequestMapping("/helloBook")
    public Book helloBook(){
        return new Book(1L,"9788324631766","Thinking in Java","Bruce Eckel","Helion","programming");
    }

    @RequestMapping("/")
    public List<Book> booksList(){
        List<Book> booksList = memoryBookService.getList();
        return booksList;
    }

    @GetMapping("{id}")
    public Book getBook (@PathVariable long id){
        Book book = memoryBookService.getById(id);
        return book;
    }

    @DeleteMapping({"id"})
    public void delBook(@PathVariable long id){
        memoryBookService.delBook(id);
    }

    @PostMapping("/")
    public void addBook(@RequestBody Book book){
        String isbn = book.getIsbn();
        String title = book.getTitle();
        String publisher = book.getPublisher();
        String type = book.getType();
        String author = book.getAuthor();
        memoryBookService.addBook(isbn, title, author, publisher, type);
    }
}

