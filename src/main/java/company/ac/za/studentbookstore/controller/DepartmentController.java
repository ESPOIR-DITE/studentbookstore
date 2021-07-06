package company.ac.za.studentbookstore.controller;

import company.ac.za.studentbookstore.domain.Department;
import company.ac.za.studentbookstore.factory.domain.DepartmentFactory;
import company.ac.za.studentbookstore.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("sts/department/")
public class DepartmentController implements Icontroller<Department,String>
{
    @Autowired
    DepartmentService departmentService;

    @PostMapping("create")
    @Override
    public Department create(@RequestBody Department department) {
        Department department1 = DepartmentFactory.getDepartment(department.getDepartment_Name(),department.getDescription());
        System.out.println(department.toString());
        return departmentService.create(department1);
    }

    @PostMapping("delete")
    @Override
    public Department delete(@RequestBody Department department)
    {
        return departmentService.delete(department);
    }

    @GetMapping("read")
    @Override
    public Department read(@RequestParam("id") String id)
    {
        return departmentService.read(id);
    }

    @PostMapping("update")
    @Override
    public Department update(@RequestBody Department department)
    {
        return departmentService.update(department);
    }

    @GetMapping("reads")
    @Override
    public List<Department> readAll()
    {
        return departmentService.readAll();
    }
}
