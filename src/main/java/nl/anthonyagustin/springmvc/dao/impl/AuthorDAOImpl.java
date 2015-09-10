package nl.anthonyagustin.springmvc.dao.impl;

import nl.anthonyagustin.springmvc.dao.AbstractDAO;
import nl.anthonyagustin.springmvc.dao.AuthorDAO;
import nl.anthonyagustin.springmvc.model.Author;
import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl extends AbstractDAO<Integer, Author> implements AuthorDAO {

    private static Logger LOG = LoggerFactory.getLogger(AuthorDAOImpl.class);

    @Override
    public List<Author> getAuthors() {
        return this.createEntityCriteria().list();
    }

    @Override
    public Author getAuthorBy(int id) {
        return this.getByKey(id);
    }

    @Override
    public Author getAuthorBy(String lastName) {
        return (Author) this.createEntityCriteria().add(Restrictions.eq("lastName", lastName)).uniqueResult();
    }

    @Override
    public boolean saveAuthor(Author author) {
        try {
            this.getSession().save(author);
            return true;
        } catch(HibernateException e) {
            LOG.error("Something went wrong while saving the author. {}", e);
            return false;
        }
    }

    @Override
    public boolean updateAuthor(Author author) {
        try {
            this.getSession().update(author);
            return true;
        } catch (HibernateException e) {
            LOG.error("Something went wrong while updating the author. {}", e);
            return false;
        }
    }

    @Override
    public boolean deleteAuthor(Author author) {
        try {
            this.getSession().delete(author);
            return true;
        } catch (HibernateException e) {
            LOG.error("Something went wrong while deleting the author. {}", e);
            return false;
        }
    }
}
