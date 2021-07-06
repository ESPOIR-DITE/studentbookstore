package company.ac.za.studentbookstore.repository.user;

import company.ac.za.studentbookstore.domain.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRole,String> {
}
