package company.ac.za.studentbookstore.controller.book;

import company.ac.za.studentbookstore.controller.Icontroller;
import company.ac.za.studentbookstore.domain.book.BookLanguage;
import company.ac.za.studentbookstore.service.book.BookLanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("sts/book_language/")
public class BookLanguageController implements Icontroller<BookLanguage,String> {
    @Autowired
    private BookLanguageService bookLanguageService;

    @PostMapping("create")
    @Override
    public BookLanguage create(@RequestBody BookLanguage bookLanguage){
        return bookLanguageService.create(bookLanguage);
    }

    @PostMapping("delete")
    @Override
    public BookLanguage delete(@RequestBody BookLanguage bookLanguage) {
        return bookLanguageService.delete(bookLanguage);
    }

    @GetMapping("read")
    @Override
    public BookLanguage read(@RequestParam("id") String id) {
        return bookLanguageService.read(id);
    }

    @PostMapping("update")
    @Override
    public BookLanguage update(@RequestBody BookLanguage bookLanguage){
        return bookLanguageService.update(bookLanguage);
    }

    @GetMapping("reads")
    @Override
    public List<BookLanguage> readAll() {
        return bookLanguageService.readAll();
    }
}
