package company.ac.za.studentbookstore.factory.domain.user;

import company.ac.za.studentbookstore.domain.user.UserPost;
import company.ac.za.studentbookstore.util.MyIdGenerator;
import org.springframework.util.IdGenerator;

public class UserPostFactory {
    public static UserPost getUserPost(String postId, String email){
        return new UserPost.Builder(postId)
                .buildEmail(email).build();
    }
}
