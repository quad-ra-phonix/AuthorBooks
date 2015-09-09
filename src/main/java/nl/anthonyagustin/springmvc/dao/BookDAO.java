package nl.anthonyagustin.springmvc.dao;

import nl.anthonyagustin.springmvc.model.Book;

import java.util.List;

public interface BookDAO {

    public List<Book> getBooks();
    public Book getBookBy(int id);
    public Book getBookBy(String title);
}
