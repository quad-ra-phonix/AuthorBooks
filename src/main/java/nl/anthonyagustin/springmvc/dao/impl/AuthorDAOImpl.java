package nl.anthonyagustin.springmvc.dao.impl;

import nl.anthonyagustin.springmvc.dao.AbstractDAO;
import nl.anthonyagustin.springmvc.dao.AuthorDAO;
import nl.anthonyagustin.springmvc.model.Author;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AuthorDAOImpl extends AbstractDAO<Integer, Author> implements AuthorDAO {
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
}
