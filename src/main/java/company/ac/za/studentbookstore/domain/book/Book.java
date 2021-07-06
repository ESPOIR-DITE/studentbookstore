package company.ac.za.studentbookstore.domain.book;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Book {
    @Id
    private String id;
    private String title;
    private String language;
    private String edition;
    private double price;
    private String author;

    private Book(){}// default constructor for the company.ac.za.studentbookstore.repository.book class only

    public String getAuthor() {
        return author;
    }

    public String getId() {
        return id;
    }
    public String getTitle() {
        return title;
    }
    public String getLanguage() {
        return language;
    }
    public String getEdition() {
        return edition;
    }
    public double getPrice() {
        return price;
    }

    public Book(Builder builder)// this is the builder constructor
    {
        this.id = builder.id;
        this.title = builder.title;
        this.language = builder.language;
        this.edition = builder.edition;
        this.price = builder.price;
        this.author=builder.author;
    }

    public static class Builder{
        private String id;
        private String title;
        private String language;
        private String edition;
        private double price;
        private String author;

        public Builder Id(String id){
            this.id=id;
            return this;
        }
        public Builder buildTitle(String title){
            this.title=title;
            return this;
        }
        public Builder buildLanguage(String language){
            this.language=language;
            return this;
        }
        public Builder buildedition(String edition){
            this.edition=edition;
            return this;
        }
        public Builder Price(double price){
            this.price=price;
            return this;
        }
        public Builder buildAuthor(String author){
            this.author=author;
            return this;
        }
        public Book build(){
            return new Book(this);
        }
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", language='" + language + '\'' +
                ", edition='" + edition + '\'' +
                ", price=" + price +
                ", author='" + author + '\'' +
                '}';
    }
}
