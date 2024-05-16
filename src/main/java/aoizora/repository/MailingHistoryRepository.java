package aoizora.repository;

import aoizora.domain.MailingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MailingHistoryRepository extends JpaRepository<MailingHistory, Long>
{
}
