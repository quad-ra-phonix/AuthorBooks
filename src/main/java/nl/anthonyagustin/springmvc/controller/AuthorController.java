package nl.anthonyagustin.springmvc.controller;

import nl.anthonyagustin.springmvc.form.model.AuthorForm;
import nl.anthonyagustin.springmvc.model.Author;
import nl.anthonyagustin.springmvc.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by agustinas on 10-9-2015.
 */

@Controller
public class AuthorController {

    @Autowired
    private AuthorService authorService;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public String getAuthors(ModelMap model) {
        List<Author> authors = authorService.getAuthors();
        model.addAttribute("authors", authors);
        return "authors";
    }

    @RequestMapping(value = "/author/add", method = RequestMethod.GET)
    public String getAddAuthor(ModelMap model) {
        AuthorForm author = new AuthorForm();
        model.addAttribute("author", author);
        model.addAttribute("parameter", "add");
        return "addAuthor";
    }

    @RequestMapping(value = "/author/add", method = RequestMethod.POST)
    public String postAddAuthor(@ModelAttribute("author") AuthorForm author, BindingResult result) {
        authorService.save(author);
        return "redirect:/authors";
    }

    @RequestMapping(value = "/author/update/{authorId}", method = RequestMethod.GET)
    public String getUpdateAuthor(@PathVariable Integer authorId, ModelMap model) {
        Author author = authorService.getAuthorBy(authorId);
        model.addAttribute("author", author);
        model.addAttribute("parameter", "update");
        return "addAuthor";
    }

    @RequestMapping(value = "/author/update", method = RequestMethod.POST)
    public String postUpdateAuthor(@ModelAttribute("author") AuthorForm author, BindingResult result) {
        authorService.update(author);
        return "redirect:/authors";
    }

    @RequestMapping(value = "/author/delete/{authorId}", method = RequestMethod.POST)
    public String postDeleteAuthor(@PathVariable Integer authorId) {
        authorService.delete(authorId);
        return "redirect:/authors";
    }




}
