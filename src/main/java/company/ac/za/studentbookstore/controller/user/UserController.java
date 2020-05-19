package company.ac.za.studentbookstore.controller.user;

import com.mashape.unirest.http.exceptions.UnirestException;
import company.ac.za.studentbookstore.controller.Icontroller;
import company.ac.za.studentbookstore.domain.user.User;
import company.ac.za.studentbookstore.domain.user.UserAccount;
import company.ac.za.studentbookstore.factory.domain.user.UserAccountFactory;
import company.ac.za.studentbookstore.factory.domain.user.UserFactory;
import company.ac.za.studentbookstore.service.user.UserAccountService;
import company.ac.za.studentbookstore.service.user.UserService;
import company.ac.za.studentbookstore.util.MGSample;
import company.ac.za.studentbookstore.util.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sts/user/")
public class UserController implements Icontroller<User,String>
{
    @Autowired
    UserService userService;
    @Autowired
    UserAccountService userAccountService;

    @PostMapping("create")
    @Override
    public User create( @RequestBody User user) throws UnirestException {
        /****
         * we need to create a user account first
         * and send him/her an email with random password
         */
        UserAccount userAccount= UserAccountFactory.getUseraccount(user.getEmail());
        userAccountService.create(userAccount);
        // we are sending an email to the user
        MGSample.sendSimpleMessage(user.getEmail(),001,userAccount.getPassword());
        return userService.create(user);
    }
    @GetMapping("delete")
    @Override
    public User delete(@RequestBody User user) {
        return userService.delete(user);
    }
    @GetMapping("read")
    @Override
    public User read(@RequestParam("id") String id) {
        return userService.read(id);
    }

    @PostMapping("update")
    @Override
    public User update(@RequestBody User user) {
        return userService.update(user);
    }

    @GetMapping("reads")
    @Override
    public List<User> readAll()
    {
        return userService.readAll();
    }
}
