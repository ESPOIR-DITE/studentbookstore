package company.ac.za.studentbookstore.controller.book;

import company.ac.za.studentbookstore.controller.Icontroller;
import company.ac.za.studentbookstore.domain.book.BookPost;
import company.ac.za.studentbookstore.factory.domain.book.BookPostFactory;
import company.ac.za.studentbookstore.service.book.BookPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("sts/bookpost/")
public class BookPostController implements Icontroller<BookPost,String> {
    @Autowired
    private BookPostService bookPostService;
    @PostMapping("create")
    @Override
    public BookPost create(@RequestBody BookPost bookPost) {
        BookPost bookPost1= BookPostFactory.getPostedBook(bookPost.getEmail(),bookPost.getBook_id(),bookPost.getDate(),bookPost.getLocationId(),bookPost.getStatus(),bookPost.getDescription());
        return bookPostService.create(bookPost1);
    }

    @PostMapping("delete")
    @Override
    public BookPost delete(@RequestBody BookPost bookPost) {
        System.out.println(bookPost);
        return bookPostService.delete(bookPost);
    }
@GetMapping("read")
    @Override
    public BookPost read(@RequestParam("id") String id) {
        return bookPostService.read(id);
    }
@PostMapping("update")
    @Override
    public BookPost update(@RequestBody BookPost bookPost) {
        return bookPostService.update(bookPost);
    }

    @GetMapping("reads")
    @Override
    public List<BookPost> readAll() {
        return bookPostService.readAll();
    }
    @GetMapping("readWithbookId")
    public BookPost readwithBookId(@RequestParam("id") String id){
        return bookPostService.readwithBookId(id);
    }
}
