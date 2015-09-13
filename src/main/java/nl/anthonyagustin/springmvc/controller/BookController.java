package nl.anthonyagustin.springmvc.controller;

import nl.anthonyagustin.springmvc.form.model.BookForm;
import nl.anthonyagustin.springmvc.model.Author;
import nl.anthonyagustin.springmvc.model.Book;
import nl.anthonyagustin.springmvc.service.AuthorService;
import nl.anthonyagustin.springmvc.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    @RequestMapping(value = "/book/add", method = RequestMethod.GET)
    public String getAddBook(ModelMap model) {
        BookForm book = new BookForm();
        model.addAttribute("book", book);
        model.addAttribute("parameter", "add");
        model.addAttribute("authors", authorService.getAuthors());
        return "addBook";
    }

    @RequestMapping(value = "/book/add", method = RequestMethod.POST)
    public String postAddBook(@ModelAttribute("book") BookForm book, BindingResult result) {
        bookService.save(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/book/update/{bookId}", method = RequestMethod.GET)
    public String getUpdateBook(@PathVariable Integer bookId, ModelMap model) {
        Book book = bookService.getBookBy(bookId);
        BookForm bookForm = new BookForm();
        bookForm.setGenre(book.getGenre());
        bookForm.setTitle(book.getTitle());
        bookForm.setAuthorId(book.getAuthor().getId());
        model.addAttribute("book", bookForm);
        model.addAttribute("parameter", "update");
        model.addAttribute("authors", authorService.getAuthors());
        return "addBook";
    }

    @RequestMapping(value = "/book/update", method = RequestMethod.POST)
    public String postUpdateBook(@ModelAttribute("book") BookForm book, BindingResult reesult) {
        bookService.update(book);
        return "redirect:/books";
    }

    @RequestMapping(value = "/book/delete/{bookId}", method = RequestMethod.POST)
    public String postDeleteBook(@PathVariable Integer bookId) {
        bookService.delete(bookId);
        return "redirect:/books";
    }
}
