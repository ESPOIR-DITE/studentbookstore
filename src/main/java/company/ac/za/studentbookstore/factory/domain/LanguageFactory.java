package company.ac.za.studentbookstore.factory.domain;

import company.ac.za.studentbookstore.domain.Language;
import company.ac.za.studentbookstore.util.MyIdGenerator;

public class LanguageFactory {
    public static Language getLanguage(String language){
        return new Language.Builder().buildId(MyIdGenerator.getId(LocationFactory.class)).buildLanguage(language).build();
    }
}
