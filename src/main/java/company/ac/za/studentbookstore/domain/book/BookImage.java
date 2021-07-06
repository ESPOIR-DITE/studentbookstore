package company.ac.za.studentbookstore.domain.book;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class BookImage {
    @Id
    private String image_id;
    private String book_id;
    private String description;

    private BookImage(){}

    public String getBook_id() {
        return book_id;
    }

//    public void setBook_id(String book_id) {
//        this.book_id = book_id;
//    }

    public String getImage_id() {
        return image_id;
    }

//    public void setImage_id(String image_id) {
//        this.image_id = image_id;
//    }

    public String getDescription() {
        return description;
    }

//    public void setDescription(String description) {
//        this.description = description;
//    }

    public BookImage (Builder builder)
    {
        this.book_id = builder.book_id;
        this.image_id = builder.image_id;
        this.description = builder.description;
    }
    public static class Builder{
        private String book_id;
        private String image_id;
        private String description;

        public Builder BookId(String book_id){
            this.book_id=book_id;
            return this;
        }
        public Builder buildImageId(String image_id){
            this.image_id=image_id;
            return this;
        }
        public Builder buildDescription(String description){
            this.description=description;
            return this;
        }
        public BookImage build(){
//            BookImage bookImage=new BookImage();
//            bookImage.book_id=this.book_id;
//            bookImage.description=this.description;
//            bookImage.image_id=this.image_id;
//            return bookImage;
            return new BookImage(this);
        }
    }

    @Override
    public String toString() {
        return "BookImage{" + "book_id='" + book_id + '\'' + ", " +
                "image_id='" + image_id + '\'' + ", " +
                "description='" + description + '\'' + '}';
    }
}
