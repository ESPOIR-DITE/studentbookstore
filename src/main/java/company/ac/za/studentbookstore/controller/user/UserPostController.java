package company.ac.za.studentbookstore.controller.user;

import com.mashape.unirest.http.exceptions.UnirestException;
import company.ac.za.studentbookstore.controller.Icontroller;
import company.ac.za.studentbookstore.domain.book.Book;
import company.ac.za.studentbookstore.domain.book.BookPost;
import company.ac.za.studentbookstore.domain.user.UserPost;
import company.ac.za.studentbookstore.service.book.BookPostService;
import company.ac.za.studentbookstore.service.book.BookService;
import company.ac.za.studentbookstore.service.user.UserPostService;
import company.ac.za.studentbookstore.util.MGSample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.*;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("sts/user_post/")
public class UserPostController implements Icontroller<UserPost,String> {
    @Autowired
    private UserPostService userPostService;
    @Autowired
    private BookService bookService;
    @Autowired
    private BookPostService bookPostService;

    @PostMapping("create")
    @Override
    public UserPost create(@RequestBody UserPost userPost) throws UnirestException {
        /***
         * trying to get the necessary contents that we can use to send into an email.
         */
        BookPost bookPost = bookPostService.read(userPost.getPostId());
        if (bookPost!=null){
            Book book = bookService.read(bookPost.getBook_id());
            if(book.getTitle()!=null){
                MGSample.sendSimpleMessage(userPost.getEmail(),002,book.getTitle(),"");
            }
        }
        return userPostService.create(userPost);
    }

    @PostMapping("delete")
    @Override
    public UserPost delete(@RequestBody UserPost userPost) {
        return userPostService.delete(userPost);
    }

    @GetMapping("read")
    @Override
    public UserPost read(@RequestParam("id") String id) {
        return userPostService.read(id);
    }

    @PostMapping("update")
    @Override
    public UserPost update(@RequestBody UserPost userPost) {
        return userPostService.update(userPost);
    }

    @GetMapping("reads")
    @Override
    public List<UserPost> readAll() {
        return userPostService.readAll();
    }
    @GetMapping("readAllOf")
    public List<UserPost> getAllOf(@RequestParam("id") String email){
        return userPostService.getAllOf(email);
    }
}
