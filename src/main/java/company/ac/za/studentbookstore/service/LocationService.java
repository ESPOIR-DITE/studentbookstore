package company.ac.za.studentbookstore.service;

import company.ac.za.studentbookstore.domain.Location;
import company.ac.za.studentbookstore.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService implements IService<Location,String>
{
    private static LocationService locationService;

    @Autowired
    private LocationRepository locationRepository;

    public static LocationService getLocationService()
    {
        if(locationService==null)
        {
            locationService = new LocationService();
        }
        return locationService;
    }

    @Override
    public Location create(Location location)
    {
        return locationRepository.save(location);
    }

    @Override
    public Location delete(Location location)
    {
        Optional<Location> result = locationRepository.findById(location.getId());
        if (result.get()!=null){
            locationRepository.delete(location);
            return result.get();
        }
        return null;
    }

    @Override
    public Location read(String id)
    {
        Optional<Location> result = locationRepository.findById(id);
        return result.orElse(null);
    }

    @Override
    public Location update(Location location)
    {
        Location location1 = read(location.getId());
        if(location1!=null)
        {
            locationRepository.delete(location1);
            return locationRepository.save(location);
        }
        return null;
    }

    @Override
    public List<Location> readAll()
    {
        return locationRepository.findAll();
    }
}
