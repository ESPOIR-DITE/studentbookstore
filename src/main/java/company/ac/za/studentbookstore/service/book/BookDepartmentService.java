package company.ac.za.studentbookstore.service.book;

import company.ac.za.studentbookstore.domain.book.BookDepartment;
import company.ac.za.studentbookstore.repository.book.BookDepartmentRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookDepartmentService implements IService<BookDepartment, String> {
    private static BookDepartmentService bookDepartmentService;
    @Autowired
    private BookDepartmentRepository bookDepartmentRepository;

    public static BookDepartmentService getBookDepartmentService(){
        if (bookDepartmentService==null){
            bookDepartmentService=new BookDepartmentService();
        }return bookDepartmentService;
    }
    @Override
    public BookDepartment create(BookDepartment bookDepartment) {
        return bookDepartmentRepository.save(bookDepartment);
    }

    @Override
    public BookDepartment delete(BookDepartment bookDepartment) {
       BookDepartment bookDepartment1=read(bookDepartment.getBook_Id());
        if(bookDepartment1!=null){
            bookDepartmentRepository.delete(bookDepartment);
            return bookDepartment;
        }
        return null;
    }

    @Override
    public BookDepartment read(String id) {
        Optional<BookDepartment> result=bookDepartmentRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public BookDepartment update(BookDepartment bookDepartment) {
        Optional<BookDepartment> result=bookDepartmentRepository.findById(bookDepartment.getBook_Id());
        if(result.get()!=null){
            bookDepartmentRepository.delete(result.get());
            bookDepartmentRepository.save(bookDepartment);
            return bookDepartment;
        }
        return null;
    }
    public List<BookDepartment> readAllOf(String id){
        List<BookDepartment> bookDepartments = new ArrayList<>();
        for(BookDepartment bookDepartment: readAll()){
            if(bookDepartment.getDepartment_Id().equals(id)){
                bookDepartments.add(bookDepartment);
            }
        }
        return bookDepartments;
    }

    @Override
    public List<BookDepartment> readAll() {
        return bookDepartmentRepository.findAll();
    }
}
