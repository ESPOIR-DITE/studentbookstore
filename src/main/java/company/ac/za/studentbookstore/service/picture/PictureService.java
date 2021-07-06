package company.ac.za.studentbookstore.service.picture;

import company.ac.za.studentbookstore.domain.picture.Picture;
import company.ac.za.studentbookstore.repository.picture.PictureRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PictureService implements IService<Picture,String>
{
    private static PictureService pictureService;
    @Autowired
    private PictureRepository pictureRepository;
    public static PictureService getPictureService()
    {
        if(pictureService==null)
        {
            pictureService=new PictureService();
        }
        return pictureService;
    }

    @Override
    public Picture create(Picture picture)
    {
        return pictureRepository.save(picture);
    }

    @Override
    public Picture delete(Picture picture) {
        Picture result = getpicture(picture.getId());
        if (result!=null){
            pictureRepository.delete(result);
            return result;
        }
       return null;
    }

    @Override
    public Picture read(String id) {
        return getpicture(id);
    }

    /**
     * if the company.ac.za.studentbookstore.controller.picture exist then, we delete the existing company.ac.za.studentbookstore.controller.picture and now save the new update
     * **/
    @Override
    public Picture update(Picture picture) {
        Picture picture1 = read(picture.getId());
        if(picture1!=null) {
            delete(picture1);
            return pictureRepository.save(picture);
        }
        return null;
    }

    @Override
    public List<Picture> readAll() {
        return pictureRepository.findAll();
    }

    public Picture getFirstpicture(String id){
        for(Picture picture:readAll()){
            if(picture.getId().equals(id)){
                return picture;
            }
        }return null;
    }
    public List<Picture> readAllOf(List<String> ids){
        List <Picture> pictures = new ArrayList<>();
        for(String id:ids){
            pictures.add(read(id));
        }return pictures;
    }
    public Picture getpicture(String id){
        Optional<Picture> result = pictureRepository.findById(id);
        return result.orElse(null);
    }
}
