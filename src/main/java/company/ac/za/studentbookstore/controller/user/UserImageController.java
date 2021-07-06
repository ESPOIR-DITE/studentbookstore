package company.ac.za.studentbookstore.controller.user;

import company.ac.za.studentbookstore.controller.Icontroller;
import company.ac.za.studentbookstore.domain.user.UserImage;
import company.ac.za.studentbookstore.factory.domain.user.UserImageFactory;
import company.ac.za.studentbookstore.service.user.UserImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/userImage/")
public class UserImageController implements Icontroller<UserImage,String>
{
    @Autowired
    UserImageService userImageService;

    @PostMapping("create")
    @Override
    public UserImage create(@RequestBody UserImage userImage)
    {
        //UserImage userImage1 = UserImageFactory.getUserImage(userImage.getImage_id(),userImage.getEmail(),userImage.getDescription(),userImage.getDate());
        //System.out.println(userImage.toString());
        return userImageService.create(userImage);
    }

    @GetMapping("delete")
    @Override
    public UserImage delete(@RequestBody UserImage userImage)
    {
        return userImageService.delete(userImage);
    }

    @GetMapping("read")
    @Override
    public UserImage read(@RequestParam("id") String id)
    {
        return userImageService.read(id);
    }

    @GetMapping("update")
    @Override
    public UserImage update(@RequestBody UserImage userImage)
    {
        return userImageService.update(userImage);
    }

    @GetMapping("reads")
    @Override
    public List<UserImage> readAll()
    {
        return userImageService.readAll();
    }
}
