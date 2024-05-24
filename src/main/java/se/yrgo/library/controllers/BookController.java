package se.yrgo.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;


@RestController
@RequestMapping("website/library")
public class BookController {
    @Autowired
    private BookRepository data;

    //Adds new book to the db.
    @RequestMapping(value = "/new-book", method = RequestMethod.POST)
    public Book newBook(@RequestBody Book book) {
        data.save(book);
        return book;
    }

    //An empty book for the user to fill in.
    @RequestMapping(value = "/new-book", method = RequestMethod.GET)
    public Book renderNewBook() {
        return new Book();
    }

    //Lists all books.
    @RequestMapping(value = "/list-books", method = RequestMethod.GET)
    public List<Book> books() {
        return data.findAll();
    }

    //Get book by name.
    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public Book getBookByName(@PathVariable("name") String name) {
        return data.findByName(name);
    }
}
