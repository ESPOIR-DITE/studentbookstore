package company.ac.za.studentbookstore.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Language {
    @Id
    private String id;
    private String language;

    private Language() {
    }

    public Language(Builder builder) {
        this.id=builder.id;
        this.language=builder.language;
    }

    public String getId() {
        return id;
    }

    public String getLanguage() {
        return language;
    }

    @Override
    public String toString() {
        return "Language{" +
                "id='" + id + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
    public static class Builder{
        private String id;
        private String language;
        public Builder buildId(String id){
            this.id=id;
            return this;
        }
        public Builder buildLanguage(String language){
            this.language=language;
            return this;
        }
        public Language build(){
            return new Language(this);
        }
    }
}
