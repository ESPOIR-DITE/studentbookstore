package company.ac.za.studentbookstore.domain.user;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserPost {
    @Id
    private String postId;
    private String email;

    private UserPost() {
    }

    public UserPost(Builder builder) {
        this.email= builder.email;
        this.postId = builder.postId;
    }

    public String getPostId() {
        return postId;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "UserPost{" +
                "postId='" + postId + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
    public static class Builder{
        private String postId;
        private String email;

        public Builder(String postId){
            this.postId = postId;
        }
        public Builder buildEmail(String email){
            this.email = email;
            return this;
        }

        public UserPost build(){
            return new UserPost(this);
        }
    }

}
