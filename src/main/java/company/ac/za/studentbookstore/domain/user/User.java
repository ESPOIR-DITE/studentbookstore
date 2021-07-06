package company.ac.za.studentbookstore.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    @Id
    private String email;
    private String name;
    private String surname;
    private String phoneNumber;

    private User(){}// default constructor of the company.ac.za.studentbookstore.repository.company.ac.za.studentbookstore.service.company.ac.za.studentbookstore.controller.user class only

    public String getEmail() {
        return email;
    }


    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public User(Builder builder) // i added the builder constructor here
    {
        this.email = builder.email;
        this.name = builder.name;
        this.surname = builder.surname;
        this.phoneNumber = builder.phoneNumber;
    }

    public static class Builder{
        private String email;
        private String name;
        private String surname;
        private String phoneNumber;

        public Builder Email(String email){
            this.email=email;
            return this;
        }
        public Builder buildName(String name){
            this.name=name;
            return this;
        }
        public Builder buildSurname(String surname){
            this.surname=surname;
            return this;
        }
        public Builder buildPhoneNumber(String phoneNumber){
            this.phoneNumber=phoneNumber;
            return this;
        }
        public User build(){
            return new User(this);
        }
    }

    // this is where to string method should be and looks clean instead of inside :)

    @Override
    public String toString() {
        return "User{" + "email='" + email + '\'' + ", " +
                "name='" + name + '\'' + ", surname='" + surname + '\'' + "," +
                " phoneNumber='" + phoneNumber + '\'' + '}';
    }
}
