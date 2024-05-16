package aoizora.converter;

import aoizora.domain.MailingHistory;
import aoizora.model.HistoryDTO;
import org.springframework.stereotype.Component;

@Component
public class HistoryConverter implements Converter<MailingHistory, HistoryDTO>
{
    @Override
    public HistoryDTO convert(MailingHistory source)
    {
        var target = new HistoryDTO();

        target.setMailingId(source.getMailingId());
        target.setFromPostcode(source.getFromPostcode());
        target.setToPostcode(source.getToPostcode());

        return target;
    }
}
