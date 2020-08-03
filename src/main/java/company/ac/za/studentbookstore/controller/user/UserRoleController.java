package company.ac.za.studentbookstore.controller.user;

import com.mashape.unirest.http.exceptions.UnirestException;
import company.ac.za.studentbookstore.controller.Icontroller;
import company.ac.za.studentbookstore.domain.user.UserRole;
import company.ac.za.studentbookstore.factory.domain.user.UserRoleFactory;
import company.ac.za.studentbookstore.service.user.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("sts/user_role/")
public class UserRoleController implements Icontroller<UserRole,String> {
    @Autowired
    private UserRoleService userRoleService;

    @PostMapping("create")
    @Override
    public UserRole create(@RequestBody UserRole userRole) throws IOException, UnirestException {
        UserRole userRole1 = UserRoleFactory.getUserRole(userRole.getRole(),userRole.getDescription());
        return userRoleService.create(userRole1);
    }
    @PostMapping("delete")
    @Override
    public UserRole delete(@RequestBody UserRole userRole) {
        return userRoleService.delete(userRole);
    }

    @GetMapping("read")
    @Override
    public UserRole read(@RequestParam("id") String id) {
        return userRoleService.read(id);
    }

    @PostMapping("update")
    @Override
    public UserRole update(@RequestBody UserRole userRole) throws IOException {
        return userRoleService.update(userRole);
    }

    @GetMapping("reads")
    @Override
    public List<UserRole> readAll() {
        return userRoleService.readAll();
    }

//    @GetMapping("readWithEmail")
//    public UserRole readWithEmail(String email){
//        return userRoleService.read()
//    }
}
