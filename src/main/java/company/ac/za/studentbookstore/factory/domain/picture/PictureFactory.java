package company.ac.za.studentbookstore.factory.domain.picture;

import company.ac.za.studentbookstore.domain.picture.Picture;
import company.ac.za.studentbookstore.util.MyIdGenerator;

public class PictureFactory
{
    public static Picture getPicture(byte[] picture,String description) {
        return new Picture.Builder(MyIdGenerator.getId(PictureFactory.class))
                          .buildPicture(picture)
                          .buildDescription(description)
                          .build();
    }
    public static Picture getDecodablePicture(String id, byte[] picture, String description){
        return new Picture.Builder(id).buildDescription(description).buildPicture(picture).build();
    }
}
