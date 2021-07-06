package company.ac.za.studentbookstore.service.user;

import company.ac.za.studentbookstore.domain.user.UserAccount;
import company.ac.za.studentbookstore.repository.user.UserAccountRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserAccountService implements IService<UserAccount,String> {
    private static UserAccountService userAccountService;
    @Autowired
    private UserAccountRepository userAccountRepository;
    public static UserAccountService getUserAccountService(){
        if(userAccountService==null){
            userAccountService=new UserAccountService();
        }return userAccountService;
    }

    @Override
    public UserAccount create(UserAccount userAccount) {
        return userAccountRepository.save(userAccount);
    }

    @Override
    public UserAccount delete(UserAccount userAccount) {
        UserAccount userAccount1=read(userAccount.getEmail());
        if(userAccount1!=null){
            userAccountRepository.delete(userAccount1);
            return userAccount1;
        }
        return null;
    }

    @Override
    public UserAccount read(String id) {
        Optional<UserAccount> result=userAccountRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public UserAccount update(UserAccount userAccount) {
        UserAccount userAccount1=read(userAccount.getEmail());
        if(userAccount1!=null){
            userAccountRepository.delete(userAccount1);
            return create(userAccount);
        }
        return null;
    }

    @Override
    public List<UserAccount> readAll() {
        return userAccountRepository.findAll();
    }
    public UserAccount readWithCode(String code){
        for(UserAccount userAccount: readAll()){
            if(userAccount.getPassword().equals(code)){
                return userAccount;
            }
        }
        return null;
    }

    public UserAccount logIn(String email,String password){
       // List<UserAccount> allUsers=userAccountRepository.
        for (UserAccount userAccount:userAccountRepository.findAll()){
            if(userAccount.getEmail().equals(email) || userAccount.getPassword().equals(password)){
                return userAccount;
            }
        }
        return null;
    }

    public UserAccount readWithEmail(String email){
        for(UserAccount userAccount: readAll()){
            if(userAccount.getEmail().equals(email)){
                return userAccount;
            }
        }
        return null;
    }
}
