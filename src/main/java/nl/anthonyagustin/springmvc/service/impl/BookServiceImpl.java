package nl.anthonyagustin.springmvc.service.impl;

import nl.anthonyagustin.springmvc.dao.BookDAO;
import nl.anthonyagustin.springmvc.form.model.BookForm;
import nl.anthonyagustin.springmvc.model.Book;
import nl.anthonyagustin.springmvc.service.AuthorService;
import nl.anthonyagustin.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDAO bookDAO;

    @Autowired
    private AuthorService authorService;

    @Override
    public List<Book> getBooks() {
        return bookDAO.getBooks();
    }

    @Override
    public Book getBookBy(int id) {
        return bookDAO.getBookBy(id);
    }

    @Override
    public Book getBookByName(String title) {
        return bookDAO.getBookBy(title);
    }

    @Override
    public boolean save(BookForm book) {
        Book bookToSave = new Book();
        bookToSave.setGenre(book.getGenre());
        bookToSave.setTitle(book.getTitle());
        bookToSave.setAuthor(authorService.getAuthorBy(book.getAuthorId()));
        return bookDAO.save(bookToSave);
    }

    @Override
    public boolean update(BookForm book) {
        Book bookToUpdate = getBookByName(book.getTitle());
        bookToUpdate.setAuthor(authorService.getAuthorBy(book.getAuthorId()));
        bookToUpdate.setGenre(book.getGenre());
        return bookDAO.update(bookToUpdate);
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
