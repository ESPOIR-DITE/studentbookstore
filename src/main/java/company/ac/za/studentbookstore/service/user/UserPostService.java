package company.ac.za.studentbookstore.service.user;

import company.ac.za.studentbookstore.domain.user.User;
import company.ac.za.studentbookstore.domain.user.UserPost;
import company.ac.za.studentbookstore.repository.user.UserPostRepository;
import company.ac.za.studentbookstore.service.IService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserPostService implements IService<UserPost,String> {
    @Autowired
    private UserPostRepository userPostRepository;

    private static UserPostService userPostService;

    public static UserPostService getUserPostService(){
        if(userPostService ==null){
            userPostService = new UserPostService();
        }return userPostService;
    }
    @Override
    public UserPost create(UserPost userPost) {
        return userPostRepository.save(userPost);
    }

    @Override
    public UserPost delete(UserPost userPost) {
        UserPost userPost1 = getUserPost(userPost.getPostId());
        if(userPost1 != null){
            userPostRepository.delete(userPost1);
            return userPost1;
        }
        return null;
    }

    @Override
    public UserPost read(String id) {
        return getUserPost(id);
    }

    @Override
    public UserPost update(UserPost userPost) {
        UserPost userPost1 = getUserPost(userPost.getPostId());
        if(userPost1 != null){
            userPostRepository.delete(userPost1);
            return create(userPost);
        }
        return null;
    }

    @Override
    public List<UserPost> readAll() {
        return userPostRepository.findAll();
    }
    public UserPost getUserPost(String id){
        Optional<UserPost> result = userPostRepository.findById(id);
        return result.orElse(null);
    }

    public List<UserPost> getAllOf(String id){
        List<UserPost> userPosts = new ArrayList<>();
        for (UserPost userPost: userPostRepository.findAll()){
            if(userPost.getEmail().equals(id)){
                userPosts.add(userPost);
            }
        }
        return userPosts;
    }
}
