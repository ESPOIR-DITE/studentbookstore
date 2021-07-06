package company.ac.za.studentbookstore.service.book;

import company.ac.za.studentbookstore.domain.book.BookImage;
import company.ac.za.studentbookstore.repository.book.BookImageRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
        BookImage bookImage1=read(bookImage.getImage_id()); //checking if it exists in the database
        if(bookImage1!=null) {
            bookImageRepository.delete(bookImage);
            //System.out.println(bookImage);
            return bookImage1;
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
    public BookImage readWithBookId(String id){
        for(BookImage bookImage:readAll()){
            if(bookImage.getBook_id().equals(id)){
                return bookImage;
            }
        }return null;
    }

    @Override
    public List<BookImage> readAll() {
        return bookImageRepository.findAll();
    }
    public BookImage checkIf(String id){
        Optional<BookImage>result =bookImageRepository.findById(id);
        return result.orElse(null);
    }
    public List<BookImage> readAllOf(String id){
        List<BookImage> bookImages=new ArrayList<>();
        for(BookImage bookImage:readAll()){
            if(bookImage.getBook_id().equals(id)){
                bookImages.add(bookImage);
            }
        }
        return bookImages;
    }
}
