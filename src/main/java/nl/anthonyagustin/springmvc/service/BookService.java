package nl.anthonyagustin.springmvc.service;

import nl.anthonyagustin.springmvc.model.Book;

import java.util.List;

public interface BookService {

    public List<Book> getBooks();
    public Book getBookBy(int id);
    public Book getBookByName(String title);
}
