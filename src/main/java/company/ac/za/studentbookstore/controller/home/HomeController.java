package company.ac.za.studentbookstore.controller.home;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.nio.file.Paths;

@RestController
public class HomeController {
    @GetMapping("")
    public String domain(){
        System.out.println(Paths.get("").toAbsolutePath().toString());
        System.out.println(Paths.get("").toAbsolutePath().toString());
        return "Book Store Api \n"+Paths.get("").toAbsolutePath().toString();

    }
    @GetMapping("/sts")
    public String home(){
        return "Welcome Home of Student Book Store";
    }
}
