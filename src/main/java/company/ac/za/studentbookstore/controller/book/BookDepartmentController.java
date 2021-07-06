package company.ac.za.studentbookstore.controller.book;
import company.ac.za.studentbookstore.controller.Icontroller;
import company.ac.za.studentbookstore.domain.book.BookDepartment;
import company.ac.za.studentbookstore.service.book.BookDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import company.ac.za.studentbookstore.factory.domain.book.*;

import java.util.List;

@RestController
@RequestMapping("sts/bookdepartment")
public class BookDepartmentController implements Icontroller<BookDepartment,String> {
    @Autowired
    BookDepartmentService bookDepartmentService;

    @PostMapping("/create")
    @Override
    public BookDepartment create(@RequestBody BookDepartment bookDepartment) {
       // BookDepartment bookDepartment1=BookDepartmentFactory.getBookByDepartment(bookDepartment.getBook_Id(),bookDepartment.getDepartment_Id(),bookDepartment.getDescription());
        return bookDepartmentService.create(bookDepartment);
    }

    @PostMapping("/delete")
    @Override
    public BookDepartment delete(@RequestBody BookDepartment bookDepartment) {
        return bookDepartmentService.delete(bookDepartment);
    }

    @GetMapping("/read")
    @Override
    public BookDepartment read(@RequestParam("id") String id) {
        return bookDepartmentService.read(id);
    }

    @PostMapping("/update")
    @Override
    public BookDepartment update(@RequestBody BookDepartment bookDepartment) {
        return bookDepartmentService.update(bookDepartment);
    }

    @GetMapping("/reads")
    @Override
    public List<BookDepartment> readAll() {
        return bookDepartmentService.readAll();
    }
    @GetMapping("readAllOf")
    public List<BookDepartment> reafAllOf(@RequestParam("id") String departmentId){
        return bookDepartmentService.readAllOf(departmentId);
    }

}
