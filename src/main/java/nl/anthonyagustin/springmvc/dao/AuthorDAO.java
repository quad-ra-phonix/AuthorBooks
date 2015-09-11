package nl.anthonyagustin.springmvc.dao;

import nl.anthonyagustin.springmvc.model.Author;

import java.util.List;

public interface AuthorDAO {

    List<Author> getAuthors();
    Author getAuthorBy(int id);
    Author getAuthorBy(String lastName);

    boolean saveAuthor(Author author);
    boolean updateAuthor(Author author);
    boolean deleteAuthor(Author author);
}
