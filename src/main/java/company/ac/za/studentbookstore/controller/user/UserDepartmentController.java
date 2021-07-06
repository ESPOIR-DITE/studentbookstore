package company.ac.za.studentbookstore.controller.user;

import company.ac.za.studentbookstore.controller.Icontroller;
import company.ac.za.studentbookstore.domain.user.UserDepartment;
import company.ac.za.studentbookstore.factory.domain.user.UserDepartmentFactory;
import company.ac.za.studentbookstore.service.user.UserDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sts/user_department/")
public class UserDepartmentController implements Icontroller<UserDepartment,String>
{
    @Autowired
    UserDepartmentService userDepartmentService;

    @PostMapping("create")
    @Override
    public UserDepartment create( @RequestBody UserDepartment userDepartment)
    {
        //UserDepartment user = UserDepartmentFactory.getUserDept(userDepartment.getDepartment_id(),userDepartment.getEmail(),userDepartment.getDescription());
        //System.out.println(user.toString());
        return userDepartmentService.create(userDepartment);
    }

    @GetMapping("delete")
    @Override
    public UserDepartment delete(@RequestBody UserDepartment userDepartment)
    {
        return userDepartmentService.delete(userDepartment);
    }

    @GetMapping("read")
    @Override
    public UserDepartment read(@RequestParam("id") String id)
    {
        return userDepartmentService.read(id);
    }

    @GetMapping("update")
    @Override
    public UserDepartment update(@RequestBody UserDepartment userDepartment)
    {
        return userDepartmentService.update(userDepartment);
    }

    @GetMapping("reads")
    @Override
    public List<UserDepartment> readAll()
    {
        return userDepartmentService.readAll();
    }
}
