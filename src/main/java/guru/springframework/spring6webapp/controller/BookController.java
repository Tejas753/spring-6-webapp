package guru.springframework.spring6webapp.controller;

import guru.springframework.spring6webapp.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author : tejas
 * @created : 3/16/23, Thursday
 **/
@Controller
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/books")
    public String getBooks(Model model){

        model.addAttribute("books", bookService.findAll());

        return "books";

    }
}
