package company.ac.za.studentbookstore.service.user;

import company.ac.za.studentbookstore.domain.user.UserDepartment;
import company.ac.za.studentbookstore.repository.user.UserDepartmentRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserDepartmentService implements IService<UserDepartment,String>
{
    private static UserDepartmentService userDepartmentService;
    @Autowired
    private UserDepartmentRepository userDepartmentRepository;

    public static UserDepartmentService getUserDepartmentService()
    {
        if(userDepartmentService==null)
        {
            userDepartmentService = new UserDepartmentService();
        }
        return userDepartmentService;
    }

    @Override
    public UserDepartment create(UserDepartment userDepartment)
    {
        return userDepartmentRepository.save(userDepartment);
    }

    @Override
    public UserDepartment delete(UserDepartment userDepartment)
    {
        Optional<UserDepartment> result = userDepartmentRepository.findById(userDepartment.getDepartment_id());
        if(result.get()!=null)
        {
            userDepartmentRepository.delete(userDepartment);
            return result.get();
        }
        return null;
    }

    @Override
    public UserDepartment read(String id)
    {
        Optional<UserDepartment> result = userDepartmentRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public UserDepartment update(UserDepartment userDepartment)
    {
        UserDepartment userDepartment1 = read(userDepartment.getDepartment_id());
        if(userDepartment1==null)
        {
            delete(userDepartment1);
            return userDepartmentRepository.save(userDepartment);
        }
        return null;
    }

    @Override
    public List<UserDepartment> readAll()
    {
        return userDepartmentRepository.findAll();
    }
}
