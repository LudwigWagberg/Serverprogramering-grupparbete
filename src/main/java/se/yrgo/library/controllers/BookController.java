package se.yrgo.library.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("website/library")
public class BookController {

    //Returns the newBook view.
    @GetMapping("/new")
    public ModelAndView newBook() {
        return new ModelAndView("newBook");
    }

    //Returns the allBooks view.
    @GetMapping("/all")
    public ModelAndView allBooks() {
        return new ModelAndView("allBooks");
    }

    //Returns the bookInfo view
    @GetMapping("/book")
    public ModelAndView bookInfo() {
        return new ModelAndView("bookInfo");
    }
}
