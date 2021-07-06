package company.ac.za.studentbookstore.factory.domain.user;

import company.ac.za.studentbookstore.domain.user.UserRole;
import company.ac.za.studentbookstore.util.MyIdGenerator;

public class UserRoleFactory {
    public static UserRole getUserRole(String role,String decription){
        return new UserRole.Builder(MyIdGenerator.getId(UserRoleFactory.class))
                .buildDecription(decription)
                .buildRole(role)
                .build();
    }
}
