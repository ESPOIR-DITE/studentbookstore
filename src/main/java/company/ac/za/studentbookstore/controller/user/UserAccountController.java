package company.ac.za.studentbookstore.controller.user;

import company.ac.za.studentbookstore.domain.user.User;
import company.ac.za.studentbookstore.domain.user.UserAccount;
import company.ac.za.studentbookstore.service.user.UserAccountService;
import company.ac.za.studentbookstore.util.MyAppLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sts/user_account/")
public class UserAccountController {
    @Autowired
    UserAccountService userAccountService;
    @PostMapping("login")
    public UserAccount LogIn(@RequestBody UserAccount userAccount){
       // System.out.println(userAccount.toString());
        UserAccount userAccount1=userAccountService.logIn(userAccount.getEmail(),userAccount.getPassword());
       // System.out.println(userAccount1.toString());
        if (userAccount1!=null) {
            MyAppLog.sMessage("LogIn");
            return userAccount1;
        }
        MyAppLog.fMessage("LogIn");
        return null;
    }
    @GetMapping("readAll")
    public List<UserAccount> getAll(){
        //System.out.println("we are in");
        return userAccountService.readAll();
    }
    @GetMapping("readwithcode")
    public UserAccount readwithcode(@RequestParam("id") String id){
        return userAccountService.readWithCode(id);
    }

    @GetMapping("readwithemail")
    public UserAccount readWithEmail(@RequestParam("id") String id){
        return userAccountService.readWithEmail(id);
    }

    @PostMapping("update")
    public UserAccount update(@RequestBody UserAccount userAccount){
        return userAccountService.update(userAccount);
    }
}
