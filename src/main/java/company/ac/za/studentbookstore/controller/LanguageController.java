package company.ac.za.studentbookstore.controller;

import company.ac.za.studentbookstore.domain.Language;
import company.ac.za.studentbookstore.factory.domain.LanguageFactory;
import company.ac.za.studentbookstore.service.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("sts/language/")
public class LanguageController implements Icontroller<Language,String> {
    @Autowired
    LanguageService languageService;
    @PostMapping("create")
    @Override
    public Language create(@RequestBody Language language) {
        Language language1= LanguageFactory.getLanguage(language.getLanguage());
        return languageService.create(language1);
    }

    @PostMapping("delete")
    @Override
    public Language delete(@RequestBody Language language) {
        return languageService.delete(language);
    }

    @GetMapping("read")
    @Override
    public Language read(@RequestParam("id") String id) {
        return languageService.read(id);
    }

    @PostMapping("update")
    @Override
    public Language update(@RequestBody Language language) {
        return languageService.update(language);
    }

    @GetMapping("reads")
    @Override
    public List<Language> readAll() {
        return languageService.readAll();
    }
}
