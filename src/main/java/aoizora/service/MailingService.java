package aoizora.service;

import aoizora.domain.Mailing;
import aoizora.domain.MailingHistory;
import aoizora.domain.MailingStatus;
import aoizora.domain.MailingType;
import aoizora.repository.MailingHistoryRepository;
import aoizora.repository.MailingRepository;
import aoizora.repository.PostOfficeRepository;
import org.springframework.stereotype.Service;

@Service
public class MailingService
{
    private final MailingRepository mailingRepository;
    private final PostOfficeRepository postOfficeRepository;
    private final MailingHistoryRepository mailingHistoryRepository;

    public MailingService(MailingRepository mailingRepository,
                          PostOfficeRepository postOfficeRepository,
                          MailingHistoryRepository mailingHistoryRepository)
    {
        this.mailingRepository = mailingRepository;
        this.postOfficeRepository = postOfficeRepository;
        this.mailingHistoryRepository = mailingHistoryRepository;
    }

    public Mailing register(String recipient, MailingType type, String address, int postcode)
    {
        var mailing = new Mailing();

        mailing.setRecipient(recipient);
        mailing.setType(type);
        mailing.setAddress(address);
        mailing.setPostcode(postcode);
        mailing.setStatus(MailingStatus.ON_THE_WAY);

        return mailingRepository.save(mailing);
    }

    public Mailing forward(long mailingId, long from, long to)
    {
        var mailing = mailingRepository.findById(mailingId);

        mailing.ifPresent(it -> {
            var officeFrom = postOfficeRepository.getOne(from);
            var officeTo = postOfficeRepository.getOne(to);

            it.setPostcode(officeTo.getPostcode());

            // TODO сделать запись в историю
            var history = new MailingHistory();

            history.setMailingId(it.getId());
            history.setFromPostcode(officeFrom.getPostcode());
            history.setToPostcode(officeTo.getPostcode());

            mailingHistoryRepository.save(history);
        });

        return mailing.get();
    }
}
