package spring_boot_tutorial.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring_boot_tutorial.domain.book.Book;
import spring_boot_tutorial.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    BookService bookService;

    @RequestMapping(method = RequestMethod.GET)
    public String index(Model model) {
        List<Book> books = bookService.findAllBook();
        model.addAttribute("books", books);
        return "book-index";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show() {
        // TODO
        return null;
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String new_() {
        // TODO
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String create() {
        // TODO
        return null;
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET)
    public String edit() {
        // TODO
        return null;
    }

    @RequestMapping(method = RequestMethod.PUT)
    public String update() {
        // TODO
        return null;
    }

    @RequestMapping(method = RequestMethod.DELETE)
    public String destroy() {
        // TODO
        return null;
    }

}
