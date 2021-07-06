package company.ac.za.studentbookstore.controller.book;

import company.ac.za.studentbookstore.controller.Icontroller;
import company.ac.za.studentbookstore.domain.book.BookImage;
import company.ac.za.studentbookstore.service.book.BookImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sts/bookimage/")
public class BookImageController implements Icontroller<BookImage,String> {
    @Autowired
    BookImageService bookImageService;

    @PostMapping("create")
    @Override
    public BookImage create(@RequestBody BookImage bookImage) {
        //System.out.println(bookImage.toString());
        return bookImageService.create(bookImage);
    }

    @PostMapping("delete")
    @Override
    public BookImage delete(@RequestBody BookImage bookImage) {
        return bookImageService.delete(bookImage);
    }

    @GetMapping("read")
    @Override
    public BookImage read(@RequestParam("id") String id) {
        return bookImageService.read(id);
    }

    @PostMapping("update")
    @Override
    public BookImage update(@RequestBody BookImage bookImage) {
        return bookImageService.update(bookImage);
    }

    @GetMapping("reads")
    @Override
    public List<BookImage> readAll() {
        return bookImageService.readAll();
    }
    @GetMapping("readwithbookId")
    public BookImage readWithBookId(@RequestParam("id") String id) {
        return bookImageService.readWithBookId(id);
    }
    @GetMapping("readAllOf")
    public List<BookImage> readAllOf(@RequestParam("id") String id){
        return bookImageService.readAllOf(id);
    }
}
