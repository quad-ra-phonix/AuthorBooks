package nl.anthonyagustin.springmvc.service;

import nl.anthonyagustin.springmvc.model.Author;

import java.util.List;

public interface AuthorService {

    List<Author> getAuthors();
    Author getAuthorBy(int id);
    Author getAuthorByLastName(String lastName);

    boolean save(Author author);
    boolean update(Author author);
    boolean delete(int id);
}
