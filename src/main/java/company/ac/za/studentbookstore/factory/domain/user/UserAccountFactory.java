package company.ac.za.studentbookstore.factory.domain.user;

import company.ac.za.studentbookstore.domain.user.UserAccount;
import company.ac.za.studentbookstore.util.CurrentData;
import company.ac.za.studentbookstore.util.PasswordGenerator;

import java.util.Date;

public class UserAccountFactory {
    public static UserAccount getUseraccount(String email){// This will be called to create an account.
        return new UserAccount.Builder(email).buildAccountStatus("start").buildDate(CurrentData.getCurrentTime()).buildPassword(PasswordGenerator.getPasword()).build();
    }
    public static UserAccount getUserAccountUpdate(String email,String password){
        return new UserAccount.Builder(email).buildAccountStatus("update").buildDate(CurrentData.getCurrentTime()).buildPassword(password).build();
    }
    public static UserAccount getUserAccountUpdateStatus(String email,String password,String status){
        return new UserAccount.Builder(email).buildAccountStatus(status).buildDate(CurrentData.getCurrentTime()).buildPassword(password).build();
    }
    public static UserAccount getUserAccountUpdateRole(String email,String password,String status,String roleId){
        return new UserAccount.Builder(email).buildAccountStatus(status).buildDate(CurrentData.getCurrentTime()).buildPassword(password).buildRole(roleId).build();
    }

}
