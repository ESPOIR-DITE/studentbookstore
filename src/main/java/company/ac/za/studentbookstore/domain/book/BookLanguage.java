package company.ac.za.studentbookstore.domain.book;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookLanguage {
    @Id
    private String bookId;
    private String languageId;

    private BookLanguage() {
    }

    public BookLanguage(Builder builder) {
        this.bookId = builder.bookId;
        this.languageId = builder.languageId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getLanguageId() {
        return languageId;
    }

    @Override
    public String toString() {
        return "BookLanguage{" +
                "bookId='" + bookId + '\'' +
                ", languageId='" + languageId + '\'' +
                '}';
    }
    public static class Builder{
        private String bookId;
        private String languageId;

        public Builder(String bookId){
            this.bookId = bookId;
        }
        public Builder buildLanguage(String languageId){
            this.languageId = languageId;
            return this;
        }
        public BookLanguage build(){
            return new BookLanguage(this);
        }
    }
}
