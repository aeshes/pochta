package aoizora.service;

import aoizora.domain.Mailing;
import aoizora.domain.MailingStatus;
import aoizora.domain.MailingType;
import aoizora.repository.MailingRepository;
import org.springframework.stereotype.Service;

@Service
public class MailingService
{
    private final MailingRepository mailingRepository;

    public MailingService(MailingRepository mailingRepository)
    {
        this.mailingRepository = mailingRepository;
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
}
