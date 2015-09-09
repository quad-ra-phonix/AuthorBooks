package nl.anthonyagustin.springmvc.service;

import nl.anthonyagustin.springmvc.model.Author;

import java.util.List;

public interface AuthorService {

    public List<Author> getAuthors();
    public Author getAuthorBy(int id);
    public Author getAuthorByLastName(String lastName);
}
