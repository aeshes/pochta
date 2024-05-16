package aoizora.service;

import aoizora.domain.MailingHistory;
import aoizora.repository.MailingHistoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HistoryService
{
    private final MailingHistoryRepository mailingHistoryRepository;

    public HistoryService(MailingHistoryRepository mailingHistoryRepository)
    {
        this.mailingHistoryRepository = mailingHistoryRepository;
    }

    public List<MailingHistory> getAll(Long id)
    {
        return mailingHistoryRepository.findAllById(List.of(id));
    }
}
