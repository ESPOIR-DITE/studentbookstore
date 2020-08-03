package company.ac.za.studentbookstore.service.user;

import company.ac.za.studentbookstore.domain.user.UserRole;
import company.ac.za.studentbookstore.repository.user.UserRoleRepo;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserRoleService implements IService<UserRole,String> {
    private static UserRoleService userRoleService;
    @Autowired
    private UserRoleRepo userRoleRepo;

    public static UserRoleService getUserRoleService() {
        if (userRoleService == null) {
            userRoleService= new UserRoleService();
        }
        return userRoleService;
    }

    @Override
    public UserRole create(UserRole userRole) {
        return userRoleRepo.save(userRole);
    }

    @Override
    public UserRole delete(UserRole userRole) {
        UserRole userRole1 = getUserRole(userRole.getId());
        if (userRole1 != null) {
            userRoleRepo.delete(userRole1);
            return userRole;
        }
        return null;
    }

    @Override
    public UserRole read(String id) {
        return getUserRole(id);
    }

    @Override
    public UserRole update(UserRole userRole) {
        UserRole userRole1 = getUserRole(userRole.getId());
        if (userRole1 != null) {
            userRoleRepo.delete(userRole1);
            return create(userRole);
        }
        return null;
    }

    @Override
    public List<UserRole> readAll() {
        return userRoleRepo.findAll();
    }
    public UserRole getUserRole(String id){
        Optional<UserRole> result = userRoleRepo.findById(id);
        return result.orElse(null);
    }
//    public UserRole readWithEmail(String email){
//        for(UserRole userRole: readAll()){
//            if(userRole.)
//        }
//    }
}
