package nl.anthonyagustin.springmvc.service;

import nl.anthonyagustin.springmvc.form.model.BookForm;
import nl.anthonyagustin.springmvc.model.Book;

import java.util.List;

public interface BookService {

    List<Book> getBooks();
    Book getBookBy(int id);
    Book getBookByName(String title);

    boolean save(BookForm book);
    boolean update(BookForm book);
    boolean delete(int id);
}
