package se.yrgo.library.rest;


import java.util.List;
import se.yrgo.library.domain.Book;

public class BookList {
    private List<Book> books;

    public BookList() {

    }

    public BookList(List<Book> books) {
        this.books = books;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
