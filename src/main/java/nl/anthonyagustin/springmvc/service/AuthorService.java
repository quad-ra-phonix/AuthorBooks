package nl.anthonyagustin.springmvc.service;

import nl.anthonyagustin.springmvc.form.model.AuthorForm;
import nl.anthonyagustin.springmvc.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAuthors();
    Author getAuthorBy(int id);
    Author getAuthorByLastName(String lastName);

    boolean save(AuthorForm author);
    boolean update(AuthorForm author);
    boolean delete(int id);
}
