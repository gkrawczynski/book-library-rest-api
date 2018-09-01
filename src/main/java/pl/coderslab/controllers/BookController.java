package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping("/booksList")
    public List<Book> booksList(){
        List<Book> booksList = memoryBookService.getList();
        return booksList;
    }

}

