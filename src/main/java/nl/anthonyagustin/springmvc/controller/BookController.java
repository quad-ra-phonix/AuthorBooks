package nl.anthonyagustin.springmvc.controller;

import nl.anthonyagustin.springmvc.service.AuthorService;
import nl.anthonyagustin.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public String getBooks(ModelMap model) {
        model.addAttribute("books", bookService.getBooks());
        model.addAttribute("authors", authorService.getAuthors());
        return "books";
    }
}
