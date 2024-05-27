package se.yrgo.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import se.yrgo.library.data.BookRepository;
import se.yrgo.library.domain.Book;

import java.util.List;

@Controller
@RequestMapping("website/library")
public class BookController {

    @Autowired
    private BookRepository data;

    // stores a book in database
    @RequestMapping(value = "/newBook.html", method = RequestMethod.POST)
    public String newBook(Book book) {
        data.save(book);
        return "redirect:/website/library/list.html";
    }

    // generate initial form
    @RequestMapping(value = "/newBook.html", method = RequestMethod.GET)
    public ModelAndView renderNewBookForm() {
        Book newBook = new Book();
        return new ModelAndView("newBook", "form", newBook);
    }

    // returns a list of all books
    @RequestMapping(value = "/list.html", method = RequestMethod.GET)
    public ModelAndView books() {
        List<Book> allBooks = data.findAll();
        return new ModelAndView("allBooks", "library",
                allBooks);
    }

    // finds a book by its title
    @RequestMapping(value = "/book/{title}")
    public ModelAndView showBookByTitle(@PathVariable("title") String
                                                title) {
        Book book = data.findByTitle(title);
        return new ModelAndView("bookInfo", "book", book);
    }
}
