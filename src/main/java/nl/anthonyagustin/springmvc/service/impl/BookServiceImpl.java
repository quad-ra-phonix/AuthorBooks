package nl.anthonyagustin.springmvc.service.impl;

import nl.anthonyagustin.springmvc.dao.BookDAO;
import nl.anthonyagustin.springmvc.model.Book;
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
}
