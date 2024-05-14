package aoizora.converter;

import aoizora.domain.Mailing;
import aoizora.model.MailingDTO;
import org.springframework.stereotype.Component;

@Component
public class MailingConverter implements Converter<Mailing, MailingDTO>
{
    @Override
    public MailingDTO convert(Mailing source)
    {
        var target = new MailingDTO();

        target.setId(source.getId());
        target.setRecipient(source.getRecipient());
        target.setType(source.getType());
        target.setAddress(source.getAddress());
        target.setPostcode(source.getPostcode());
        target.setStatus(source.getStatus());

        return target;
    }
}
