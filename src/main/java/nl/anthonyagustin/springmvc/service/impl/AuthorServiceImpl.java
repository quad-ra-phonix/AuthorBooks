package nl.anthonyagustin.springmvc.service.impl;

import nl.anthonyagustin.springmvc.dao.AuthorDAO;
import nl.anthonyagustin.springmvc.model.Author;
import nl.anthonyagustin.springmvc.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {

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
}
