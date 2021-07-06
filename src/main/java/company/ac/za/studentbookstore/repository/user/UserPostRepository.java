package company.ac.za.studentbookstore.repository.user;

import company.ac.za.studentbookstore.domain.user.UserPost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPostRepository extends JpaRepository<UserPost,String> {
}
