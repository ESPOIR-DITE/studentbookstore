package company.ac.za.studentbookstore.service;

import company.ac.za.studentbookstore.domain.Language;
import company.ac.za.studentbookstore.repository.LanguageRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LanguageService implements IService<Language,String> {
    private static LanguageService languageService;

    @Autowired
    private LanguageRep languageRep;

    public static LanguageService getLanguageService(){
        if(languageService==null){
            languageService=new LanguageService();
        }return languageService;
    }

    @Override
    public Language create(Language language) {
        return languageRep.save(language);
    }

    @Override
    public Language delete(Language language) {
        Language language1=read(language.getId());
        if(language1!=null){
            languageRep.delete(language1);
            return language1;
        }
        return null;
    }

    @Override
    public Language read(String id) {
        Optional<Language>result=languageRep.findById(id);
        return result.orElse(null);
    }

    @Override
    public Language update(Language language) {
        Language language1=read(language.getId());
        if(language1!=null){
            languageRep.delete(language1);
            languageRep.save(language);
            return language;
        }
        return null;
    }

    @Override
    public List<Language> readAll() {
        return languageRep.findAll();
    }
}
