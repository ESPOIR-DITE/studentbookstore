package company.ac.za.studentbookstore.repository;

import company.ac.za.studentbookstore.domain.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRep extends JpaRepository<Language,String> {
}
