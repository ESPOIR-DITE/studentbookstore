package company.ac.za.studentbookstore.controller;

import company.ac.za.studentbookstore.domain.Location;
import company.ac.za.studentbookstore.factory.domain.LocationFactory;
import company.ac.za.studentbookstore.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("sts/location/")
public class LocationController implements Icontroller<Location,String>
{
    @Autowired
    LocationService locationService;

    @PostMapping("create")
    @Override
    public Location create(@RequestBody Location location)
    {
        Location location1 = LocationFactory.getLocation(location.getTitle(),location.getLongitude(),location.getLatitude(),location.getDescription());
        System.out.println(location.toString());
        return locationService.create(location1);
    }

    @PostMapping("delete")
    @Override
    public Location delete(@RequestBody Location location)
    {
        //Location location1=LocationFactory.getLocation(location.getTitle(),location.getLongitude(),location.getLatitude(),location.getDescription());
        return locationService.delete(location);
    }

    @GetMapping("read")
    @Override
    public Location read(@RequestParam("id") String id)
    {
        return locationService.read(id);
    }

    @PostMapping("update")
    @Override
    public Location update(@RequestBody Location location)
    {
        return locationService.update(location);
    }

    @GetMapping("reads")
    @Override
    public List<Location> readAll()
    {
        return locationService.readAll();
    }
}
