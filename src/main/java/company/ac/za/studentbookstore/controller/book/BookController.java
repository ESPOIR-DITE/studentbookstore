package company.ac.za.studentbookstore.controller.book;

import company.ac.za.studentbookstore.controller.Icontroller;
import company.ac.za.studentbookstore.domain.book.Book;
import company.ac.za.studentbookstore.service.book.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import company.ac.za.studentbookstore.factory.domain.book.*;

import javax.swing.*;
import java.util.List;

@RestController
@RequestMapping("sts/book/")
public class BookController implements Icontroller<Book,String> {
    @Autowired
    BookService bookService;

    @PostMapping("create")
    @Override
    public Book create(@RequestBody Book book) {
        Book book1=BookFactory.getBook(book.getTitle(),book.getLanguage(),book.getEdition(),book.getPrice(),book.getAuthor());
        //System.out.println(book1.toString());
        return bookService.create(book1);
    }

    @PostMapping("delete")
    @Override
    public Book delete(@RequestBody Book book) {
        //System.out.println(book+" the book");
        return bookService.delete(book);
    }

    @GetMapping("read")
    @Override
    public Book read(@RequestParam("id")  String id) {
        return bookService.read(id);
    }

    @PostMapping("update")
    @Override
    public Book update(@RequestBody Book book) {
        return bookService.update(book);
    }

    @GetMapping("reads")
    @Override
    public List<Book> readAll() {
        return bookService.readAll();
    }
}
