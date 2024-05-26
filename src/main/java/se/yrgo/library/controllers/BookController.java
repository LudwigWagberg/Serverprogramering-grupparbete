package se.yrgo.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
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

    //Lists all books.
    @RequestMapping(value = "/all-books", method = RequestMethod.GET)
    public List<Book> books() {
        return data.findAll();
    }

    //Get book by name.
    @RequestMapping(value = "/name/{name}", method = RequestMethod.GET)
    public Book getBookByName(@PathVariable("name") String name) {
        return data.findByTitle(name);
    }
}
