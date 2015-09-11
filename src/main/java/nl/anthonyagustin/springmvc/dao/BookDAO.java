package nl.anthonyagustin.springmvc.dao;

import nl.anthonyagustin.springmvc.model.Book;

import java.util.List;

public interface BookDAO {

    List<Book> getBooks();
    Book getBookBy(int id);
    Book getBookBy(String title);

    boolean save(Book book);
    boolean update(Book book);
    boolean delete(Book book);
}
