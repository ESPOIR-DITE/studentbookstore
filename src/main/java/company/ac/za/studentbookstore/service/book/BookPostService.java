package company.ac.za.studentbookstore.service.book;

import company.ac.za.studentbookstore.domain.book.BookPost;
import company.ac.za.studentbookstore.repository.book.BookPostRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookPostService implements IService<BookPost,String> {
    private static BookPostService bookPostService;
    @Autowired
    private BookPostRepository bookPostRepository;
    public static BookPostService getBookPostService(){
        if(bookPostService==null){
            bookPostService=new BookPostService();
        }return bookPostService;
    }
    @Override
    public BookPost create(BookPost bookPost) {
        return bookPostRepository.save(bookPost);
    }

    @Override
    public BookPost delete(BookPost bookPost) {
        if(getBookPost(bookPost.getId())!=null){
            bookPostRepository.delete(bookPost);
            return bookPost;
        }
        return null;
    }

    @Override
    public BookPost read(String id) {
        return getBookPost(id);
    }

    @Override
    public BookPost update(BookPost bookPost) {
        if(getBookPost(bookPost.getId())!=null){
            bookPostRepository.delete(getBookPost(bookPost.getId()));
            bookPostRepository.save(bookPost);
            return bookPost;
        }
        return null;
    }

    @Override
    public List<BookPost> readAll() {
        return bookPostRepository.findAll();
    }
    public BookPost getBookPost(String id){
        Optional<BookPost> result=bookPostRepository.findById(id);
        return result.orElse(null);
    }
    public BookPost readwithBookId(String id){
        for(BookPost bookPost:readAll()){
            if(bookPost.getBook_id().equals(id)){
                return bookPost;
            }
        }return null;
    }
}
