package se.yrgo.library.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.print.Book;
import java.util.List;

@RestController
public class BookRestController {
    @Autowired
    private BookRepository data;


    @RequestMapping(value = "/books", method = RequestMethod.POST)
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        data.save(book);
        return new ResponseEntity<Book>(book, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public BookList allBooks() {
        List<Book> all = data.findAll();
        return new BookList(all);
    }
}
