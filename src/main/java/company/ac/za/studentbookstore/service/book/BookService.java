package company.ac.za.studentbookstore.service.book;

import company.ac.za.studentbookstore.domain.book.Book;
import company.ac.za.studentbookstore.repository.book.BookRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IService<Book,String> {
    private static BookService bookService;
    @Autowired
    BookRepository bookRepository;
    public static BookService getBookService(){
        if(bookService==null){
            bookService=new BookService();
        }return bookService;
    }
    @Override
    public Book create(Book book) {
        return bookRepository.save(book);
    }
    @Override
    public Book delete(Book book) {
       Book book1 = read(book.getId());
        if (book1!=null){
            bookRepository.delete(book);
            return book;
        }
        return null;
    }
    @Override
    public Book read(String id) {
        Optional<Book> result=bookRepository.findById(id);
        return result.orElse(null);
    }
/**
 * if the book exist then, we delete the existing book and now save the new update
 * **/
    @Override
    public Book update(Book book) {
        Book book1=read(book.getId());
        if(book1!=null){
            delete(book1);
            return bookRepository.save(book);
        }
        return null;
    }
    @Override
    public List<Book> readAll() {
        return bookRepository.findAll();
    }
}
