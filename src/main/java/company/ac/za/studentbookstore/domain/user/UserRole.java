package company.ac.za.studentbookstore.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserRole {
    @Id
    private String id;
    private String role;
    private String description;

    private UserRole() {
    }

    public UserRole(Builder builder) {
        this.id = builder.id;
        this.description = builder.description;
        this.role = builder.role;
    }

    public String getId() {
        return id;
    }

    public String getRole() {
        return role;
    }

    public String getDescription() {
        return description;
    }
    public static class Builder{
        private String id;
        private String role;
        private String description;

        public Builder(String id){
            this.id = id;
        }

        public Builder buildRole(String role){
            this.role = role;
            return this;
        }
        public Builder buildDecription(String description){
            this.description = description;
            return this;
        }
        public UserRole build(){
            return new UserRole(this);
        }
    }
}
