package company.ac.za.studentbookstore.service.user;

import company.ac.za.studentbookstore.domain.user.User;
import company.ac.za.studentbookstore.repository.user.UserRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IService<User,String>
{
    private static UserService userService;
    @Autowired
    private UserRepository userRepository;

    public static UserService getUserService()
    {
        if(userService==null)
        {
            userService = new UserService();
        }
        return userService;
    }
    @Override
    public User create(User user)
    {
        return userRepository.save(user);
    }

    @Override
    public User delete(User user)
    {
        Optional<User> result = userRepository.findById(user.getEmail());
        if(result.get()!=null)
        {
            userRepository.delete(user);
            return result.get();
        }
        return null;
    }

    @Override
    public User read(String id) {
        Optional<User> result = userRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public User update(User user) {
        User user1 = read(user.getEmail());
        if(user1!=null) {
            delete(user1);
            return create(user);
        }
        return null;
    }

    @Override
    public List<User> readAll()
    {
        return userRepository.findAll();
    }
}
