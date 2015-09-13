package nl.anthonyagustin.springmvc.service.impl;

import nl.anthonyagustin.springmvc.dao.AuthorDAO;
import nl.anthonyagustin.springmvc.form.model.AuthorForm;
import nl.anthonyagustin.springmvc.model.Author;
import nl.anthonyagustin.springmvc.service.AuthorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

    private static Logger LOG = LoggerFactory.getLogger(AuthorServiceImpl.class);

    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public List<Author> getAuthors() {
        return authorDAO.getAuthors();
    }

    @Override
    public Author getAuthorBy(int id) {
        return authorDAO.getAuthorBy(id);
    }

    @Override
    public Author getAuthorByLastName(String lastName) {
        return authorDAO.getAuthorBy(lastName);
    }

    @Override
    public boolean save(AuthorForm author) {
        Author authorToSave = new Author();
        authorToSave.setFirstName(author.getFirstName());
        authorToSave.setLastName(author.getLastName());
        authorToSave.setDateOfBirth(handleDate(author.getDateOfBirth()));
        return authorDAO.saveAuthor(authorToSave);
    }

    @Override
    public boolean update(AuthorForm author) {
        Author authorToUpdate = getAuthorByLastName(author.getLastName());
        authorToUpdate.setDateOfBirth(handleDate(author.getDateOfBirth()));
        authorToUpdate.setFirstName(author.getFirstName());
        return authorDAO.updateAuthor(authorToUpdate);
    }

    @Override
    public boolean delete(int id) {
        Author author = getAuthorBy(id);
        return authorDAO.deleteAuthor(author);
    }

    private Date handleDate(String dateString) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date date = null;
        try {
            date = formatter.parse(dateString);
        } catch (ParseException e) {
            LOG.error("ParseException has occurred. {}", e);
        }
        return date;
    }
}
