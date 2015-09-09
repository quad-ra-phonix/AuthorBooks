package nl.anthonyagustin.springmvc.dao;

import nl.anthonyagustin.springmvc.model.Author;

import java.util.List;

public interface AuthorDAO {

    public List<Author> getAuthors();
    public Author getAuthorBy(int id);
    public Author getAuthorBy(String lastName);
}
