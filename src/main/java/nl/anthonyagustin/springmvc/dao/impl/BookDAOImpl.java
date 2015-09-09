package nl.anthonyagustin.springmvc.dao.impl;

import nl.anthonyagustin.springmvc.dao.AbstractDAO;
import nl.anthonyagustin.springmvc.dao.BookDAO;
import nl.anthonyagustin.springmvc.model.Book;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl extends AbstractDAO<Integer, Book> implements BookDAO {

    @Override
    public List<Book> getBooks() {
        return this.createEntityCriteria().list();
    }

    @Override
    public Book getBookBy(int id) {
        return this.getByKey(id);
    }

    @Override
    public Book getBookBy(String title) {
        return (Book) this.createEntityCriteria().add(Restrictions.eq("title", title)).uniqueResult();
    }
}
