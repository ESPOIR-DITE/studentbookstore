package company.ac.za.studentbookstore.factory.domain;

import company.ac.za.studentbookstore.domain.Location;
import company.ac.za.studentbookstore.util.MyIdGenerator;
import org.springframework.util.IdGenerator;

public class LocationFactory
{
    public static Location getLocation(String title,String longitude,String latitude,String description)
    {
        return new Location.Builder()
                .Id(MyIdGenerator.getId(LocationFactory.class))
                .Title(title)
                .Longitude(longitude)
                .Latitude(latitude)
                .Description(description)
                .build();
    }
}
