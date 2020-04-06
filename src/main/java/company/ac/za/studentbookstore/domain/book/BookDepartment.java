package company.ac.za.studentbookstore.domain.book;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class BookDepartment {
    @Id
    private String book_Id;
    private String department_Id;
    private String description;

    private BookDepartment(){}

    public String getBook_Id() {
        return book_Id;
    }

    public void setBook_Id(String book_Id) {
        this.book_Id = book_Id;
    }

    public String getDepartment_Id() {
        return department_Id;
    }

    public void setDepartment_Id(String department_Id) {
        this.department_Id = department_Id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "BookDepartment{" +
                "book_Id='" + book_Id + '\'' +
                ", department_Id='" + department_Id + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
    public static class Builder{
        private String book_Id;
        private String department_Id;
        private String description;

        public Builder(String book_Id){
            this.book_Id=book_Id;
        }
        public Builder buildDepartmentId(String department_Id){
            this.department_Id=department_Id;
            return this;
        }
        public Builder builderDescription(String description){
            this.description=description;
            return this;
        }
        public BookDepartment build(){
            BookDepartment bookDepartment=new BookDepartment();
            bookDepartment.book_Id=this.book_Id;
            bookDepartment.department_Id=this.department_Id;
            bookDepartment.description=this.description;
            return bookDepartment;
        }
    }
}
