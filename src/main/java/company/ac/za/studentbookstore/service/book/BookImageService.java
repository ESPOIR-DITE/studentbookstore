package company.ac.za.studentbookstore.service.book;

import company.ac.za.studentbookstore.domain.book.BookImage;
import company.ac.za.studentbookstore.repository.book.BookImageRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookImageService implements IService<BookImage,String> {
    private static BookImageService bookImageService;
    @Autowired
    private BookImageRepository bookImageRepository;
    public static BookImageService getBookImageService(){
        if(bookImageService==null){
            bookImageService=new BookImageService();
        }return bookImageService;
    }

    @Override
    public BookImage create(BookImage bookImage) {
        return bookImageRepository.save(bookImage);
    }

    @Override
    public BookImage delete(BookImage bookImage) {
        if(checkIf(bookImage.getBook_id())!=null){
            bookImageRepository.delete(bookImage);
            return bookImage;
        }
        return null;
    }

    @Override
    public BookImage read(String id) {
        return checkIf(id);
    }

    @Override
    public BookImage update(BookImage bookImage) {
        if(checkIf(bookImage.getBook_id())!=null){
            bookImageRepository.delete(checkIf(bookImage.getBook_id()));
            bookImageRepository.save(bookImage);
            return bookImage;
        }
        return null;
    }

    @Override
    public List<BookImage> readAll() {
        return bookImageRepository.findAll();
    }
    public BookImage checkIf(String id){
        Optional<BookImage>result =bookImageRepository.findById(id);
        return result.orElse(null);
    }
}
