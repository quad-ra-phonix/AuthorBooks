package nl.anthonyagustin.springmvc.dao.impl;

import nl.anthonyagustin.springmvc.dao.AbstractDAO;
import nl.anthonyagustin.springmvc.dao.BookDAO;
import nl.anthonyagustin.springmvc.model.Book;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookDAOImpl extends AbstractDAO<Integer, Book> implements BookDAO {

    private static Logger LOG = LoggerFactory.getLogger(BookDAOImpl.class);

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

    @Override
    public boolean save(Book book) {
        try {
            this.getSession().save(book);
            return true;
        } catch (HibernateException e) {
            LOG.error("Something went wrong while saving the book. {}", e);
            return false;
        }

    }

    @Override
    public boolean update(Book book) {
        try {
            this.getSession().update(book);
            return true;
        } catch (HibernateException e) {
            LOG.error("Something went wrong while updating the book. {}", e);
            return false;
        }
    }

    @Override
    public boolean delete(Book book) {
        try {
            this.getSession().delete(book);
            return true;
        } catch (HibernateException e) {
            LOG.error("Something went wrong while deleting the book. {}", e);
            return false;
        }
    }
}
