package se.yrgo.library.rest;

import se.yrgo.library.domain.Book;
import se.yrgo.library.data.BookRepository;
import se.yrgo.library.rest.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookRestController {
    @Autowired
    private BookRepository data;

    //Adds new book to the db.
    @PostMapping("/new")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        data.save(book);
        return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }

    //Lists all books.
    @GetMapping("/all")
    public BookList allBooks() {
        List<Book> all = data.findAll();
        return new BookList(all);
    }

    //Get book by name.
    @GetMapping("/book/{title}")
    public Book getBookByName(@PathVariable("title") String title) {
        return data.findByTitle(title);
    }
}
