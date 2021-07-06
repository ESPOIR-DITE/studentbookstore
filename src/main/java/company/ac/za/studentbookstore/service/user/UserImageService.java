package company.ac.za.studentbookstore.service.user;

import company.ac.za.studentbookstore.domain.user.UserImage;
import company.ac.za.studentbookstore.repository.user.UserImageRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserImageService implements IService<UserImage,String>
{
    private static UserImageService userImageService;
    @Autowired
    private UserImageRepository userImageRepository;

    public static UserImageService getUserImageService()
    {
        if(userImageService==null)
        {
            userImageService = new UserImageService();
        }
        return userImageService;
    }
    @Override
    public UserImage create(UserImage userImage)
    {
        return userImageRepository.save(userImage);
    }

    @Override
    public UserImage delete(UserImage userImage) {
        Optional<UserImage> result = userImageRepository.findById(userImage.getImage_id());
        if(result.get()!=null)
        {
            userImageRepository.delete(userImage);
            return result.get();
        }
        return null;
    }

    @Override
    public UserImage read(String id)
    {
        Optional<UserImage> result = userImageRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public UserImage update(UserImage userImage)
    {
        UserImage userImage1 = read(userImage.getImage_id());
        if(userImage1==null)
        {
            delete(userImage1);
            return userImageRepository.save(userImage);
        }
        return null;
    }

    @Override
    public List<UserImage> readAll()
    {
        return userImageRepository.findAll();
    }
}
