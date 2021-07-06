package company.ac.za.studentbookstore.service.book;

import company.ac.za.studentbookstore.domain.book.BookLanguage;
import company.ac.za.studentbookstore.repository.book.BookLanguageRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookLanguageService  implements IService<BookLanguage,String> {
    private static BookLanguageService bookLanguageService;

    @Autowired
    private BookLanguageRepository bookLanguageRepository;

    public static BookLanguageService getBookLanguageService(){
        if(bookLanguageService == null){
            bookLanguageService = new BookLanguageService();
        }return bookLanguageService;
    }
    @Override
    public BookLanguage create(BookLanguage bookLanguage) {
        return bookLanguageRepository.save(bookLanguage);
    }

    @Override
    public BookLanguage delete(BookLanguage bookLanguage) {
        BookLanguage bookLanguage1 = getBookLanguage(bookLanguage.getBookId());
        if(bookLanguage1 != null){
            bookLanguageRepository.delete(bookLanguage1);
            return bookLanguage1;
        }
        return null;
    }

    @Override
    public BookLanguage read(String id) {
        return getBookLanguage(id);
    }

    @Override
    public BookLanguage update(BookLanguage bookLanguage) {
        BookLanguage bookLanguage1 = getBookLanguage(bookLanguage.getBookId());

        if(bookLanguage1 != null){
            bookLanguageRepository.delete(bookLanguage1);
            return create(bookLanguage1);
        }
        return null;
    }

    @Override
    public List<BookLanguage> readAll() {
        return bookLanguageRepository.findAll();
    }
    public BookLanguage getBookLanguage(String id){
        Optional<BookLanguage> result = bookLanguageRepository.findById(id);
        return result.orElse(null);
    }
}
